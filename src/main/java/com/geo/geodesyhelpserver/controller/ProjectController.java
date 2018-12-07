package com.geo.geodesyhelpserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geo.geodesyhelpserver.dto.NewProjectDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @PostMapping(path = "/createProject",consumes = "application/json", produces = "application/json")
    public String createProject(@RequestBody NewProjectDto project){


        System.out.println(getJsonString(project));
        return "{" +
                "\"status\": \"success\"" +
                "}";
    }

    public String getJsonString(Object obj){
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
