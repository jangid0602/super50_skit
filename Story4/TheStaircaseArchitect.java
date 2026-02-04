import java.util.Scanner;

/**
 * Calculates the number of distinct ways to climb a staircase
 * where each move can be either 1 or 2 steps.
 * 
 * @author Aman Jeet Singh
 */
public class TheStaircaseArchitect {

    /**
     * Calculates the number of distinct ways to climb a staircase.
     * 
     * @param numberOfSteps The total number of steps in the staircase
     * @return The total number of distinct ways to reach the top
     */
    public static int countWays(int numberOfSteps) {
        // Base cases: 0 steps = 1 way (already at top), 1 step = 1 way
        if (numberOfSteps == 0 || numberOfSteps == 1) {
            return 1;
        }

        // Recursive case: ways to reach current step = sum of ways to reach
        // previous two steps (can come from step-1 or step-2)
        return countWays(numberOfSteps - 1) + countWays(numberOfSteps - 2);
    }

    /**
     * Main method to interact with user and calculate distinct ways to climb stairs.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfSteps;

        // Input validation loop: ensures valid non-negative integer input
        while (true) {
            try {
                System.out.print("Enter number of steps: ");
                numberOfSteps = inputScanner.nextInt();

                if (numberOfSteps < 0) {
                    System.out.println("Error: Number of steps cannot be negative!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Please enter an integer.");
                inputScanner.nextLine(); // Clear invalid input from buffer
            }
        }

        int totalDistinctWays = countWays(numberOfSteps);
        System.out.println("Total number of distinct ways to reach the top: " + totalDistinctWays);

        inputScanner.close();
    }
}
