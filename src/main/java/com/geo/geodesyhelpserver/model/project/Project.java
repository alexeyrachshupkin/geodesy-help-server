package com.geo.geodesyhelpserver.model.project;

import com.geo.geodesyhelpserver.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Project extends BaseEntity {

    private String name;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "project_file_id")
    private ProjectFile projectFile;

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
