package number.guessing.game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

     public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Guess the Number!");

		  int startingNum = 1;
		  int lastNum = 100;
		  int maxAttempts = 10;
		  int score = playGame(scanner, random, startingNum, lastNum, maxAttempts);

		  System.out.println("Your final score: " + score);

		     
		    }

		    private static int playGame(Scanner scanner, Random random, int startingNum, int lastNum, int maxAttempts) {
		        int randomNumber = random.nextInt(lastNum - startingNum + 1) + startingNum;
		        int score = 0;

		        System.out.println("Try to guess the number between " + startingNum + " and " + lastNum);

		        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
		            //  user for a guess
		            System.out.print("Attempt " + attempts + ": Enter the generated random number: ");
		            int guess = scanner.nextInt();

		            // Check if the guess is correct, too low, or too high
		            if (guess == randomNumber) {
		                System.out.println("Wow! You guessed the correct number!");
		                score += (maxAttempts - attempts + 1) * 10; // Adjust scoring as needed
		                break;
		            } else if (guess < randomNumber) {
		                System.out.println("Too low! Try again.");
		            } else {
		                System.out.println("Too high! Try again.");
		            }

		            // Check if the user has run out of attempts
		            if (attempts == maxAttempts) {
		                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
		            }
		        }

		        return score;
		    }
		}
