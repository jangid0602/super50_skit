import java.util.Scanner;

/**
 * @Filename- InputUtils.java
 * @Description- This is class for taking valid input or we can say input validation
 * @Author- Arman Agrawal
 */




public class InputUtils {

    private final Scanner scanner = new Scanner(System.in);

    public int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public boolean readBoolean(String message) {
        while (true) {
            System.out.print(message + " (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Enter true or false only.");
        }
    }

    public int[] readIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = readInt("Enter element " + (i + 1) + ": ");
        }
        return arr;
    }

    public String[] readStringArray(int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = readString("Enter value " + (i + 1) + ": ");
        }
        return arr;
    }

    public int[][] readMatrix(int n) {
        int[][] matrix = new int[n][n];
        System.out.println("Enter maze values (0 = blocked, 1 = open)");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    int val = readInt("[" + i + "][" + j + "]: ");
                    if (val == 0 || val == 1) {
                        matrix[i][j] = val;
                        break;
                    }
                    System.out.println("Only 0 or 1 allowed.");
                }
            }
        }
        return matrix;
    }
}
