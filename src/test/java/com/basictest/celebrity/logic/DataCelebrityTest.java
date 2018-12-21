package com.basictest.celebrity.logic;


import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import java.io.IOException;

import static org.junit.Assert.*;

public class DataCelebrityTest {

    private DataCelebrity dataCelebrity;
    private ClassLoader classLoader;



    @Before
    public void init() {
        dataCelebrity = new DataCelebrity();
        classLoader = getClass().getClassLoader();

    }

    @Test
    public void getCelebrityIdKO(){
        int res = dataCelebrity.getCelebrityId("error.txt");
        assertEquals(res,-1);
    }



    @Test
    public void getCelebrityId1KO(){
        String fileName = "test1ko.txt";
        copyFile(fileName);
        int res = dataCelebrity.getCelebrityId(fileName);
        assertEquals(res,-1);
        deleteFile(fileName);
    }

    @Test
    public void getCelebrityId2KO(){
        String fileName = "test2ko.txt";
        copyFile(fileName);
        int res = dataCelebrity.getCelebrityId(fileName);
        assertEquals(res,-1);
        deleteFile(fileName);
    }


    @Test
    public void getCelebrityId1Ok(){
        String fileName = "test1ok.txt";
        copyFile(fileName);
        int res = dataCelebrity.getCelebrityId(fileName);
        assertEquals(res,2);
        deleteFile(fileName);
    }

    @Test
    public void getCelebrityId2Ok(){
        String fileName = "test2ok.txt";
        copyFile(fileName);
        int res = dataCelebrity.getCelebrityId(fileName);
        assertEquals(res,2);
        deleteFile(fileName);
    }

    private void copyFile(String fileName){
        try {
            File file = new File(fileName);
            FileUtils.copyInputStreamToFile(classLoader.getResourceAsStream(fileName), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFile(String fileName){
        File file = new File(fileName);
        file.delete();
    }




}
