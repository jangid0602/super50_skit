import java.util.*;

/**
 * @Filename-DijkstraAdjacencyMatrix.java
 * @Description-This is to compute the shortest distance from a given source to all other vertices.

 * @Author-Aditya Virmani
 */


public class DijkstraAdjacencyMatrix {

    public static int[] dijkstra(int[][] matrix, int src) {

        int n = matrix.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int count = 0; count < n - 1; count++) {

            int u = -1;
            int minimumDistance = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < minimumDistance) {
                    minimumDistance = distance[i];
                    u = i;
                }
            }

            if (u == -1) break; 

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] &&
                    matrix[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE) {

                    distance[v] = Math.min(distance[v], distance[u] + matrix[u][v]);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int n = InputUtil.getInt("Enter number of vertices: ");

        int[][] matrix = new int[n][n];
        System.out.println("Enter adjacency matrix (0 for no edge):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = InputUtil.getInt("matrix[" + i + "][" + j + "]: ");
            }
        }

        int src = InputUtil.getInt("Enter source vertex: ");

        int[] result = dijkstra(matrix, src);

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE)
                System.out.print("∞ ");
            else
                System.out.print(result[i] + " ");
        }
    }
}
