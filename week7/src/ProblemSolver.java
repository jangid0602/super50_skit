import datastructure.TreeNode;
import util.MathLib;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the main functions library where all the problem's solutions are implemented
 *
 * @author Bhavya Jain
 * @date 27 Jan 2026
 */
public class ProblemSolver {

    private final int MOD = 1000000007;

    public int getMaximumRevenue(int noOfDays, int[] revenue) {
        if (noOfDays == 0) return 0;
        if (noOfDays == 1) return revenue[0];
        int[] dp = new int[noOfDays + 1];
        for (int i = 1; i <= noOfDays; i++) {
            int prev = dp[i - 1];
            int gain = i % 7 == 0 ? 2 * revenue[i - 1] : revenue[i - 1];
            int curWithGain = (i > 1 ? dp[i - 2] : 0) + gain;
            dp[i] = Math.max(prev, curWithGain);
        }
        return dp[noOfDays];
    }

    // n -> number of students/mentors
    public int getMaximumCompatibilityScore(int n, int[][] compatibilityMatrix) {
        if (n == 0) return 0;
        if (n == 1) return compatibilityMatrix[0][0];
        int size = 1 << n; // 2^n
        int[] dp = new int[size];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        // i represents dp mask
        for (int i = 0; i < size; i++) {
            if (dp[i] == -1) continue;
            int mentor = Integer.bitCount(i);
            if (mentor >= n) continue;
            for (int j = 0; j < n; j++) { // j represents student
                if ((i & (1 << j)) == 0) {
                    int index = i | (1 << j);
                    dp[index] = Math.max(dp[index], dp[i] + compatibilityMatrix[mentor][j]);
                }
            }
        }
        return dp[size - 1];
    }

    public int getMaxAuditAmount(int[] cabins) {
        int n = cabins.length;
        if (n == 0) return 0;
        if (n == 1) return cabins[0];
        if (n == 2) return Math.max(cabins[0], cabins[1]);
        int[] dp = new int[n];

        // case 1 : skipping last
        dp[0] = cabins[0];
        dp[1] = Math.max(cabins[0], cabins[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + cabins[i]);
        }
        int result = dp[n - 2];

        // case 2 : skipping first
        dp[1] = cabins[1];
        dp[2] = Math.max(cabins[1], cabins[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + cabins[i]);
        }

        return Math.max(result, dp[n - 1]);
    }

    public long countPrimes(long left, long right) {
        long ansRight = count(right);
        long ansLeft = count(left - 1);
        return (ansRight - ansLeft + MOD) % MOD;
    }

    long[][][] memo;
    ArrayList<Integer> digits;

    private long count(long n) {
        if (n <= 0) return 0;

        String s = String.valueOf(n);
        digits = new ArrayList<>();
        for (char c : s.toCharArray()) digits.add(c - '0');

        memo = new long[20][170][2];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 170; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dpHelper(0, 0, 1);

    }

    private long dpHelper(int index, int sum, int isBounded) {
        if (index == digits.size()) return MathLib.isPrime(sum) ? 1 : 0;
        if (memo[index][sum][isBounded] != -1) return memo[index][sum][isBounded];
        long ans = 0;
        int upperBound = (isBounded == 1) ? digits.get(index) : 9;
        for (int digit = 0; digit <= upperBound; digit++) {
            int nextBound = (isBounded == 1 && digit == upperBound) ? 1 : 0;
            ans = (ans + dpHelper(index + 1, sum + digit, nextBound)) % MOD;
        }
        return memo[index][sum][isBounded] = ans;
    }

    public int getMaxEfficiency(TreeNode root) {
        int[] answer = buildTreeDP(root);
        return Math.max(answer[0], answer[1]);
    }

    private int[] buildTreeDP(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        // dfs
        int[] left = buildTreeDP(root.left);
        int[] right = buildTreeDP(root.right);

        int with = root.val + left[1] + right[1];
        int without = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{with, without};
    }
}
