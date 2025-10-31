package problemsolver;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The Main class serves as the entry point for the console-based program.
 * It allows users to select and solve one of six predefined computational problems.
 * The program handles invalid user input gracefully and re-prompts the user when necessary.
 * <p>
 * Problems:
 * 1. The Efficient Traveler
 * 2. The Sum That Stands Out
 * 3. Flip the Switch
 * 4. The Odd One Out
 * 5. Smart Pair Finder
 * 6. The Minimalist Painter
 * 7. Exit
 * <p>
 * Author: Nasir Ahmed
 * Date: 30 October 2025
 */
public class Main {

    /**
     * Main entry point of the program.
     * Displays a menu, takes user input, and calls corresponding problem handlers.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display main menu
            System.out.println("\n=== Choose a problem to solve ===");
            System.out.println("1. The Efficient Traveler");
            System.out.println("2. The Sum That Stands Out");
            System.out.println("3. Flip the Switch");
            System.out.println("4. The Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. The Minimalist Painter");
            System.out.println("7. Exit");

            int choice = getValidChoice(sc, 1, 7);

            if (choice == 7) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1 -> handleEfficientTraveller(sc);
                case 2 -> handleSumThatStandsOut(sc);
                case 3 -> handleFlipTheSwitch(sc);
                case 4 -> handleOddOneOut(sc);
                case 5 -> handleSmartPairFinder(sc);
                case 6 -> handleMinimalistPainter(sc);
            }
        }
        sc.close();
    }

    /**
     * Prompts user for a valid choice within a given range.
     *
     * @param sc   Scanner instance for input
     * @param min  Minimum acceptable integer
     * @param max  Maximum acceptable integer
     * @return Valid user choice within [min, max]
     */
    private static int getValidChoice(Scanner sc, int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                int choice = sc.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Illegal entry! Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    /**
     * Safely prompts for an integer value.
     *
     * @param sc       Scanner instance
     * @param message  Prompt message
     * @return A valid integer entered by the user
     */
    private static int getValidInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    /**
     * Reads an integer array from user input.
     * Supports binary-only arrays (0 and 1).
     *
     * @param sc        Scanner instance
     * @param size      Size of the array
     * @param isBinary  Whether to restrict elements to 0 and 1
     * @return Populated integer array
     */
    private static int[] getIntArray(Scanner sc, int size, boolean isBinary) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    int val = sc.nextInt();

                    if (isBinary && val != 0 && val != 1) {
                        System.out.println("Invalid entry! Only 0 or 1 allowed.");
                        continue;
                    }
                    arr[i] = val;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.nextLine();
                }
            }
        }
        return arr;
    }

    /** Handles "The Efficient Traveler" problem. */
    private static void handleEfficientTraveller(Scanner sc) {
        int size = getValidInt(sc, "Enter size of array: ");
        int[] nums = getIntArray(sc, size, false);
        int energy = getValidInt(sc, "Enter initial energy: ");

        int result = ProblemSolver.getFarthestCityIndex(nums, energy);
        System.out.println("Farthest city index: " + result);
    }

    /** Handles "The Sum That Stands Out" problem. */
    private static void handleSumThatStandsOut(Scanner sc) {
        int size = getValidInt(sc, "Enter size of array: ");
        int[] nums = getIntArray(sc, size, false);

        int result = ProblemSolver.findEquilibriumIndex(nums);
        System.out.println("Equilibrium index: " + result);
    }

    /** Handles "Flip the Switch" problem (binary input only). */
    private static void handleFlipTheSwitch(Scanner sc) {
        int size = getValidInt(sc, "Enter size of binary array: ");
        int[] nums = getIntArray(sc, size, true);

        int result = ProblemSolver.minFlipsToMakeEqual(nums);
        System.out.println("Minimum flips required: " + result);
    }

    /** Handles "The Odd One Out" problem. */
    private static void handleOddOneOut(Scanner sc) {
        int size;
        while (true) {
            size = getValidInt(sc, "Enter size of array (must be odd): ");
            if (size % 2 == 1) break;
            System.out.println("Invalid size! Array size must be odd to have one unique element.");
        }

        int[] nums = getIntArray(sc, size, false);
        int result = ProblemSolver.findUniqueElement(nums);
        System.out.println("Unique element: " + result);
    }


    /** Handles "Smart Pair Finder" problem. */
    private static void handleSmartPairFinder(Scanner sc) {
        int size = getValidInt(sc, "Enter size of array: ");
        int[] nums = getIntArray(sc, size, false);
        int k = getValidInt(sc, "Enter target sum k: ");

        boolean exists = ProblemSolver.hasPairWithSum(nums, k);
        System.out.println("Pair exists: " + exists);
    }

    /** Handles "The Minimalist Painter" problem. */
    private static void handleMinimalistPainter(Scanner sc) {
        int size = getValidInt(sc, "Enter number of walls: ");
        int[] time = getIntArray(sc, size, false);

        int result = ProblemSolver.minPaintTimeAfterSkip(time);
        System.out.println("Minimum total painting time: " + result);
    }
}
