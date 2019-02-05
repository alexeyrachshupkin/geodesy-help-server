package com.geo.geodesyhelpserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.geodesyhelpserver.dto.NewProjectDto;
import com.geo.geodesyhelpserver.dto.RequestSaveProjectDto;
import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.model.project.Project;
import com.geo.geodesyhelpserver.model.project.ProjectFile;
import com.geo.geodesyhelpserver.service.CoordinateService;
import com.geo.geodesyhelpserver.service.ProjectFileService;
import com.geo.geodesyhelpserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;
    private ProjectFileService projectFileService;
    private CoordinateService coordinateService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectFileService projectFileService, CoordinateService coordinateService) {
        this.projectService = projectService;
        this.projectFileService = projectFileService;
        this.coordinateService = coordinateService;
    }

    @PostMapping(path = "/createProject",consumes = "application/json", produces = "application/json")
    public RequestSaveProjectDto createProject(@RequestBody NewProjectDto projectDto){
        System.out.println(getJsonString(projectDto));
        Project project = new Project(projectDto.getName(),projectDto.getDate(),
                new ProjectFile(projectDto.getProjectFile().getName(),projectDto.getProjectFile().getSize(),
                        projectDto.getProjectFile().getType(),projectDto.getProjectFile().getBase64()));
        project = projectService.saveOrUpdate(project);
        List<Coordinate> coordinateList = projectFileService.parseProjectFile(project);
        coordinateList = coordinateService.saveAll(coordinateList);
        if(project!=null && coordinateList!=null && !coordinateList.isEmpty()){
            return new RequestSaveProjectDto(project.getId(),"");
        } else {
            return new RequestSaveProjectDto(null,"Ошибка при создании проекта, обратитесь к администратору!");
        }
    }

    @GetMapping(path = "/projects")
    public List<Project> findProjects(){
        return projectService.findAll();
    }

    @GetMapping(path = "/project", produces = "application/json")
    public Project findById(@RequestParam("id") String id){
        return projectService.findById(Long.parseLong(id));
    }

    private String getJsonString(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}
