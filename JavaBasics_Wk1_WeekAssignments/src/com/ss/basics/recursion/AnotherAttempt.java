package com.ss.basics.recursion;

public class AnotherAttempt {
    
    public static boolean GroupSumClump(Integer start, Integer[] list, Integer target){
        if (start >= list.length){
            return 0 == target;
        }

        Integer onGoingSum = 0;
        Integer newStart = start;

        for (int i = start; i < list.length; i++){
            if (list[start] != list[i]){
                break;
            }
            else{
                onGoingSum += list[i];
                newStart++;
            }
        }

        if (GroupSumClump(newStart, list, target - onGoingSum) || GroupSumClump(newStart, list, target)){
            return true;
        }
        
        return false;

    }

    public static void main(String[] args) {
        Integer[] sampleList = {2,4,4,8};
        Integer sampleTarget = 14;
        System.out.println("");
        System.out.println("Using the conditions in the problem statement, can we add any combination from our list to get a target of " + sampleTarget);
        System.out.println("");
        System.out.println("To see if it is possible: " + GroupSumClump(0, sampleList, sampleTarget));
        System.out.println("");
    }
}
