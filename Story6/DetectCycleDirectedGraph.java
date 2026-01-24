import java.util.*;

/**
 * @Filename- DetectCycleDirectedGraph.java
 * @Description- This is to determine whether it contains a cycle.
 * @Author- Arman Agrawal
 */


public class DetectCycleDirectedGraph {

    public static boolean hasCycle(int numberOfNodes, int[][] edges) {

        List<Integer>[] adjacencyList = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] inDegree = new int[numberOfNodes];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adjacencyList[from].add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numberOfNodes; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedNodes = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            processedNodes++;

            for (int neighbor : adjacencyList[currentNode]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processedNodes != numberOfNodes;
    }

    public static void main(String[] args) {

        int numberOfNodes = InputUtil.getInt("Enter number of nodes: ");
        int numberOfEdges = InputUtil.getInt("Enter number of edges: ");

        int[][] edges = new int[numberOfEdges][2];

        if (numberOfEdges > 0) {
            System.out.println("Enter directed edges (from to):");
            for (int i = 0; i < numberOfEdges; i++) {
                edges[i][0] = InputUtil.getInt("From: ");
                edges[i][1] = InputUtil.getInt("To: ");
            }
        }

        boolean cycleExists = hasCycle(numberOfNodes, edges);

        System.out.println(cycleExists);
    }
}
