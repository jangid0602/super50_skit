import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GraphsSolutions gs = new GraphsSolutions();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 Cheapest Flight");
            System.out.println("2 Minimum Risk Path");
            System.out.println("3 Shortest Distance Matrix");
            System.out.println("4 Detect Cycle Directed");
            System.out.println("5 Visit All Nodes");
            System.out.println("0 Exit");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                sc.next();
                continue;
            }

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Cheapest Flight Selected");
                    System.out.println("Enter n (cities) and m (flights):");
                    int n = sc.nextInt();
                    int m = sc.nextInt();

                    int[][] flights = new int[m][3];
                    System.out.println("Enter flights (from to cost):");
                    for (int i = 0; i < m; i++)
                        for (int j = 0; j < 3; j++)
                            flights[i][j] = sc.nextInt();

                    System.out.println("Enter src, dst, k:");
                    int src = sc.nextInt();
                    int dst = sc.nextInt();
                    int k = sc.nextInt();

                    int result = gs.findCheapestPrice(n, flights, src, dst, k);
                    System.out.println("Cheapest Price = " + result);
                }

                case 2 -> {
                    System.out.println("Minimum Risk Path Selected");
                    System.out.println("Enter n (nodes) and m (edges):");
                    int n = sc.nextInt();
                    int m = sc.nextInt();

                    int[][] edges = new int[m][3];
                    System.out.println("Enter edges (u v risk):");
                    for (int i = 0; i < m; i++)
                        for (int j = 0; j < 3; j++)
                            edges[i][j] = sc.nextInt();

                    System.out.println("Enter start and end:");
                    int s = sc.nextInt();
                    int e = sc.nextInt();

                    int result = gs.findMinimumRisk(n, edges, s, e);
                    System.out.println("Minimum Risk = " + result);
                }

                case 3 -> {
                    System.out.println("Shortest Distance Matrix Selected");
                    System.out.println("Enter n (vertices):");
                    int n = sc.nextInt();

                    int[][] matrix = new int[n][n];
                    System.out.println("Enter adjacency matrix:");
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            matrix[i][j] = sc.nextInt();

                    System.out.println("Enter source vertex:");
                    int src = sc.nextInt();

                    int[] dist = gs.shortestDistance(matrix, src);
                    System.out.println("Distance Array:");
                    System.out.println(Arrays.toString(dist));
                }

                case 4 -> {
                    System.out.println("Detect Cycle in Directed Graph Selected");
                    System.out.println("Enter V (vertices) and E (edges):");
                    int V = sc.nextInt();
                    int E = sc.nextInt();

                    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

                    System.out.println("Enter directed edges (u v):");
                    for (int i = 0; i < E; i++) {
                        int u = sc.nextInt();
                        int v = sc.nextInt();
                        if (u >= 0 && v >= 0 && u < V && v < V)
                            adj.get(u).add(v);
                    }

                    boolean hasCycle = gs.isCyclic(V, adj);
                    System.out.println("Cycle Present = " + hasCycle);
                }

                case 5 -> {
                    System.out.println("Visit All Nodes (Shortest Path Length) Selected");
                    System.out.println("Enter number of nodes:");
                    int n = sc.nextInt();

                    int[][] graph = new int[n][];
                    System.out.println("Enter adjacency list:");
                    for (int i = 0; i < n; i++) {
                        int sz = sc.nextInt();
                        graph[i] = new int[sz];
                        for (int j = 0; j < sz; j++)
                            graph[i][j] = sc.nextInt();
                    }

                    int result = gs.shortestPathLength(graph);
                    System.out.println("Shortest Path Length = " + result);
                }
            }
        }
        sc.close();
    }
}
