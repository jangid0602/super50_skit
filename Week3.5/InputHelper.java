import java.util.*;

/**
 * @Filename-InputHelper.java
 * @Description-This will be used for taking integer input.It will be used by
 *                   other classes
 * @Author-Aditya Virmani
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
