package com.masterchallenge.services;

import java.util.Map;

/**
 * This repository provides the operations needed to travel in a map of road connected cities
 */
public interface RoadMapRepository {
    void loadRoadMap () throws Exception;
    Map<String, String> getRoadMap();
    void setOrigin(String currentCity);
    void setDestination(String destination);
    Boolean hasCurrentCity();
    Boolean haveReachDestination();
    void travel();
}
