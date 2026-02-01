import java.util.Scanner;

/**
 * @Filename- InputUtil.java
 * @Description- This is to take input from user
 * @Author- Arman Agrawal
 */



class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            String input = scanner.next();

            if (isValidInteger(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.print("Invalid integer. Please enter again: ");
            }
        }
    }

    public static String readString() {
        return scanner.next();
    }

    private static boolean isValidInteger(String s) {
        if (s == null || s.length() == 0) return false;

        int startIndex = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() == 1) return false;
            startIndex = 1;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
