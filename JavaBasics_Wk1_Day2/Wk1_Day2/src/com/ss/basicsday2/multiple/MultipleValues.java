package com.ss.basicsday2.multiple;

public class MultipleValues {
    public static void main(String[] args) {
        Integer commandSum = 0;
        for (int i = 0; i < args.length; i++){
            try{
                Integer tempVal =  Integer.parseInt(args[i]);
                commandSum += tempVal;
            }
            catch (NumberFormatException e){
                System.out.println("The value of " + args[i] + " is not a number.");
                System.out.println("");
            }
        }
        System.out.println(commandSum);
    }
}
