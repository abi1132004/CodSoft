import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        Random randGenerator = new Random();
        int maxAttempts = 5;
        int roundCount = 0;
        int winCount = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 0 and 100.");

        boolean continuePlaying = true;
        while (continuePlaying)
        {
            int secretNumber = randGenerator.nextInt(100) + 1;
            int attemptCount = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("\nRound " + (roundCount + 1) + ":");
            while (attemptCount < maxAttempts)
            {
                System.out.print("Enter your guess (Attempt " + (attemptCount + 1) + "): ");
                int playerGuess = inputScanner.nextInt();
                if (playerGuess == secretNumber)
                {
                    hasGuessedCorrectly = true;
                    winCount++;
                    break;
                } 
                else if (playerGuess < secretNumber)
                {
                    System.out.println("Too low! Try again.");
                } 
                else 
                {
                    System.out.println("Too high! Try again.");
                }
                attemptCount++;
            }
            roundCount++;
            if (hasGuessedCorrectly)
            {
                System.out.println("Congratulations! You guessed the number!");
            } 
            else 
            {
                System.out.println("Sorry, you've reached the maximum number of attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = inputScanner.next();
            continuePlaying = playAgainResponse.equalsIgnoreCase("yes");
        }
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + roundCount);
        System.out.println("Total wins: " + winCount);
        inputScanner.close();
    }
}