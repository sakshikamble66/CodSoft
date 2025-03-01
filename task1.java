import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game...");

        boolean playAgain;
        int totalScore = 0;

        do {
            totalScore += playRound(scan);
            System.out.println("Your total score = " + totalScore);
            System.out.print("Do you want to play another round...? (yes/no): ");
            playAgain = scan.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing. Your final score is: " + totalScore);
    }

    
    public static int playRound(Scanner scan) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        int attemptsLeft = 10; 
        int score = 0;

        System.out.println("\nI have generated a number between 1 and 100. You have " + attemptsLeft + " attempts to guess it.");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scan.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations... You guessed the correct number.");
                score = attemptsLeft * 10; 
                break;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }

            attemptsLeft--;

            if (attemptsLeft > 0) {
                System.out.println("Attempts remaining: " + attemptsLeft);
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }
        }

        return score;
    }
}