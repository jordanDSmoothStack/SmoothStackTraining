package com.ss.basics.lambdas;

/*
 * For assignment 1, lambdas
 * Created the functions below isOdd, isPrime, and isPalindrome
 * which return a lambda expression
 * @Created by Jordan Divina
*/

public class Lambdas {
    
    @FunctionalInterface
    public interface PerformOperation{
        String unary(Integer a);
    }

     /** 
      * @return PerformOperation
      */
    static PerformOperation isOdd(){
        return (a) -> {
            if (a % 2 == 0){
                return "EVEN";
            }
            return "ODD";
        };
    }

    
    /** 
     * @return PerformOperation
     */
    static PerformOperation isPrime(){
        return (a) -> {
            if (a == 0 || a == 1 || a < 0){
                return "NEITHER";
            }
            int currentCounter = 2;
            while (currentCounter < a){
                if (a % currentCounter == 0){
                    return "COMPOSITE";
                }
                currentCounter++;
            }
            return "PRIME";
        };
    }

    
    /** 
     * @return PerformOperation
     */
    static PerformOperation isPalindrome(){
        return (a) -> {
            StringBuilder tempVal = new StringBuilder(Integer.toString(a));
            StringBuilder reverseVal = new StringBuilder(tempVal).reverse();
            if (tempVal.toString().equals(reverseVal.toString())){
                return "PALINDROME";
            }
            else{
                return "NOT PALINDROME";
            }
        };
    }
}
