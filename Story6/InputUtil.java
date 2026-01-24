import java.util.Scanner;

/**
 * @Filename- InputUtil.java
 * @Description- This is to take the correct input
 * @Author- Aman Jeet Singh
 */
public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    public static char getChar(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (input.length() == 1) {
                return input.charAt(0);
            }

            System.out.println("Invalid input! Please enter a single character.");
        }
    }
}
