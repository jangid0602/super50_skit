import java.util.*;
/**
 * @Filename- DijkstraMatrix.java
 * @Description- Given a graph represented as an adjacency matrix, where matrix[i][j] denotes the
 * weight of the edge from i to j (0 if no edge), compute the shortest distance from a
 * given source to all other vertices.
 * @Author- Kripendra
 */

public class DijkstraMatrix {
    public static int[] dijkstra(int[][] matrix, int src) {
        int n = matrix.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = findMinDistance(dist, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                    if (dist[u] + matrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + matrix[u][v];
                    }
                }
            }
        }
        return dist;
    }

    private static int findMinDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Input input = new Input();
        System.out.print("Enter matrix size (N for NxN): ");
        int n = input.inputInteger();
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("Matrix["+i+"]["+j+"]: ");
                matrix[i][j] = input.inputInteger();
            }
        }
        System.out.print("Source node: ");
        int src = input.inputInteger();
        int[] res = dijkstra(matrix, src);
        System.out.println("Distances: " + Arrays.toString(res));
    }
}