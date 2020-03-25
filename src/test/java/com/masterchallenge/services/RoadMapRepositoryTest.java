package com.masterchallenge.services;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.*;

public class RoadMapRepositoryTest {

    @Test
    public void loadRoadMap() {
        RoadMapRepository roadMapRepository = new RoadMapRepositoryImpl();
        try{
            Map<String, String> roadMap = roadMapRepository.loadRoadMap();
            assertTrue(roadMap.keySet().size() > 0);
        }catch(Exception exception){
            fail();
        }
    }

    @Test
    public void failedToLoadFile(){
        RoadMapRepository roadMapRepository = new RoadMapRepositoryImpl("no-file");
        assertThrows(FileNotFoundException.class, roadMapRepository::loadRoadMap);
    }
}