package com.masterchallenge.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoadMapServiceTest {

    @Autowired
    RoadMapService roadMapService = new RoadMapServiceImpl();

    @Test
    public void testCitiesConnected() {
        assertTrue(roadMapService.areCitiesConnected("Boston", "New York"));
    }

    @Test
    public void testCitiesDisconnected() {
        assertFalse(roadMapService.areCitiesConnected("Boston", "Nowhere"));
    }

    @Test
    public void testLongestPath() {
        assertTrue(roadMapService.areCitiesConnected("Philadelphia", "New York"));
    }


}