import java.util.*;

/**
 * @filename - LPS.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int longestCommonSubsequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

public class LPS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();

        Solution sol = new Solution();
        int lpsLength = sol.longestCommonSubsequence(s, rev);

        System.out.println("Minimum deletions to make palindrome: " + (n - lpsLength));
    }
}
