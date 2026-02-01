import java.util.*;

/**
 * @filename - DijkstraMatrix.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    public int[] dijkstra(int[][] matrix, int src) {
        int n = matrix.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;

            // Find nearest unvisited vertex
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1)
                break; // No more reachable nodes

            visited[u] = true;

            // Relax edges
            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + matrix[u][v]);
                }
            }
        }

        return dist;
    }
}

public class DijkstraMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        Solution sol = new Solution();
        int[] result = sol.dijkstra(matrix, src);

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE)
                System.out.print("∞ ");
            else
                System.out.print(result[i] + " ");
        }
    }
}
