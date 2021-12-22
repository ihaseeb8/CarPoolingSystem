package com.example.aproj.FileHandlers;

import java.io.FileWriter;
import java.io.IOException;

public class FeedbackWriter implements Runnable{

    public String feedback;

    public boolean writeFeedback(){

        try{
            FileWriter writer = new FileWriter("src/main/resources/com/example/aproj/Files/Feed Backs.txt" , true);
            writer.write(System.getProperty( "line.separator" ));
            writer.write(feedback);
            feedback = "";
            writer.close();
            return true;
        }
        catch (IOException e)
        {
            feedback = "";
            System.out.println("An error Occurred !");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void run() {
        writeFeedback();
    }
}
