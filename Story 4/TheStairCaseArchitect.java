/**
 * <p>This class solves The Stair Case problem using recursion (fibonacci series) </p>
 *
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public class TheStairCaseArchitect {

    static int climb(int steps, int sum) {

        if (sum > steps)
            return 0;

        if (sum == steps)
            return 1;

        return climb(steps, sum + 1) + climb(steps, sum + 2);
    }


    public static void main(String[] args) {

        System.out.println("Enter number of steps in Integer");
        Scanner scannerObj = new Scanner(System.in);
        int steps = scannerObj.nextInt();
        int answer = climb(steps, 0);
        System.out.println("Total ways to climb the steps are:" + answer);

    }
}


