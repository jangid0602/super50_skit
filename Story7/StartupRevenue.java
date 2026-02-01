import java.util.*;

/**
 * @filename - StartupRevenue.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int solve(int i, int[] A, int[] dp) {
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int nottaken = solve(i - 1, A, dp);
        int take;

        if ((i + 1) % 7 != 0)
            take = A[i] + solve(i - 2, A, dp);
        else
            take = 2 * A[i] + solve(i - 2, A, dp);

        return dp[i] = Math.max(nottaken, take);
    }
}

public class StartupRevenue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        int[] A = new int[N];
        System.out.println("Enter revenue values:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        Solution sol = new Solution();
        int ans = sol.solve(N - 1, A, dp);

        System.out.println("Maximum Revenue: " + ans);
    }
}
