package com.ss.basics.firstlambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  
 * Java class which contains some basics lambdas
 * that act on an array of strings
 * 
*/


public class BasicLambdas{
    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        //Our sample list

        System.out.println("");
        List<String> stringArr = Arrays.asList("Sade", "Swae Lee", "Aubrey Graham", "Frank Ocean", "U2", "Metallica", "Lil Uzi", "Kanye West", "Queen");
        System.out.println("Our sample list: " + stringArr);
        System.out.println("");

        //Sorting the string from shortest to longest
        List<String> shortToLong = stringArr.stream().sorted((x, y) -> {
            if (x.length() > y.length()){
                return 1;
            }
            if (x.length() < y.length()){
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
        System.out.println("Sorting the list from shortest to longest: " + shortToLong);
        System.out.println("");

        //Sorting the string from longest to shortest
        List<String> LongToShort = stringArr.stream().sorted((x, y) -> {
            if (x.length() > y.length()){
                return -1;
            }
            if (x.length() < y.length()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        System.out.println("Sorting the list from longest to shortest: " + LongToShort);
        System.out.println("");

        //Sorting the string by the first letter only
        List<String> alphabeticalSort = stringArr.stream().sorted((x, y) -> {
            if (x.charAt(0) > y.charAt(0)){
                return 1;
            }
            if (x.charAt(0)< y.charAt(0)){
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
        System.out.println("Sorting the list from the first character only: " + alphabeticalSort);
        System.out.println("");

        //Sorting the string by which words contain the letter e
        List<String> containE = stringArr.stream().sorted((x,y) -> {
            if (x.indexOf("e") > -1){
                return -1;
            }
            return 1;
        }).collect(Collectors.toList());

        System.out.println("Strings that contain 'e' first, then all the rest of the strings later:  " + containE);
        System.out.println("");

        //Sorting the string by which words contain the letter e
        List<String> containsWithHelperFunction = stringArr.stream().sorted((x,y) -> BasicLambdas.findCorrectOrdering(x, y)).collect(Collectors.toList());
        System.out.println("Strings that contain 'e' first, then all the rest of the strings later (using the helper function):  " + containsWithHelperFunction);
        System.out.println("");
    }

    
    /** 
     * @param x
     * @param y
     * @return int
     */
    public static int findCorrectOrdering(String x, String y){
        if (x.indexOf("e") > -1){
            return -1;
        }
        return 1;
    }
}
