
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation");
            System.out.println("1. The Time Traveler’s Array");
            System.out.println("2. The Shifting Cipher");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter integers only.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        ArrayList<Integer> array1 = new ArrayList<>();
                        System.out.print("Enter number of elements: ");
                        int arraySize = scanner.nextInt();

                        System.out.println("Enter " + arraySize + " elements:");
                        for (int i = 0; i < arraySize; i++) {
                            array1.add(scanner.nextInt());
                        }
                        System.out.print("Enter Target: ");
                        int Target = scanner.nextInt();

                        MyArray myArray1 = new MyArray(array1, Target);
                        System.out
                                .println("Number of subarrays with sum " + Target + ": " + myArray1.timeTravelArray());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    try {
                        // consume leftover newline before reading a full line
                        scanner.nextLine();
                        System.out.print("Enter the string to shift: ");
                        String inputStr = scanner.nextLine();
                        System.out.print("Enter Shift Value: ");
                        int shiftValue = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        MyArray myArray2 = new MyArray(inputStr, shiftValue);
                        System.out.println("Shifted result: " + myArray2.shiftingCipher());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only for the shift value.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option (1-3).");
            }

            scanner.nextLine(); // consume leftover newline
        }

        scanner.close();
    }
}