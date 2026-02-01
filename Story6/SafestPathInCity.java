import java.util.*;


/**
 * @Filename- SafestPathInCity.java
 * @Description- This is to find a path from node start to node end such that the path safety is
minimized.
 * @Author- Arman Agrawal
 */



public class SafestPathInCity {

    public static int findSafestPath(int n, int[][] edges, int start, int end) {

        List<int[]>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjacencyList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int first = edge[0], second = edge[1], risk = edge[2];
            adjacencyList[first].add(new int[]{second, risk});
            adjacencyList[second].add(new int[]{first, risk});
        }

        int[] minimumRisk = new int[n];
        Arrays.fill(minimumRisk, Integer.MAX_VALUE);
        minimumRisk[start] = 0;

        PriorityQueue<int[]> minimumHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minimumHeap.offer(new int[]{0, start});

        while (!minimumHeap.isEmpty()) {
            int[] state = minimumHeap.poll();
            int currentRisk = state[0];
            int currentNode = state[1];

            if (currentNode == end) return currentRisk;

            for (int[] next : adjacencyList[currentNode]) {
                int nextNode = next[0];
                int edgeRisk = next[1];

                int pathRisk = Math.max(currentRisk, edgeRisk);

                if (pathRisk < minimumRisk[nextNode]) {
                    minimumRisk[nextNode] = pathRisk;
                    minimumHeap.offer(new int[]{pathRisk, nextNode});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int n = InputUtil.getInt("Enter number of nodes: ");
        int m = InputUtil.getInt("Enter number of edges: ");

        int[][] edges = new int[m][3];

        System.out.println("Enter edges (u v risk):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = InputUtil.getInt("u: ");
            edges[i][1] = InputUtil.getInt("v: ");
            edges[i][2] = InputUtil.getInt("risk: ");
        }

        int start = InputUtil.getInt("Enter start node: ");
        int end = InputUtil.getInt("Enter end node: ");

        int result = findSafestPath(n, edges, start, end);
        System.out.println("Minimum Possible Risk: " + result);
    }
}
