import java.util.*;

/**
 * @filename - CircularOfficeSecurity.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {

    // Linear DP helper
    static int solveLinear(int[] v, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int take = prev2 + v[i];
            int notTake = prev1;
            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // Circular DP
    static int maxAuditValue(int[] v) {
        int n = v.length;

        if (n == 1)
            return v[0];

        // Case 1: exclude first cabin
        int case1 = solveLinear(v, 1, n - 1);

        // Case 2: exclude last cabin
        int case2 = solveLinear(v, 0, n - 2);

        return Math.max(case1, case2);
    }
}

public class CircularOfficeSecurity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cabins (N): ");
        int n = sc.nextInt();

        int[] v = new int[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int ans = Solution.maxAuditValue(v);
        System.out.println("Maximum audited value: " + ans);
    }
}
