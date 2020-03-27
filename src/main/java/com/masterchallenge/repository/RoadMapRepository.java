package com.masterchallenge.repository;

import java.util.Map;

/**
 * This repository provides the operations needed to travel in a map of road connected cities
 */
public interface RoadMapRepository {
    Map<String, String> getRoadMap();
    void setOrigin(String currentCity);
    void setDestination(String destination);
    Boolean hasCurrentCity();
    Boolean haveReachDestination();
    void travel();
}
