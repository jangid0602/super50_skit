import java.util.*;
/**
 * @Filename- SafestPath.java
 * @Description- You are given an undirected weighted graph where each edge weight represents risk
 * level.
 * The safety of a path is defined as the maximum edge risk encountered along that
 * path.
 * @Author- Kripendra
 */

public class SafestPath {
    public static int minRiskPath(int n, int[][] edges, int start, int end) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        int[] risk = new int[n];
        Arrays.fill(risk, Integer.MAX_VALUE);
        risk[start] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (u == end) return d;
            if (d > risk[u]) continue;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                int maxRiskInPath = Math.max(d, weight);
                if (maxRiskInPath < risk[v]) {
                    risk[v] = maxRiskInPath;
                    pq.offer(new int[]{v, risk[v]});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Input input = new Input();
        System.out.print("Enter number of nodes: ");
        int n = input.inputInteger();
        System.out.print("Enter number of edges: ");
        int eCount = input.inputInteger();
        int[][] edges = new int[eCount][3];
        for(int i=0; i<eCount; i++) {
            edges[i][0] = input.inputInteger();
            edges[i][1] = input.inputInteger();
            edges[i][2] = input.inputInteger();
        }
        System.out.print("Start node: ");
        int start = input.inputInteger();
        System.out.print("End node: ");
        int end = input.inputInteger();

        System.out.println("Minimum Risk: " + minRiskPath(n, edges, start, end));
    }
}