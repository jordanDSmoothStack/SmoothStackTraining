package com.ss.basics.listdirectories;
import java.io.File;

/*
*
* Java file which creates a class called List Directories
* Created by Jordan Divina
*
*/

public class ListDirectories {

    /*
     *
     * Arguments @args
     * Main entry into this code
     * 
    */

    public static void main(String[] args) {
        final File mainDirectory = new File("/Users/jordandivina/Documents/GitHub/SmoothStackAccountTraining/SmoothStackTraining/JavaBasics_Wk1_Day3/resources");
        ListDirectories ld = new ListDirectories();
        System.out.println("");
        System.out.println("Checking the files and subdirectories in " + mainDirectory.getName());
        ld.recursiveList(mainDirectory, 0);
    }
    
    /*
     *
     * Arguments @final File folder
     * Checks the objects of the list recursively
     * If an specific item is a subdirectory, then calls the function again on that item
     * 
    */

    public void recursiveList(final File folder, int space){
        for (File tempVal: folder.listFiles()){
            if (tempVal.isDirectory()){
                System.out.println("The following is the name of this subdirectory: " + tempVal.getName());
                if (tempVal.listFiles().length == 0){
                    System.out.println(" ".repeat(space * 4) + tempVal.getName() + " does not contain any files...");
                }
                else{
                    recursiveList(tempVal, space + 1);
                }
            }
            else{
                System.out.println(" ".repeat(space * 4) + "File: " + tempVal.getName());
            }
        }
    }
}