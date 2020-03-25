package com.masterchallenge.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoadMapServiceTest {
    @Test
    public void testCitiesConnected(){
        RoadMapService roadMapService = new RoadMapServiceImpl();
        assertTrue(roadMapService.areCitiesConnected("Boston", "New York"));
    }

    @Test
    public void testCitiesDisconnected(){
        RoadMapService roadMapService = new RoadMapServiceImpl();
        assertFalse(roadMapService.areCitiesConnected("Boston", "Nowhere"));
    }


}