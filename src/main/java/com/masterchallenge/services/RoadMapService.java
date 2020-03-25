package com.masterchallenge.services;

/**
 * RoadMap allows the user to perform operations over a network of
 * connected cities by roads.
 */
public interface RoadMapService {
    /**
     * Determines if two cities are connected by a network of roads
     * @param origin the city from where you want to travel
     * @param destination the city to where you want to travel
     * @return true if the two cities are connected, otherwise it returns false
     */
    Boolean areCitiesConnected(String origin, String destination);
}
