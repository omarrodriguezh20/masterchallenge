package com.masterchallenge.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/*
  Simple HashMap based implementation of the road map repository, it is based on the premise
  that we only have one existing node from one city to another. With this premise
  the value from a given key acts as a key for the next hop
 */
@Repository
public class RoadMapRepositoryImpl implements RoadMapRepository {

    private String fileName = "city.txt";

    private Map<String, String> roadMap = new HashMap<>();
    private String currentCity = "";
    private String destination = "";

    public RoadMapRepositoryImpl() {
    }

    public RoadMapRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    public void loadRoadMap() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if(inputStream == null){
            throw new FileNotFoundException(String.format("File not found %s", fileName));
        }

        try(    InputStreamReader inputBuffer = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputBuffer)){
            bufferedReader.lines().forEach(line->{
                String[] values = line.split(",");
                if(values.length != 2){
                    throw new IllegalStateException(String.format("Malformed cities configuration file %s", fileName));
                }
                roadMap.put(values[0].trim(), values[1].trim());
            });
        }
    }

    public Map<String, String> getRoadMap(){
        return this.roadMap;
    }

    public void setOrigin(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setDestination(String destination){
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
