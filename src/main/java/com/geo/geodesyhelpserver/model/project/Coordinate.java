package com.geo.geodesyhelpserver.model.project;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geo.geodesyhelpserver.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Coordinate extends BaseEntity {

    private String name;
    private Double x;
    private Double y;
    private Double z;

    @Transient
    @JsonIgnore
    private boolean deleted;
    @ManyToOne
    @JsonIgnore
    private Project project;

    public Coordinate() {
    }

    public Coordinate(String name, Double x, Double y, Double z,Project project) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.project = project;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
