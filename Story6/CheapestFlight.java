import java.util.*;

/**
 * @filename - DistantCousins.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int minCost = Integer.MAX_VALUE;

    void dfs(int src, int dest, int stops, int cost, int k, List<List<int[]>> adj) {
        if (stops > k + 1)
            return;

        if (src == dest) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int[] edge : adj.get(src)) {
            int nextCity = edge[0];
            int price = edge[1];
            dfs(nextCity, dest, stops + 1, cost + price, k, adj);
        }
    }
}

public class CheapestFlight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        System.out.print("Enter number of flights: ");
        int edges = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter flights (from to price):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int price = sc.nextInt();
            adj.get(u).add(new int[] { v, price });
        }

        System.out.print("Enter source: ");
        int src = sc.nextInt();

        System.out.print("Enter destination: ");
        int dst = sc.nextInt();

        System.out.print("Enter max stops (k): ");
        int k = sc.nextInt();

        Solution sol = new Solution();
        sol.dfs(src, dst, 0, 0, k, adj);

        if (sol.minCost == Integer.MAX_VALUE)
            System.out.println("Output: -1");
        else
            System.out.println("Output: " + sol.minCost);
    }
}
