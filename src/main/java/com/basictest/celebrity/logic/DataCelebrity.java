package com.basictest.celebrity.logic;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataCelebrity {

    private static final Logger logger = Logger.getLogger(DataCelebrity.class);

    public int getCelebrityId(String fileName){

        Map<Integer,Integer> noCelebrity = new HashMap<>();
        int idPeople = 0, current = 0, idCelebrity = -1;
        boolean goon;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            goon = scanner.hasNext();
            while (goon) {
                idPeople = scanner.nextLine().indexOf('1');
                goon = scanner.hasNext();
                if(idPeople >= 0) {
                    if (!noCelebrity.containsKey(idPeople)) {
                        if (idPeople < current) {
                            noCelebrity.put(idPeople, idPeople);
                        }
                    }
                }else {
                    idCelebrity = current;
                    goon = false;
                }
                current ++;
            }

        } catch (IOException e) {
            logger.error("celebrity.txt file must be in the same folder as the application (.jar)");
        }
        return idCelebrity;
    }


}
