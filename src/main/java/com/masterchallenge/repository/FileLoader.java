package com.masterchallenge.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

    public Map<String, String> load() {
        Map<String, String> roadMap = new HashMap<>();
        ClassLoader classLoader = RoadMapSingleton.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            logger.error(String.format("The file - %s - couldn't be found", fileName));
            return roadMap;
        }

        try {
            try (InputStreamReader inputBuffer = new InputStreamReader(inputStream);
                 BufferedReader bufferedReader = new BufferedReader(inputBuffer)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length != 2) {
                        logger.error(String.format("The file - %s - is malformed", fileName));
                        return new HashMap<>();
                    }
                    roadMap.put(values[0].trim(), values[1].trim());
                }
            }
        } catch (IOException e) {
            logger.error("An error has occurred during the load of file", e);
        }
        return roadMap;
    }
}
