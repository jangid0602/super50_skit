import java.util.Scanner;


/**
 * @Filename-InputUtil.java
 * @Description- Utility class for validating and reading user input. Provides methods
 *               to safely read integer values and node values (integers or "null")
 *               from Scanner with proper error handling and input validation.
 * @Author-Aman Jeet Singh
 */



public class InputUtil {

    /**
     * Reads and validates a node value (integer or "null") from scanner
     * @param scanner Scanner object for reading input
     * @return Validated input string (integer or "null")
     */
    public static String readNode(Scanner scanner) {
        String inputValue = scanner.next();

        if (inputValue.equals("null")) {
            return "null";
        }

        for (int charIndex = 0; charIndex < inputValue.length(); charIndex++) {
            // Allow negative sign at the beginning
            if (charIndex == 0 && inputValue.charAt(charIndex) == '-') continue;
            if (!Character.isDigit(inputValue.charAt(charIndex))) {
                System.out.println("Invalid input. Use integer or 'null'");
                return readNode(scanner); 
            }
        }
        return inputValue;
    }

    /**
     * Reads and validates an integer value from scanner
     * @param scanner Scanner object for reading input
     * @return Validated integer value
     */
    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid integer. Try again:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
