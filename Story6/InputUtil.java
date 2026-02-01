import java.util.Scanner;


/**
 * @Filename- InputUtil.java
 * @Description- This is to take the correct input
 * @Author- Arman Agrawal
 */


public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    public static char getChar(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input! Please enter a single character.");
            }
        }
    }
}
