package com.masterchallenge.controller;

import com.masterchallenge.services.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Autowired
    RoadMapService roadMapService;

    @GetMapping("/connected")
    public ResponseEntity<String> connected(@RequestParam(required = false) String origin, @RequestParam(required = false) String destination) {
        if (origin == null || destination == null) {
            return new ResponseEntity<String>("no", HttpStatus.OK);
        }

        return new ResponseEntity<String>(
                roadMapService.areCitiesConnected(origin, destination) ? "yes": "no" ,
                HttpStatus.OK);
    }

}
