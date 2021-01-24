package com.ss.basics.countcharacters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
*
* Java file which creates a class called CountCharacters
* Created by Jordan Divina
*
*/

public class CountCharacters {

    /*
     *
     * Arguments @args
     * Main entry into this code
     * If it is a string, like "boy", then it checks each letter in that argument
     * The code below can be done more elegantly
     * 
    */
    
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Please provide a character by adding command arguments");
        }
        else{
            String pathToFile = "/Users/jordandivina/Documents/GitHub/SmoothStackAccountTraining/SmoothStackTraining/JavaBasics_Wk1_Day3/resources/out.txt";
            System.out.println("");
            for (int i = 0; i < args.length; i++){
                if (args[i].length() > 1){
                    System.out.println("This Command argument '" + args[i] + "' has more than one character. We will count the number of occurences for each character...");
                    System.out.println("");
                    for (int j = 0; j < args[i].length(); j++){
                        Integer numberOfOccurences = findOccurences(pathToFile, args[i].charAt(j));
                        System.out.println("Number of occurences: " + numberOfOccurences + " for character '" + args[i].charAt(j) + "' in the current resource.");
                        System.out.println("");
                    }
                }
                else{
                    System.out.println("This Command argument '" + args[i] + "' has only one character.");
                    System.out.println("");
                    Integer numberOfOccurences = findOccurences(pathToFile, args[i].charAt(0));
                    System.out.println("Number of occurences: " + numberOfOccurences + " for character '" + args[i].charAt(0) + "' in the current resource.");
                    System.out.println("");
                }
            }
        }
    }

    /*
     *
     * Arguments @String path, String Character
     * Returns an Integer for this user
     * Checks a file for number of occurences
     * This code can be done a bit more elegantly...
     * 
    */
    public static Integer findOccurences(String path, char character){
        Integer tempInt = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            int j = 0;
            while ((j = bf.read()) != -1){
                char tempChar = (char)j;
                if (tempChar == character){
                    tempInt += 1;
                }
            }
            return tempInt;
        }
        catch (IOException e){
            System.out.println("An error has occured. Please check the path you are providing is a file rather than a directory... ");
            return 0;
        }
    }
}
