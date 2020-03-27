package com.masterchallenge.services;

import com.masterchallenge.repository.RoadMapRepository;
import com.masterchallenge.repository.RoadMapRepositoryImpl;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RoadMapRepositoryTest {

    @Test
    public void testLoadRoadMap() {
        RoadMapRepository roadMapRepository = new RoadMapRepositoryImpl();
        try{
            Map<String, String> roadMap = roadMapRepository.getRoadMap();
            assertTrue(roadMap.keySet().size() > 0);
        }catch(Exception exception){
            fail();
        }
    }


}