package com.masterchallenge.repository;

import java.io.IOException;
import java.util.Map;

/**
 * This repository provides the operations needed to travel in a map of road connected cities
 */
public interface RoadMapRepository {
    void loadRoadMap () throws IOException;
    Map<String, String> getRoadMap();
    void setOrigin(String currentCity);
    void setDestination(String destination);
    Boolean hasCurrentCity();
    Boolean haveReachDestination();
    void travel();
}
