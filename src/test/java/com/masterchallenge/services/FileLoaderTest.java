package com.masterchallenge.services;

import com.masterchallenge.repository.FileLoader;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertThrows;

public class FileLoaderTest {
    @Test
    public void testFailedToLoadFile(){
        FileLoader loader = new FileLoader("no-file");
        assertThrows(FileNotFoundException.class, loader::load);
    }

    @Test
    public void testMalformedFile(){
        FileLoader loader = new FileLoader("malformedFile.txt");
        assertThrows(IllegalStateException.class, loader::load);
    }
}
