package com.masterchallenge.repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {
    private String fileName = "city.txt";
    public Map<String, String> load() throws FileNotFoundException {
        Map<String, String> roadMap = new HashMap<>();
        ClassLoader classLoader = RoadMapSingleton.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException(String.format("File not found %s", fileName));
        }

        try {
            try (InputStreamReader inputBuffer = new InputStreamReader(inputStream);
                 BufferedReader bufferedReader = new BufferedReader(inputBuffer)) {
                bufferedReader.lines().forEach(line -> {
                    String[] values = line.split(",");
                    if (values.length != 2) {
                        throw new IllegalStateException(String.format("Malformed cities configuration file %s", fileName));
                    }
                    roadMap.put(values[0].trim(), values[1].trim());
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roadMap;
    }
}
