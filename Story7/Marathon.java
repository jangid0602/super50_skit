import java.util.*;

/**
 * @filename - Marathon.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    public int longestSubsequence(int N, int K, int[] A) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : A) {
            int best = 0;

            if (dp.containsKey(x - K)) {
                best = Math.max(best, dp.get(x - K));
            }
            if (dp.containsKey(x + K)) {
                best = Math.max(best, dp.get(x + K));
            }

            dp.put(x, Math.max(dp.getOrDefault(x, 0), best + 1));
            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}

public class Marathon {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.print("Enter K: ");
        int K = sc.nextInt();

        int[] A = new int[N];

        System.out.println("Enter array elements:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int ans = sol.longestSubsequence(N, K, A);

        System.out.println("Longest subsequence length: " + ans);
    }
}
