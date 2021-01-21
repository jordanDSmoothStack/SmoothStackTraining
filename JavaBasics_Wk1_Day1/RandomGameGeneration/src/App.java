/*
*
* Random number generation game for a user
* Created by Joran Divina
*/

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a number (between 1 and 100), and guess our random number");
        Random smallRand = new Random();
        int rand = smallRand.nextInt((100-1) + 1) + 1;
        boolean guessCorrectly = false;
        int numberOfGuesses = 0;
        Scanner reader = new Scanner(System.in);
        while (!guessCorrectly){
            if (numberOfGuesses == 5){
                System.out.println("");
                System.out.println("Sorry");
                break;
            }
            if (numberOfGuesses > 0){
                System.out.println("");
                System.out.println("Keep on trying to get the correct number.");
                System.out.println("");
            }
            int theirGuess = reader.nextInt();
            if (rand - 10 <= theirGuess && theirGuess <= rand + 10){
                System.out.println("");
                System.out.println("You are in the range with your guess of: " + theirGuess);
                break;
            }
            numberOfGuesses += 1;
        }
        reader.close();
        System.out.println("The random number is: " + rand);
    }
}
