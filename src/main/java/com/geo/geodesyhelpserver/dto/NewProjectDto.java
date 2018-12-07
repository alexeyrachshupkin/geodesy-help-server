package com.geo.geodesyhelpserver.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.geo.geodesyhelpserver.config.LocalDateTimeDeserializer;
import com.geo.geodesyhelpserver.config.LocalDateTimeSerializer;
import com.geo.geodesyhelpserver.model.project.ProjectFile;

import java.time.LocalDateTime;

public class NewProjectDto {

    private String name;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;
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
