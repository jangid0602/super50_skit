import java.util.*;

/**
 * @filename - SCCCount.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {

    void dfs1(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, visited, stack, graph);
            }
        }

        stack.push(node);
    }

    void dfs2(int node, boolean[] visited, List<List<Integer>> reverseGraph) {
        visited[node] = true;

        for (int neighbor : reverseGraph.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, visited, reverseGraph);
            }
        }
    }

    int countSCC(int n, List<List<Integer>> graph) {

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Order nodes by finish time
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(i, visited, stack, graph);
            }
        }

        // Step 2: Reverse the graph
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            reverseGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int v : graph.get(i)) {
                reverseGraph.get(v).add(i);
            }
        }

        // Step 3: DFS in reverse order
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, visited, reverseGraph);
                sccCount++;
            }
        }

        return sccCount;
    }
}

public class SCCCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        Solution sol = new Solution();
        int result = sol.countSCC(n, graph);

        System.out.println("Number of Strongly Connected Components = " + result);
    }
}
