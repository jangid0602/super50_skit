import java.util.*;
import java.util.function.IntBinaryOperator;

/**
 * This class contains all the logic implementations for Week 6 graph and heap
 * problems.
 *
 * @author Bhavya Jain
 * @date 21 Jan 2026
 */
public class GraphLogics {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if (stops > k) {
                continue;
            }
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];
                    int newCost = cost + price;
                    if (newCost < distances[nextNode]) {
                        distances[nextNode] = newCost;
                        queue.offer(new int[]{nextNode, newCost, stops + 1});
                    }
                }
            }
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    private Map<Integer, List<int[]>> buildGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            graph.computeIfAbsent(e[1], x -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }
        return graph;
    }

    private int[] dijkstra(int n, Map<Integer, List<int[]>> graph, int start, IntBinaryOperator relaxOp) {
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int value = curr[1];

            if (value > best[node]) continue;

            if (!graph.containsKey(node)) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int w = nei[1];

                int newValue = relaxOp.applyAsInt(value, w);

                if (newValue < best[next]) {
                    best[next] = newValue;
                    pq.offer(new int[]{next, newValue});
                }
            }
        }
        return best;
    }


    public int findSafestPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<int[]>> graph = buildGraph(edges);

        int[] risk = dijkstra(n, graph, start, Math::max);

        return risk[end] == Integer.MAX_VALUE ? -1 : risk[end];
    }


    public int[] dijkstraAdjMatrix(int[][] matrix, int src) {
        int n = matrix.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            if (u == -1) break;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                    int newDist = dist[u] + matrix[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }

        return dist;
    }

    public List<Integer> kNearestServers(int n, int[][] edges, int s, int k) {
        Map<Integer, List<int[]>> graph = buildGraph(edges);

        int[] dist = dijkstra(n, graph, s, Integer::sum);

        List<int[]> servers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) servers.add(new int[]{i, dist[i]});
        }

        servers.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k, servers.size()); i++)
            res.add(servers.get(i)[0]);

        return res;
    }

    public boolean hasCycleBFS(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int processedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes++;

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return processedNodes < n;
    }

    public double maxAverageWeight(int[][] edges, int src, int dst) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        double maxAvg = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int sum = curr[1];
            int edgeCount = curr[2];

            if (node == dst && edgeCount > 0) {
                maxAvg = Math.max(maxAvg, (double) sum / edgeCount);
                continue;
            }

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    queue.offer(new int[]{nextNode, sum + weight, edgeCount + 1});
                }
            }
        }

        return maxAvg;
    }

    public int shortestPathVisitingAllNodes(int n, int[][] edges) {
        if (n == 1) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        int targetMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{i, mask, 0});
            visited.add(i + "," + mask);
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int mask = curr[1];
            int dist = curr[2];

            if (mask == targetMask) return dist;

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    int newMask = mask | (1 << neighbor);
                    String state = neighbor + "," + newMask;

                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.offer(new int[]{neighbor, newMask, dist + 1});
                    }
                }
            }
        }

        return -1; // Unreachable code
    }

    public int minCostPath(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 && col == n - 1) return cost;
            if (cost > dist[row][col]) continue;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newCost = cost + grid[newRow][newCol];

                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.offer(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
