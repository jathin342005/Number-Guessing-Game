import java.util.Random;
import javax.swing.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 1;
        int max = 100;
        int numberToGuess = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        int maxAttempts = 10;
        boolean hasGuessedCorrectly = false;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\nGuess a number between 1 and 100.\nYou have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            String input = JOptionPane.showInputDialog("Enter your guess (Attempt " + (attempts + 1) + "):");

            // If user clicks cancel
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game canceled. The number was: " + numberToGuess);
                return;
            }

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
            }
        }

        if (hasGuessedCorrectly) {
            int score = (maxAttempts - attempts + 1) * 10;
            JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.\nYour score: " + score);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! You've used all attempts.\nThe correct number was: " + numberToGuess);
        }
    }
}
