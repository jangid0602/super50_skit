import java.util.Scanner;

/**
 * @filename - Staircase.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int solve(int n) {
        if (n <= 1)
            return 1;
        return solve(n - 1) + solve(n - 2);
    }
}

public class Staircase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of stairs");
        int N = scanner.nextInt();
        Solution s = new Solution();
        System.out.println("The total number of distinct ways to reach the top: " + s.solve(N));
    }
}
