import java.util.Scanner;


/**
 * @Filename-InputUtil.java
 * @Description- This is to verify input
 * @Author-Arman Agrawal
 */



public class InputUtil {

    public static String readNode(Scanner sc) {
        String input = sc.next();

        if (input.equals("null")) {
            return "null";
        }

        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && input.charAt(i) == '-') continue;
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println("Invalid input. Use integer or 'null'");
                return readNode(sc); // retry
            }
        }
        return input;
    }

    public static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid integer. Try again:");
            sc.next();
        }
        return sc.nextInt();
    }
}
