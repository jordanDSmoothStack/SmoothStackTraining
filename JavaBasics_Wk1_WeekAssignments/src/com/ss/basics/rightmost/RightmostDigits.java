package com.ss.basics.rightmost;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

    /** 
     * @Author Jordan Divina
     * Returns the rightmost digits from any number
     */

public class RightmostDigits {
    
    
    /** 
     * @param a
     * @return Integer
     */

    public static Integer HelperFunction(Integer a){
        return (a % 10);
    }

    
    /** 
     * @param arr
     * @return List<Integer>
     */
    public static List<Integer> rightDigit(List<Integer> arr){
        return arr.stream().map(x -> HelperFunction(x)).collect(Collectors.toList());
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Random rd = new Random();
        List<Integer> integerList = new ArrayList<Integer>(10);
        for(int i = 0; i < 10; i ++){
            integerList.add(rd.nextInt(100) + 1);
        }
        List<Integer> resultArr = RightmostDigits.rightDigit(integerList);
        System.out.println();
        System.out.println("The random array we used to: " + integerList);
        System.out.println("============================================");
        System.out.println("The resulting array: " + resultArr);
        System.out.println();
    }
}
