/**
 * @Filename - Main.java
 * @Description - Menu-driven driver code for Week 1 problems.
 * @Author - Anish Saini
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int[] inputArray = null;
        problemStatements ps = null;

        // Keep running until user exits
        while (true) {
            System.out.println("""
                ===============================
                Choose operation:
                1. Efficient Traveler
                2. The Sum That Stands Out 
                3. Flip the Switch
                4. The Odd One Out
                5. Smart Pair Finder
                6. The Minimalist Painter
                0. Exit
                ===============================
                """);

            System.out.print("Enter your choice: ");
            int choice = userInput.nextInt();

            if (choice == 0) {
                System.out.println("Exiting program... Goodbye!");
                break;
            }

            // Check if array exists; if not or invalid, take input again
            while (true) {
                if (inputArray == null || !isArrayValidForChoice(inputArray, choice)) {
                    System.out.print("Enter size of the array: ");
                    int size = userInput.nextInt();
                    inputArray = new int[size];

                    System.out.println("Enter array elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray[i] = userInput.nextInt();
                    }
                    ps = new problemStatements(inputArray);
                }

                if (isArrayValidForChoice(inputArray, choice)) {
                    break;
                } else {
                    System.out.println("Invalid array for this operation. Please re-enter.");
                    inputArray = null;
                }
            }

            // Perform the selected operation
            switch (choice) {
                case 1:
                    System.out.print("Enter the initial energy: ");
                    int energy = userInput.nextInt();
                    System.out.println("Farthest city index: " + ps.efficientTraveler(energy));
                    break;

                case 2:
                    System.out.println("Index where prefix = suffix: " + ps.prefixSumEqualToSuffixSum());
                    break;

                case 3:
                    int flips = ps.minimumFlip();
                    if (flips == -1)
                        System.out.println("Invalid array (must contain only 0s and 1s)");
                    else
                        System.out.println("Minimum flips needed: " + flips);
                    break;

                case 4:
                    int result = ps.findOddOneOut();
                    if(result == -1)
                        System.out.println("No odd one out found.");
                    else
                    System.out.println("The odd one out: " +  result);
                    break;

                case 5:
                    System.out.print("Enter target sum: ");
                    int target = userInput.nextInt();
                    System.out.println("Pair exists: " + ps.pairSumEqualToTarget(target));
                    break;

                case 6:
                    System.out.println("Minimum total time (after skipping one): " + ps.minimalistPainter());
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        userInput.close();
    }

    // Validate array based on problem type
    public static boolean isArrayValidForChoice(int[] arr, int choice) {
        switch (choice) {
            case 1, 2, 4, 5, 6 -> { // general integer arrays
                return arr.length > 0;
            }
            case 3 -> { // binary array check
                for (int n : arr)
                    if (n != 0 && n != 1) return false;
                return arr.length > 0;
            }
            default -> {
                return false;
            }
        }
    }
}
