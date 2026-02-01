import java.util.*;


/**
 * @Filename- PathWithMaximumAverageWeight.java
 * @Description- This is to find a path from src to dst such that the average edge weight along the path is maximized
 * @Author- Arman Agrawal
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

            if (!updated) break;
        }

        return maximumScore[dst] >= 0;
    }

    public static double findMaximumAverage(
            int numberOfNodes,
            int[][] edges,
            int src,
            int dst) {

        boolean reachable = false;
        for (int[] e : edges) {
            if (e[0] == src) {
                reachable = true;
                break;
            }
        }
        if (!reachable) return -1;

        double low = -1e6, high = 1e6;
        double precision = 1e-6;

        while (high - low > precision) {
            double mid = (low + high) / 2;

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
            System.out.println( Math.round(result));
        }
    }
}
