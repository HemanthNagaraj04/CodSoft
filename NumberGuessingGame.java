import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean play_Again = true;
        System.out.println("Welcome to the Number Guessing Game!");

        while (play_Again) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean hasWon = false;
            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int user_Guess;
                if (scanner.hasNextInt()) {
                    user_Guess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }
                if (user_Guess == numberToGuess) {
                    System.out.println("Congradulations! You guessed the number!");
                    hasWon = true;
                    score++;
                    break;
                } else if (user_Guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            if (!hasWon) {
                System.out.println("Oops! You've used all attempts! The number was: " + numberToGuess);
            }
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                play_Again = false;
                System.out.println("\n👋 Thanks for playing! Your final score: " + score);
            }
        }
        scanner.close();
    }
}
