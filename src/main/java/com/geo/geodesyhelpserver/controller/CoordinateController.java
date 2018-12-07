package com.geo.geodesyhelpserver.controller;


import com.geo.geodesyhelpserver.model.project.Coordinate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CoordinateController {

    @GetMapping("/coordinates")
    public List<Coordinate> findAllCoordinate(){
        return Arrays.asList(new Coordinate(1456.1234,8799.1234,7895.1254));
    }

}
