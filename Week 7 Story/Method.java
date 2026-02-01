// @filename - Method.java
// @description - Contains Week 7 Story Solutions
// @author - Divyansh Tak

import java.util.*;

public class Method {

    //Startup Revenue Maxima
    static int maxRevenue(int arr[], int n) {
    if (n == 0) return 0;
    if (n == 1) return arr[0];

    int dp[] = new int[n];

    // Day 1
    dp[0] = arr[0];

    // Day 2 
    dp[1] = Math.max(arr[0], arr[1]);

      for(int i = 2;i < n;i++) {

          int earn = arr[i];

         if ((i + 1) % 7 == 0) {
             earn = 2 * arr[i];
         }

         dp[i] = Math.max(dp[i - 1], dp[i - 2] + earn);
      }

      return dp[n - 1];
    }


    //Minimal Tech-Stack Swap 
    static int minEditCost(String s1, String s2, int costi, int costd, int costu) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 0;i <= n;i++){

            dp[i][0] = i * costd;
        }

        for(int j = 0;j <= m;j++){
            dp[0][j] = j * costi;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    int insert = dp[i][j - 1] + costi;
                    int delete = dp[i - 1][j] + costd;
                    int replace = dp[i - 1][j - 1] + costu;

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    //Placement Marathon
    static int longestSubsequence(int arr[], int n, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int val1 = map.containsKey(arr[i] - K) ? map.get(arr[i] - K) : 0;
            int val2 = map.containsKey(arr[i] + K) ? map.get(arr[i] + K) : 0;

            int best = Math.max(val1, val2) + 1;
            map.put(arr[i], Math.max(map.getOrDefault(arr[i], 0), best));

            ans = Math.max(ans, best);
        }

        return ans;
    }

    //Circular Office Security
    static int maxCircularValue(int arr[], int n) {

        if (n == 1) return arr[0];

        return Math.max(linearRob(arr, 0, n - 2),linearRob(arr, 1, n - 1));
    }

    static int linearRob(int arr[], int start, int end) {
        int prev2 = 0, prev1 = 0;

        for(int i = start;i <= end;i++) {

            int cur = Math.max(prev1, prev2 + arr[i]);
            prev2 = prev1;
            prev1 = cur;

        }

        return prev1;
    }

    //Palindromic Deployment
    static int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int len = 2;len <= n;len++) {
            for (int i = 0;i + len - 1 < n; i++) {

                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}


