package com.masterchallenge.repository;

import com.masterchallenge.controller.RoadMapController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RoadMapSingleton {
    private static Map<String, String> INSTANCE;

    static{
        FileLoader loader = new FileLoader();
        INSTANCE = loader.load();
    }

    public static Map<String, String> getInstance() {
        return INSTANCE;
    }
}
