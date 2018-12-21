package com.basictest.celebrity;




import com.basictest.celebrity.logic.DataCelebrity;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class App {
    private static final String FILENAME = "celebrity.txt";
    public static void main(String[] args) {
        BasicConfigurator.configure();
        DataCelebrity dataCelebrity = new DataCelebrity();
        int res = dataCelebrity.getCelebrityId(FILENAME);
        String message = res != -1 ? "The Celebrity ID is "+res: "No Celebrity ID was found in the file";
        System.out.println(message);


    }
}
