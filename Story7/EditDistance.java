import java.util.*;

/**
 * @filename - EditDistance.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */


class Solution {
    public static int minCost(
            String s1, String s2,
            int insertCost, int deleteCost, int replaceCost) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i * deleteCost;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j * insertCost;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i][j - 1] + insertCost,
                            Math.min(
                                    dp[i - 1][j] + deleteCost,
                                    dp[i - 1][j - 1] + replaceCost));
                }
            }
        }

        return dp[n][m];
    }
}

public class EditDistance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        System.out.print("Enter insert cost: ");
        int insertCost = sc.nextInt();

        System.out.print("Enter delete cost: ");
        int deleteCost = sc.nextInt();

        System.out.print("Enter replace cost: ");
        int replaceCost = sc.nextInt();

        int result = Solution.minCost(
                s1, s2, insertCost, deleteCost, replaceCost);

        System.out.println("Minimum Cost: " + result);
    }
}
