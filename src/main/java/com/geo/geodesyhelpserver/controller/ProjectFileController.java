package com.geo.geodesyhelpserver.controller;

import com.geo.geodesyhelpserver.model.project.ProjectFile;
import com.geo.geodesyhelpserver.repository.ProjectFileRepository;
import com.geo.geodesyhelpserver.service.ProjectFileService;
import com.geo.geodesyhelpserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectFileController {

    private ProjectFileService projectFileService;
    private ProjectService projectService;

    @Autowired
    public ProjectFileController(ProjectFileService projectFileService, ProjectService projectService) {
        this.projectFileService = projectFileService;
        this.projectService = projectService;
    }

    @GetMapping(path = "/getProjectFile", produces = "application/json")
    public ProjectFile getProjectFile(@RequestParam("projectId") String projectId) {
        return projectService.findById(Long.parseLong(projectId)).getProjectFile();
    }
}
