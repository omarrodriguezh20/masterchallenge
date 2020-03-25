package com.masterchallenge.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap based implementation of the road map service, it is based on the premise
 * that we only have one existing node from one city to another. With this premise
 * the value from a given key acts as a key for the next hop
 */
@Service
public class RoadMapServiceImpl implements RoadMapService {
    Map<String, String> connectedCities = new HashMap<String, String>();

    public RoadMapServiceImpl() {
        connectedCities.put("Boston", "New York");
    }

    public Boolean areCitiesConnected(String origin, String destination){
        boolean found = false;
        String currentCity = origin;
        while(true){
            if( !connectedCities.containsKey(currentCity)) {
                break;
            }
            if( connectedCities.get(currentCity).equals(destination)) {
                found = true;
                break;
            }
            currentCity = connectedCities.get(currentCity);
        }
        return found;
    }
}
