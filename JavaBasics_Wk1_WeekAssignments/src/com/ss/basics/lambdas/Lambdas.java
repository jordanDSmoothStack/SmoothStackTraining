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

    public static void main(String[] args) {
        Integer[][] testCases = {{1,4}, {2,5}, {3,898},{1,3},{2,12}};
        System.out.println();
        for (int i = 0; i < testCases.length; i++){
            Integer[] currTestCase = testCases[i];
            if (currTestCase[0] == 1){
                System.out.println(Lambdas.isOdd().unary(currTestCase[1]));
            }
            if (currTestCase[0] == 2){
                System.out.println(Lambdas.isPrime().unary(currTestCase[1]));
            }
            if (currTestCase[0] == 3){
                System.out.println(Lambdas.isPalindrome().unary(currTestCase[1]));
            }
        }
        System.out.println();
    }
}
