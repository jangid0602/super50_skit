import java.util.Scanner;

/**
 * @Filename-InputHelper.java
 * @Description-This utility class provides a safe and robust method for reading integer
 *                   input from a Scanner object. It validates user input and continuously
 *                   prompts the user for valid integer input if invalid data is entered,
 *                   preventing program crashes from incorrect input types. This class ensures
 *                   consistent and error-free input handling across the application.
 * @Author- Aman Jeet Singh
 */

public class InputHelper {
    public static int readInt(Scanner scanner) {
        int number = 0;
        boolean validInput = false;

        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (!validInput);
        return number;
    }
}