import java.util.*;
/**
 * @Filename- ShortestPathAllNodes.java
 * @Description-Given an undirected graph, find the shortest path length that visits every node at least
 * once.
 * You may revisit nodes.
 * @Author- Mayank
 */
public class ShortestPathAllNodes {
    public static int shortestPathLength(int n, int[][] edges) {
        if (n <= 1) return 0;

        // Build Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int targetMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int u = curr[0];
                int mask = curr[1];

                if (mask == targetMask) return steps;

                for (int v : adj.get(u)) {
                    int nextMask = mask | (1 << v);
                    if (!visited[v][nextMask]) {
                        visited[v][nextMask] = true;
                        queue.offer(new int[]{v, nextMask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Input input = new Input();

        System.out.print("Enter number of nodes: ");
        int n = input.inputInteger();

        System.out.print("Enter number of edges: ");
        int eCount = input.inputInteger();

        int[][] edges = new int[eCount][2];
        for (int i = 0; i < eCount; i++) {
            System.out.println("Edge " + (i + 1) + ":");
            edges[i][0] = input.inputInteger();
            edges[i][1] = input.inputInteger();
        }

        int result = shortestPathLength(n, edges);
        System.out.println("Shortest path length to visit all nodes: " + result);
    }
}