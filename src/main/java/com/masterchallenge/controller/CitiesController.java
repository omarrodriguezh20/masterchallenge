package com.masterchallenge.controller;

import com.masterchallenge.services.RoadMapService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Determine if two cities are connected. Two cities are considered\n" +
            "connected if there’s a series of roads that can be traveled from one city\n" +
            "to another.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cities route processed.", response = CitiesController.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = Exception.class)})
    @GetMapping("/connected")
    public ResponseEntity<String> connected(@RequestParam(required = false) String origin, @RequestParam(required = false) String destination) {
        if (origin == null || destination == null) {
            return new ResponseEntity<>("no", HttpStatus.OK);
        }

        return new ResponseEntity<>(
                roadMapService.areCitiesConnected(origin, destination) ? "yes": "no" ,
                HttpStatus.OK);
    }

}
