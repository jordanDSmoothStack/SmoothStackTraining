package com.ss.basics.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

   /** 
     * @Author Jordan Divina
     * Given an array of ints, is it possible to choose a group of some of the ints, 
     * such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and the identical value, 
     * they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, 
     * all as a group. (one loop can be used to find the extent of the identical values).
     */

public class RecursiveAssignment{

    
    /** 
     * @param arr
     * @param target
     * @return boolean
     */
    public static boolean recursiveGroupSum(List<Integer> arr, Integer target){

        if (target == 0){
            return true;
        }
        else if (arr.size() == 0 || target < 0){
            return false;
        }
        else{
            Integer firstValue = arr.get(0);
            List<Integer> tempArr = new ArrayList<Integer>(arr);
            tempArr.remove(0);
            return recursiveGroupSum(tempArr, target - firstValue) || recursiveGroupSum(tempArr, target);
        }
    }

    
    /** 
     * @param arr
     * @return HashMap<Integer, Integer>
     */
    public static HashMap<Integer, Integer> createHashMap(Integer[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer countOfAdjacentElements = 1;

        //Just checking if the array is either empty or has a length of one
        //In these cases, there can exist no adjacent elements

        if (arr.length == 0 || arr.length == 1){
            return map;
        }

        //For loop to find adjacements elements and put the count into the hasharray
        for(int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                if (countOfAdjacentElements != 1){
                    Integer alreadyStoredValue = map.getOrDefault(arr[i], 0);
                    countOfAdjacentElements += alreadyStoredValue;
                    map.put(arr[i], countOfAdjacentElements);
                }
                break;
            }
            if (arr[i] == arr[i + 1]){
                countOfAdjacentElements++;
            }
            if (arr[i] != arr[i + 1] && countOfAdjacentElements != 1){
                Integer alreadyStoredValue = map.getOrDefault(arr[i], 0);
                countOfAdjacentElements += alreadyStoredValue;
                map.put(arr[i], countOfAdjacentElements);
                countOfAdjacentElements = 1;
            }
        }
        return map;
    }

    
    /** 
     * @param arr
     * @param target
     * @return boolean
     */
    public static boolean recursiveHelper(Integer[] arr, Integer target){

        //Simple case to check
        if (arr.length == 0 && target != 0){
            return false;
        }

        if(arr.length == 1){
            if (arr[0] == target){
                return true;
            }
            else{
                return false;
            }
        }

        //We need to first see if there exists numbers that are both adjacent and identical in our array
        HashMap<Integer, Integer> repeatedIdenticalValues = createHashMap(arr);
        System.out.println();
        System.out.println("The number of occurences of identical adjacent values: " + repeatedIdenticalValues);

        if (!repeatedIdenticalValues.isEmpty()){

            //Calculating the sum of all the elements in the array
            Integer sum = 0;
            for (Integer i: arr){
                sum += i;
            }

            Integer hashMapSum = 0;
            for (Map.Entry<Integer, Integer> mapElement: repeatedIdenticalValues.entrySet()){
                Integer key = (Integer)mapElement.getKey();
                Integer value = (Integer)mapElement.getValue();
                hashMapSum += key * value;
            }
            if (hashMapSum == target || sum == target){
                return true;
            }
            else{
                return false;
            }
        }

        //Going to convert Integer[] to List<Integer> to make it easier for me...
        List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
        return recursiveGroupSum(list, target);
    }

    /** 
     * @param args
     */
    public static void main(String[] args) {
        Integer sampleTarget = 14;
        Integer[] sampleArr = {2,2,5,5,1,2,1,2};

        boolean isPossible = recursiveHelper(sampleArr, sampleTarget);
        System.out.println();
        System.out.println("Is it possible to add to the sum?: "+ isPossible);
        System.out.println();
    }
}
