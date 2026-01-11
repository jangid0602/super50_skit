import java.util.Scanner;

/**
 * @Filename-TheStaircaseArchitect.java
 * @Description- This calculates the total number of distinct ways builder can reach the top(either 1 or 2 steps allowed). 
 * @Author-Aditya Virmani
 */
public class TheStaircaseArchitect {
     public static int countWays(int steps) {

        if (steps == 0)
            return 1;
        if (steps == 1)
            return 1;

        return countWays(steps - 1) + countWays(steps - 2);
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int steps;

        while (true) {
            try {
                System.out.print("Enter number of steps: ");
                steps = userInput.nextInt();

                if (steps < 0) {
                    System.out.println("Error: Number of steps cannot be negative!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
                userInput.nextLine();
            }
        }

        int result = countWays(steps);
        System.out.println("Total number of ways: " + result);

        userInput.close();
    }
}
