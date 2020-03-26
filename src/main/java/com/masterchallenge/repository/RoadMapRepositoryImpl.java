package com.masterchallenge.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/*
  Simple HashMap based implementation of the road map repository, it is based on the premise
  that we only have one existing node from one city to another. With this premise
  the value from a given key acts as a key for the next hop
 */
@Repository
public class RoadMapRepositoryImpl implements RoadMapRepository {

    private Map<String, String> roadMap = RoadMapSingleton.getInstance();
    private String currentCity = "";
    private String destination = "";

    public RoadMapRepositoryImpl() {
    }


    public Map<String, String> getRoadMap() {
        return this.roadMap;
    }

    public void setOrigin(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean hasCurrentCity() {
        return roadMap.containsKey(currentCity);
    }

    public Boolean haveReachDestination() {
        return roadMap.get(currentCity).equals(destination);
    }

    public void travel() {
        currentCity = roadMap.get(currentCity);
    }
}
