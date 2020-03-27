package com.masterchallenge.repository;


/**
 * This repository provides the operations needed to travel in a map of road connected cities
 */
public interface RoadMapRepository {
    RoadmapGraph<String> getRoadMap();

    boolean areCitiesConnected(String origin, String destination);
}
