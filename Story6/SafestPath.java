import java.util.*;

/**
 * @filename - SafestPath.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    int minRisk = Integer.MAX_VALUE;

    void dfs(int node, int end, int currentRisk, boolean[] visited, List<List<int[]>> graph) {

        if (node == end) {
            minRisk = Math.min(minRisk, currentRisk);
            return;
        }

        visited[node] = true;

        for (int[] edge : graph.get(node)) {
            int nextNode = edge[0];
            int risk = edge[1];

            if (!visited[nextNode]) {
                int newRisk = Math.max(currentRisk, risk);
                dfs(nextNode, end, newRisk, visited, graph);
            }
        }

        visited[node] = false; // backtrack
    }
}

public class SafestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int vertex = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edge = sc.nextInt();

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v risk):");
        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int risk = sc.nextInt();

            graph.get(u).add(new int[] { v, risk });
            graph.get(v).add(new int[] { u, risk }); // Undirected
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        System.out.print("Enter end node: ");
        int end = sc.nextInt();

        Solution sol = new Solution();
        boolean[] visited = new boolean[vertex];

        sol.dfs(start, end, 0, visited, graph);

        if (sol.minRisk == Integer.MAX_VALUE)
            System.out.println("Minimum Risk Path Value = -1");
        else
            System.out.println("Minimum Risk Path Value = " + sol.minRisk);
    }
}
