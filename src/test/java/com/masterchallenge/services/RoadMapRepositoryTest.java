package com.masterchallenge.services;

import com.masterchallenge.repository.RoadMapRepository;
import com.masterchallenge.repository.RoadMapRepositoryImpl;
import com.masterchallenge.repository.RoadmapGraph;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RoadMapRepositoryTest {

    @Test
    public void testLoadRoadMap() {
        RoadMapRepository roadMapRepository = new RoadMapRepositoryImpl();
        try {
            RoadmapGraph<String> roadMapGraph = roadMapRepository.getRoadMap();
            assertTrue(roadMapGraph.getVertexCount() > 0);
        } catch (Exception exception) {
            fail();
        }
    }


}