package com.masterchallenge.services;

import com.masterchallenge.repository.FileLoader;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileLoaderTest {

    @Test
    public void testFileLoaded(){
        FileLoader loader = new FileLoader();
        assertTrue(loader.load().size() > 0);
    }

    @Test
    public void testFailedToLoadFile(){
        FileLoader loader = new FileLoader("no-file");
        assertEquals(loader.load().size(), 0);
    }

    @Test
    public void testMalformedFile(){
        FileLoader loader = new FileLoader("malformedFile.txt");
        assertEquals(loader.load().size(), 0);
    }
}
