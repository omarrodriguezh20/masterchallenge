package com.masterchallenge.services;

import com.masterchallenge.repository.FileLoader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileLoaderTest {

    @Test
    public void testFileLoaded(){
        FileLoader loader = new FileLoader();
        assertTrue(loader.load().getVertexCount() > 0);
    }

    @Test
    public void testFailedToLoadFile(){
        FileLoader loader = new FileLoader("no-file");
        assertEquals(loader.load().getVertexCount(), 0);
    }

    @Test
    public void testMalformedFile(){
        FileLoader loader = new FileLoader("malformedFile.txt");
        assertEquals(loader.load().getVertexCount(), 0);
    }
}
