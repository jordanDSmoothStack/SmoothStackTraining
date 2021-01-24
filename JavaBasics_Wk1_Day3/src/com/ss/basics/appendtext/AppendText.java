package com.ss.basics.appendtext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
*
* Java file which creates a class called AppendText
* Created by Jordan Divina
*
*/

public class AppendText {

    /*
     *
     * Arguments @args
     * Main entry into this code
     * 
    */

    public static void main(String[] args) {
        String sampleText = "Jordan Divina is pretty cool";
        AppendText appender = new AppendText();
        appender.AddText("resources/in.txt", sampleText);
    }

    /*
     *
     * Arguments @String path, String text
     * Appends text to the file
     * Appends it to the end of the file rather than overwritting
     * Text is specified in the main method
     * 
    */

    public void AddText(String path, String text){
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(path, true))){
            bf.append(text);
            System.out.println("Successfully added the text");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
