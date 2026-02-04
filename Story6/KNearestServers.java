import java.util.*;

/**
 * @Filename- KNearestServers.java
 * @Description- This is to determine the k nearest servers based on network latency
 * @Author- Aman Jeet Singh
 */
public class KNearestServers {

    public static List<Integer> findKNearestServers(
            int numberOfServers,
            int[][] edges,
            int sourceServer,
            int k) {
        List<int[]>[] adjacencyList = new ArrayList[numberOfServers];
        for (int i = 0; i < numberOfServers; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int fromServer = edge[0];
            int toServer = edge[1];
            int latency = edge[2];

            adjacencyList[fromServer].add(new int[]{toServer, latency});
            adjacencyList[toServer].add(new int[]{fromServer, latency});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[] visited = new boolean[numberOfServers];

        minHeap.offer(new int[]{0, sourceServer});

        List<Integer> nearestServers = new ArrayList<>();

        while (!minHeap.isEmpty() && nearestServers.size() < k) {
            int[] currentState = minHeap.poll();
            int currentDistance = currentState[0];
            int currentServer = currentState[1];

            if (visited[currentServer]) {
                continue;
            }

            visited[currentServer] = true;
            nearestServers.add(currentServer);

            for (int[] neighbor : adjacencyList[currentServer]) {
                int neighborServer = neighbor[0];
                int edgeLatency = neighbor[1];

                if (!visited[neighborServer]) {
                    minHeap.offer(new int[]{currentDistance + edgeLatency, neighborServer});
                }
            }
        }

        return nearestServers;
    }

    public static void main(String[] args) {
        int numberOfServers = InputUtil.getInt("Enter number of servers: ");
        int numberOfEdges = InputUtil.getInt("Enter number of connections: ");

        int[][] edges = new int[numberOfEdges][3];

        if (numberOfEdges > 0) {
            System.out.println("Enter connections (fromServer toServer latency):");
            for (int i = 0; i < numberOfEdges; i++) {
                edges[i][0] = InputUtil.getInt("From server: ");
                edges[i][1] = InputUtil.getInt("To server: ");
                edges[i][2] = InputUtil.getInt("Latency: ");
            }
        }

        int sourceServer = InputUtil.getInt("Enter central server ID: ");
        int k = InputUtil.getInt("Enter k (number of nearest servers): ");

        List<Integer> result = findKNearestServers(numberOfServers, edges, sourceServer, k);

        System.out.println("K Nearest Servers:");
        System.out.println(result);
    }
}
