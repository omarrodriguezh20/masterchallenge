package com.masterchallenge.services;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoadMapRepositoryImpl implements RoadMapRepository {
    private String fileName = "city.txt";

    public RoadMapRepositoryImpl() {
    }

    public RoadMapRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, String> loadRoadMap() throws Exception {
        Map<String, String> roadMap = new HashMap<>();
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
        return roadMap;
    }
}
