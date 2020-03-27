package com.masterchallenge.repository;

public class RoadMapSingleton {
    private static RoadmapGraph<String> INSTANCE;

    static{
        FileLoader loader = new FileLoader();
        INSTANCE = loader.load();
    }

    public static RoadmapGraph<String> getInstance() {
        return INSTANCE;
    }
}
