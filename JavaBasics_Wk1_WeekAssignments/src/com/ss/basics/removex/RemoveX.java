package com.ss.basics.removex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


    /** 
     * @Author Jordan Divina
     * Removes the x's from each string in a string array
     */

public class RemoveX {

    
    /** 
     * @param a
     * @return String
     */
    public static String helperFunction(String a){
        return a.replace("x", "");
    }

    
    /** 
     * @param arr
     * @return List<String>
     */
    public static List<String> noX(List<String> arr){
        return arr.stream().map(x -> helperFunction(x)).collect(Collectors.toList());
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        List<String> sampleArr = Arrays.asList("xdsc", "xxx", "", "as", "bob", "xbox", "theboxx");
        List<String> resultArr = noX(sampleArr);
        System.out.println();
        System.out.println("This is our sample string: " + sampleArr);
        System.out.println("======================================");
        System.out.println("After removing the x's: " + resultArr);
        System.out.println();



    }
}
