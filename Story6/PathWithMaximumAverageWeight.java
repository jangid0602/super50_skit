import java.util.*;

/**
 * @Filename- PathWithMaximumAverageWeight.java
 * @Description- This is to find a path from src to dst such that the average edge weight along the path is maximized
 * @Author- Aman Jeet Singh
 */
public class PathWithMaximumAverageWeight {

    private static boolean canAchieveAverage(
            int numberOfNodes,
            int[][] edges,
            int src,
            int dst,
            double average) {
        double[] maximumScore = new double[numberOfNodes];
        Arrays.fill(maximumScore, Double.NEGATIVE_INFINITY);
        maximumScore[src] = 0;

        for (int i = 0; i < numberOfNodes - 1; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                double adjustedWeight = edge[2] - average;

                if (maximumScore[from] != Double.NEGATIVE_INFINITY &&
                        maximumScore[from] + adjustedWeight > maximumScore[to]) {
                    maximumScore[to] = maximumScore[from] + adjustedWeight;
                    updated = true;
                }
            }

            if (!updated) {
                break;
            }
        }

        return maximumScore[dst] >= 0;
    }

    private static boolean isReachable(int numberOfNodes, int[][] edges, int src, int dst) {
        List<Integer>[] adjacencyList = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
        }

        boolean[] visited = new boolean[numberOfNodes];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == dst) {
                return true;
            }
            for (int next : adjacencyList[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public static double findMaximumAverage(
            int numberOfNodes,
            int[][] edges,
            int src,
            int dst) {
        if (!isReachable(numberOfNodes, edges, src, dst)) {
            return -1;
        }

        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            minWeight = Math.min(minWeight, edge[2]);
            maxWeight = Math.max(maxWeight, edge[2]);
        }

        double low = minWeight;
        double high = maxWeight;

        // Keep the same behavior: the program prints a rounded result.
        double precision = 1e-6;
        while (high - low > precision) {
            double mid = (low + high) / 2.0;
            if (canAchieveAverage(numberOfNodes, edges, src, dst, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int numberOfNodes = InputUtil.getInt("Enter number of nodes: ");
        int numberOfEdges = InputUtil.getInt("Enter number of edges: ");

        int[][] edges = new int[numberOfEdges][3];

        if (numberOfEdges > 0) {
            System.out.println("Enter edges (from to weight):");
            for (int i = 0; i < numberOfEdges; i++) {
                edges[i][0] = InputUtil.getInt("From: ");
                edges[i][1] = InputUtil.getInt("To: ");
                edges[i][2] = InputUtil.getInt("Weight: ");
            }
        }

        int src = InputUtil.getInt("Enter source node: ");
        int dst = InputUtil.getInt("Enter destination node: ");

        double result = findMaximumAverage(numberOfNodes, edges, src, dst);

        if (result == -1) {
            System.out.println("No path exists.");
        } else {
            System.out.println(Math.round(result));
        }
    }
}
