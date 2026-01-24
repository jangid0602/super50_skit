import util.CustomScanner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Main class for Week 6 - Graph and Heap Problems
 * Demonstrates usage of various graph algorithms and priority queue operations
 *
 * @author Bhavya Jain
 * @date 21 Jan 2026
 */
public class Main {
    public static void main(String[] args) {
        try {
            CustomScanner scanner = new CustomScanner(new InputStreamReader(System.in));
            GraphLogics graphLogics = new GraphLogics();

            while (true) {
                System.out.println("\n=== Graph and Heap Problems Menu ===");
                System.out.println("1. Find Cheapest Price");
                System.out.println("2. Find Safest Path");
                System.out.println("3. Dijkstra (Adjacency Matrix)");
                System.out.println("4. K Nearest Servers");
                System.out.println("5. Has Cycle (BFS)");
                System.out.println("6. Max Average Weight");
                System.out.println("7. Shortest Path Visiting All Nodes");
                System.out.println("8. Min Cost Path (Grid)");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter number of cities: ");
                        int n = scanner.nextInt();
                        System.out.print("Enter number of flights: ");
                        int flightCount = scanner.nextInt();
                        System.out.println("Enter flights (from to price):");
                        int[][] flights = scanner.readEdges(flightCount, 3);
                        System.out.print("Enter source city: ");
                        int src = scanner.nextInt();
                        System.out.print("Enter destination city: ");
                        int dst = scanner.nextInt();
                        System.out.print("Enter max stops: ");
                        int k = scanner.nextInt();

                        int result = graphLogics.findCheapestPrice(n, flights, src, dst, k);
                        System.out.println("Cheapest price: " + result);
                    }
                    case 2 -> {
                        System.out.print("Enter number of nodes: ");
                        int n = scanner.nextInt();
                        System.out.print("Enter number of edges: ");
                        int edgeCount = scanner.nextInt();
                        System.out.println("Enter edges (from to risk):");
                        int[][] edges = scanner.readEdges(edgeCount, 3);
                        System.out.print("Enter start node: ");
                        int start = scanner.nextInt();
                        System.out.print("Enter end node: ");
                        int end = scanner.nextInt();

                        int result = graphLogics.findSafestPath(n, edges, start, end);
                        System.out.println("Minimum maximum risk: " + result);
                    }
                    case 3 -> {
                        System.out.print("Enter number of vertices: ");
                        int n = scanner.nextInt();
                        System.out.println("Enter adjacency matrix (" + n + "x" + n + "):");
                        int[][] matrix = scanner.readIntMatrix(n, n);
                        System.out.print("Enter source vertex: ");
                        int src = scanner.nextInt();

                        int[] distances = graphLogics.dijkstraAdjMatrix(matrix, src);
                        System.out.println("Shortest distances from source " + src + ":");
                        for (int i = 0; i < distances.length; i++) {
                            System.out.println("To " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]));
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter number of servers: ");
                        int n = scanner.nextInt();
                        System.out.print("Enter number of connections: ");
                        int edgeCount = scanner.nextInt();
                        System.out.println("Enter connections (server1 server2 latency):");
                        int[][] edges = scanner.readEdges(edgeCount, 3);
                        System.out.print("Enter source server: ");
                        int s = scanner.nextInt();
                        System.out.print("Enter k (number of nearest servers): ");
                        int k = scanner.nextInt();

                        List<Integer> result = graphLogics.kNearestServers(n, edges, s, k);
                        System.out.println("K nearest servers: " + result);
                    }
                    case 5 -> {
                        System.out.print("Enter number of nodes: ");
                        int n = scanner.nextInt();
                        System.out.print("Enter number of directed edges: ");
                        int edgeCount = scanner.nextInt();
                        System.out.println("Enter directed edges (from to):");
                        int[][] edges = scanner.readEdges(edgeCount, 2);

                        boolean hasCycle = graphLogics.hasCycleBFS(n, edges);
                        System.out.println("Has cycle: " + hasCycle);
                    }
                    case 6 -> {
                        System.out.print("Enter number of directed edges: ");
                        int edgeCount = scanner.nextInt();
                        System.out.println("Enter directed edges (from to weight):");
                        int[][] edges = scanner.readEdges(edgeCount, 3);
                        System.out.print("Enter source node: ");
                        int src = scanner.nextInt();
                        System.out.print("Enter destination node: ");
                        int dst = scanner.nextInt();

                        double result = graphLogics.maxAverageWeight(edges, src, dst);
                        System.out.println("Maximum average weight: " + result);
                    }
                    case 7 -> {
                        System.out.print("Enter number of nodes: ");
                        int n = scanner.nextInt();
                        System.out.print("Enter number of edges: ");
                        int edgeCount = scanner.nextInt();
                        System.out.println("Enter edges (node1 node2):");
                        int[][] edges = scanner.readEdges(edgeCount, 2);

                        int result = graphLogics.shortestPathVisitingAllNodes(n, edges);
                        System.out.println("Shortest path length visiting all nodes: " + result);
                    }
                    case 8 -> {
                        System.out.print("Enter number of rows: ");
                        int m = scanner.nextInt();
                        System.out.print("Enter number of columns: ");
                        int n = scanner.nextInt();
                        System.out.println("Enter grid (" + m + "x" + n + "):");
                        int[][] grid = scanner.readIntMatrix(m, n);

                        int result = graphLogics.minCostPath(grid);
                        System.out.println("Minimum cost path: " + result);
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
