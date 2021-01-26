package com.ss.basics.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *
 * Class which implements problem 2)
 * 
 * Given a list of integer, return a comma seperated string where the numbers either have "o" for odd and "e" for even 
 * 
 * 
*/

public class CommaSeparated {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Random randomInt = new Random();
        List<Integer> sampleList = new ArrayList<Integer>(10);
        StringBuilder holder = new StringBuilder("");

        for (int i = 0; i < 10; i++){
            sampleList.add(randomInt.nextInt(100) + 1);
        }
        sampleList.forEach(x -> holder.append(addLetter(x).append(",")));
        holder.deleteCharAt(holder.lastIndexOf(","));
        String finalAnswer = holder.toString();
        System.out.println("");
        System.out.println(finalAnswer);
        System.out.println("");
    }
    
    
    /** 
     * @param number
     * @return StringBuilder
     */
    public static StringBuilder addLetter(Integer number){
        StringBuilder tempString = new StringBuilder();
        if (number % 2 == 0){
            tempString.append("e");
        }
        else{
            tempString.append("o");
        }
        tempString.append(number);
        return tempString;
    }
}
