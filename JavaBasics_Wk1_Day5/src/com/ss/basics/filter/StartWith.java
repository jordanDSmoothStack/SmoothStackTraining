package com.ss.basics.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *
 * Created by @Jordan Divina
 * For Problem 3 for Week 1 day 5
 * 
*/

public class StartWith {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        List<String> sampleArray = Arrays.asList("Sade", "Swae Lee", "Aubrey Graham", "Frank Ocean", "U2", "Metallica", "Lil Uzi", "Kanye West", "Queen", "asa", "aaa", "ace", "bad", "aced", "", "asian");
        List<String> filteredArr = sampleArray.stream().filter(x -> StartWith.lambdaHelperFunction(x) == true).collect(Collectors.toList());
        System.out.println();
        System.out.println(filteredArr);
        System.out.println();
    }
    

    
    /** 
     * @param a
     * @return boolean
     */
    public static boolean lambdaHelperFunction(String a){
        if (a.isEmpty()){
            return false;
        }
        if (a.charAt(0) == 97 && a.length() == 3){
            return true;
        }
        return false;
    }
}
