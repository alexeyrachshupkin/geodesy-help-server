package com.geo.geodesyhelpserver.controller;

import com.geo.geodesyhelpserver.model.project.AverageCoordinate;
import com.geo.geodesyhelpserver.service.AverageCoordinateService;
import com.geo.geodesyhelpserver.service.CoordinateService;
import com.geo.geodesyhelpserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AverageCoordinateController {

    private AverageCoordinateService averageCoordinateService;
    private ProjectService projectService;
    private CoordinateService coordinateService;

    @Autowired
    public AverageCoordinateController(AverageCoordinateService averageCoordinateService, ProjectService projectService,
                                       CoordinateService coordinateService) {
        this.averageCoordinateService = averageCoordinateService;
        this.projectService = projectService;
        this.coordinateService = coordinateService;
    }


    @GetMapping(path = "/sortCoordinate", produces = "application/json")
    public List<AverageCoordinate> sortCoordinate(@RequestParam("id") String id){
        List<AverageCoordinate> averageCoordinateList = averageCoordinateService
                .sortCoordinate(coordinateService.findByProjectId(Long.parseLong(id)),0.100);
        return averageCoordinateList;
    }
}
