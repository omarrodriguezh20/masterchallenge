package com.masterchallenge.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class FileLoader {

    Logger logger = LoggerFactory.getLogger(FileLoader.class);
    private String fileName = "city.txt";

    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    public FileLoader() {
    }

    public RoadmapGraph<String> load() {
        Map<String, String> roadMap = new HashMap<>();
        ClassLoader classLoader = RoadMapSingleton.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        RoadmapGraph<String> roadmapGraph = new RoadmapGraph<>();
        if (inputStream == null) {
            logger.error(String.format("The file - %s - couldn't be found", fileName));
            return roadmapGraph;
        }

        try {
            try (InputStreamReader inputBuffer = new InputStreamReader(inputStream);
                 BufferedReader bufferedReader = new BufferedReader(inputBuffer)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length != 2) {
                        logger.error(String.format("The file - %s - is malformed", fileName));
                        return roadmapGraph;
                    }
                    roadMap.put(values[0].trim(), values[1].trim());
                }
            }
        } catch (IOException e) {
            logger.error("An error has occurred during the load of file", e);
        }


        roadMap.keySet()
                .forEach(roadmapGraph::addVertex);

        roadMap.keySet()
                .forEach(e -> roadmapGraph.addEdge(e, roadMap.get(e), true));

        return roadmapGraph;
    }
}
