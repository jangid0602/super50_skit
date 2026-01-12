import java.util.Scanner;

/**
 * @Filename-CosmicCourier.java
 * @Description-This program determines the minimum possible deadline after optionally
 *                   removing one route from a list of travel routes. It efficiently finds
 *                   the second maximum travel time from the given routes, which represents
 *                   the optimal deadline when one route can be removed. The algorithm uses
 *                   a single pass through the array to identify the two largest values.
 * @Author- Aman Jeet Singh
 */
public class CosmicCourier {
    public static int minimumPossibleDeadline(int[] travelTime, int routes) {
        if (routes <= 1) {
            return travelTime[0];
        }

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < routes; i++) {
            if (travelTime[i] > firstMax) {
                secondMax = firstMax;
                firstMax = travelTime[i];
            } else if (travelTime[i] > secondMax) {
                secondMax = travelTime[i];
            }
        }
        return secondMax;
    }

    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of routes: ");
        int routes = readInt(scanner);
        int[] travelTime = new int[routes];

        // Input all travel times
        System.out.println("Enter the travel times for routes:");
        for (int i = 0; i < routes; i++) {
            System.out.print("Route " + (i + 1) + ": ");
            travelTime[i] = readInt(scanner);
        }
        int minimumTime = minimumPossibleDeadline(travelTime, routes);
        System.out.println("Minimum possible deadline: " + minimumTime);
        scanner.close();
    }
}