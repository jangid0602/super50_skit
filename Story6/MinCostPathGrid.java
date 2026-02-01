import java.util.Scanner;

/**
 * @filename - MinCostPathGridva
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int minCost = Integer.MAX_VALUE;
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    void minCostPath(int i, int j, int cost, int r, int c, int[][] grid, boolean[][] visited) {

        // If destination reached
        if (i == r && j == c) {
            minCost = Math.min(minCost, cost + grid[i][j]);
            return;
        }

        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int xr = i + dx[d];
            int xc = j + dy[d];

            if (xr >= 0 && xr <= r && xc >= 0 && xc <= c && !visited[xr][xc]) {
                minCostPath(xr, xc, cost + grid[i][j], r, c, grid, visited);
            }
        }

        visited[i][j] = false; // Backtrack
    }
}

public class MinCostPathGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        boolean[][] visited = new boolean[n][m];

        sol.minCostPath(0, 0, 0, n - 1, m - 1, grid, visited);

        System.out.println("Minimum Cost Path = " + sol.minCost);
    }
}
