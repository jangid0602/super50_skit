/**
 * Filename - Input.java
 * Description - A utility class that handles robust user input via Scanner.
 * It includes methods for capturing and validating integers, characters,
 * and alphabetic strings, ensuring error handling for mismatched types
 * and invalid formats.
 * Author - Kripendra
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);

    public int inputInteger() {
        int number;

        while (true) {
            try {
                System.out.print("Enter an integer: ");
                number = sc.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println(" Please enter an INTEGER only.");
                sc.next();
            }
        }

    }
    public char inputChar() {
        char character;

        while (true) {
            try {
                System.out.print("Enter a character: ");
                // Read the next word and take the first character
                String input = sc.next();

                if (input.length() > 1) {
                    System.out.println("Multiple characters detected. Using the first one.");
                }

                character = input.charAt(0);
                return character;
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                sc.next();
            }
        }
    }
    public String inputWord() {
        String word;

        while (true) {
            try {
                System.out.print("Enter a word (letters only): ");
                word = sc.next();

                // Check if input is empty or contains non-letters
                if (word.trim().isEmpty() || !word.matches("[a-zA-Z]+")) {
                    throw new Exception("Input must contain letters only and cannot be empty.");
                }

                return word;
            } catch (Exception e) {
                System.out.println("Please enter letters only.");
                sc.nextLine();
            }
        }
    }

}