import java.util.*;

/**
 * @filename - DetectCycle.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    boolean bfs(int vertex, List<List<Integer>> adj) {
        int visit = 0;
        int[] inDegree = new int[vertex];
        Queue<Integer> q = new LinkedList<>();

        for (int u = 0; u < vertex; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }
        for (int u = 0; u < vertex; ++u) {
            if (inDegree[u] == 0) {
                q.add(u);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            visit++;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        return visit != vertex;
    }

}

public class DetectCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numer of vertices");
        int vertex = sc.nextInt();

        System.out.println("Enter number of edges");
        int edges = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        // initialize list
        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v); // directed edge u -> v
        }

        Solution sol = new Solution();
        if (sol.bfs(vertex, adj))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
