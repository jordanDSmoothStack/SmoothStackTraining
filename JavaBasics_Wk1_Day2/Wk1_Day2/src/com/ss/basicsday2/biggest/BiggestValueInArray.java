package com.ss.basicsday2.biggest;

import java.util.Arrays;
import java.util.Random;

/*
*
* Created by Jordan Divina
* This function creates a 2D array with random variables
* Then, it finds the location of the largest number in the 2d array  
* Then returns the output to the user as well as the array for user validation
*
*/

public class BiggestValueInArray {


    public static void main(String[] args){
        Integer[][] ourArray = createRandomArrayIntegers();
        System.out.println("This is our array: ");
        System.out.println("");
        for (int i = 0; i < ourArray.length; i++){
            System.out.println("Row " + i + " contains these values");
            System.out.println(Arrays.toString(ourArray[i]));
            System.out.println("");
        }
        Integer[] maxVal = findMaxPosition(ourArray);
        System.out.println("This is the max value: " + maxVal[2]);
        System.out.println("It is located at this row: " + maxVal[0] +". At this position: " + maxVal[1]);
    }

    /*
    *  
    * This function creates the array of random integers
    * It it set to have only 10 rows of 10 items each
    *
    */

    public static Integer[][] createRandomArrayIntegers(){
        Random rd = new Random();
        Integer[][] randomArray = new Integer[10][10];
        int counter = 0;
        while (counter < 10){
            for (int i = 0; i < 10; i++){
                randomArray[counter][i] = rd.nextInt();
            }
            counter += 1;
        }
        return randomArray;
    }

    /*
    *  
    * This function creates the array of random integers
    * It returns an array of three items . The first two items contain the coordinate whereas the last item is the actual max value
    *
    */

    public static Integer[] findMaxPosition(Integer[][] arr){
        Integer[] coordinates = new Integer[3];
        Integer maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (maxValue < arr[i][j]){
                    maxValue = arr[i][j];
                    coordinates[0] = i;
                    coordinates[1] = j;
                    coordinates[2] = maxValue;
                }
            }
        }
        return coordinates;
    }

}