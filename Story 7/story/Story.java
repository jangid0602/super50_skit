/**
 * Week 7 Assignment
 * Author: Anish Saini
 * Description: Menu driven Java program implementing all 10 story-based problems
 */

import java.util.*;
public class Story {

    //  Startup Revenue Maxima
    public static void startupRevenue(Scanner sc) {
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = A[0];

        for (int i = 2; i <= n; i++) {
            int val = A[i - 1];
            if (i % 7 == 0) val *= 2;
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + val);
        }
        System.out.println("Max Revenue: " + dp[n]);
    }

    //  Mentorship Matching (Bitmask DP)
    public static void mentorshipMatching(Scanner sc) {
        int N = sc.nextInt();
        int[][] S = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                S[i][j] = sc.nextInt();

        int[] dp = new int[1 << N];
        Arrays.fill(dp, -1);

        System.out.println("Max Compatibility: " + match(0, 0, S, dp, N));
    }

    private static int match(int i, int mask, int[][] S, int[] dp, int N) {
        if (i == N) return 0;
        if (dp[mask] != -1) return dp[mask];

        int ans = 0;
        for (int j = 0; j < N; j++) {
            if ((mask & (1 << j)) == 0) {
                ans = Math.max(ans, S[i][j] + match(i + 1, mask | (1 << j), S, dp, N));
            }
        }
        return dp[mask] = ans;
    }

    //  Edit Distance with Costs
    public static void techStackSwap(Scanner sc) {
        String s1 = sc.next();
        String s2 = sc.next();
        int ci = sc.nextInt(), cd = sc.nextInt(), cu = sc.nextInt();

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i * cd;
        for (int j = 0; j <= n; j++) dp[0][j] = j * ci;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + cu,
                            Math.min(dp[i - 1][j] + cd, dp[i][j - 1] + ci));
            }
        }
        System.out.println("Min Cost: " + dp[m][n]);
    }

    //  Placement Marathon
    public static void placementMarathon(Scanner sc) {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        for (int x : A) {
            int len = map.getOrDefault(x - k, 0) + 1;
            map.put(x, len);
            ans = Math.max(ans, len);
        }
        System.out.println("Longest Length: " + ans);
    }

    //  Optimal Server Latency
    public static void serverLatency(Scanner sc) {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                int max = A[j - 1], min = A[j - 1];
                for (int p = j; p >= 1; p--) {
                    max = Math.max(max, A[p - 1]);
                    min = Math.min(min, A[p - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][p - 1] + (max - min));
                }
            }
        }
        System.out.println("Min Unbalance: " + dp[k][n]);
    }

    //  Ad Placement
    public static void adPlacement(Scanner sc) {
        int T = sc.nextInt(), m = sc.nextInt();
        int[] d = new int[m], p = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int[] dp = new int[T + 1];

        for (int i = 0; i < m; i++) {
            for (int t = T; t >= 0; t--) {
                if (t + d[i] <= T)
                    dp[t + d[i]] = Math.max(dp[t + d[i]], dp[t] + p[i]);
                if (t + 2 * d[i] <= T)
                    dp[t + 2 * d[i]] = Math.max(dp[t + 2 * d[i]], dp[t] + p[i] + p[i] / 2);
            }
        }
        System.out.println("Max Profit: " + dp[T]);
    }

    //  Binary Tree Audit
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static class Pair {
        int in, ex;
        Pair(int i, int e) { in = i; ex = e; }
    }

    public static void binaryTreeAudit(Scanner sc) {
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s.equals("null") ? null : Integer.parseInt(s);
        }
        TreeNode root = buildTree(arr);
        Pair res = dfs(root);
        System.out.println("Max Efficiency: " + Math.max(res.in, res.ex));
    }

    private static Pair dfs(TreeNode node) {
        if (node == null) return new Pair(0, 0);
        Pair L = dfs(node.left), R = dfs(node.right);
        int in = node.val + L.ex + R.ex;
        int ex = Math.max(L.in, L.ex) + Math.max(R.in, R.ex);
        return new Pair(in, ex);
    }

    private static TreeNode buildTree(Integer[] a) {
        if (a[0] == null) return null;
        TreeNode[] nodes = new TreeNode[a.length];
        for (int i = 0; i < a.length; i++)
            if (a[i] != null) nodes[i] = new TreeNode(a[i]);

        for (int i = 0; i < a.length; i++) {
            if (nodes[i] != null) {
                int l = 2 * i + 1, r = 2 * i + 2;
                if (l < a.length) nodes[i].left = nodes[l];
                if (r < a.length) nodes[i].right = nodes[r];
            }
        }
        return nodes[0];
    }

    //  Prime Digit Sum Count
    public static void primeDigitSum(Scanner sc) {
        long L = sc.nextLong(), R = sc.nextLong();
        int count = 0;
        for (long i = L; i <= R; i++) {
            if (isPrime(digitSum(i))) count++;
        }
        System.out.println("Count: " + count);
    }

    private static int digitSum(long n) {
        int s = 0;
        while (n > 0) { s += n % 10; n /= 10; }
        return s;
    }

    private static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0) return false;
        return true;
    }

    //  Circular Office Security
    public static void circularOffice(Scanner sc) {
        int n = sc.nextInt();
        int[] V = new int[n];
        for (int i = 0; i < n; i++) V[i] = sc.nextInt();

        if (n == 1) {
            System.out.println(V[0]);
            return;
        }
        System.out.println(Math.max(rob(V, 0, n - 2), rob(V, 1, n - 1)));
    }

    private static int rob(int[] a, int l, int r) {
        int prev1 = 0, prev2 = 0;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(prev1, a[i] + prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    // Palindromic Deployment
    public static void palindromicDeployment(Scanner sc) {
        String s = sc.next();
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("Min Insertions: " + dp[0][n - 1]);
    }
}
