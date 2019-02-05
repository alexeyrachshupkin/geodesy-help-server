package com.geo.geodesyhelpserver.controller;


import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.service.CoordinateService;
import com.geo.geodesyhelpserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CoordinateController {

    private CoordinateService coordinateService;
    private ProjectService projectService;

    @Autowired
    public CoordinateController(CoordinateService coordinateService, ProjectService projectService) {
        this.coordinateService = coordinateService;
        this.projectService = projectService;
    }

    @GetMapping(path = "/findProjectCoordinates",  produces = "application/json")
    public List<Coordinate> findCoordinateByProject(@RequestParam("id") String id){
        return coordinateService.findByProjectId(Long.parseLong(id));
    }

}
