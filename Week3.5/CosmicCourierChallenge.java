import java.util.Scanner;

/**
 * @Filename-CosmicCourierChallenge.java
 * @Description-This determines the minimum possible deadline after optionally
 *                   removing one route.
 * @Author-Aditya Virmani
 */
public class CosmicCourierChallenge {
    public static int minimumPossibleDeadline(int[] travelTime, int routes) {
        if (routes <= 1) {
            return travelTime[0];
        }

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < routes; i++) {
            if (travelTime[i] > firstMax) {
                secondMax = firstMax;
                firstMax = travelTime[i];
            } else if (travelTime[i] > secondMax)
                secondMax = travelTime[i];
        }
        return secondMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of routes");

        // Taking integer input with the help of InputHelper class
        int routes = InputHelper.readInt(scanner);
        int[] travelTime = new int[routes];

        // Input all travel times
        System.out.println("Enter the travel times for routes");
        for (int i = 0; i < routes; i++) {
            travelTime[i] = InputHelper.readInt(scanner);
        }
        int minimumTime = minimumPossibleDeadline(travelTime, routes);
        System.out.println("Minimum possible deadline: " + minimumTime);
        scanner.close();
    }
}
