package com.geo.geodesyhelpserver.model.project;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.geo.geodesyhelpserver.config.LocalDateTimeSerializer;
import com.geo.geodesyhelpserver.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Project extends BaseEntity {

    private String name;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_file_id")
    private ProjectFile projectFile;

    public Project() {
    }

    public Project(String name, LocalDateTime date, ProjectFile projectFile) {
        this.name = name;
        this.date = date;
        this.projectFile = projectFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ProjectFile getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(ProjectFile projectFile) {
        this.projectFile = projectFile;
    }
}
