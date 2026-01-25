import java.util.*;
/**
 * @Filename- CheapestFlight.java
 * @Description- You are given a directed graph representing flight routes between n cities.
 * Each flight is represented as [from, to, price].
 * @Author- Mayank
 */
public class CheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights) {
            adj.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int u = curr[0];
                int cost = curr[1];

                if (!adj.containsKey(u)) continue;

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int price = neighbor[1];
                    if (cost + price < minCost[v]) {
                        minCost[v] = cost + price;
                        q.offer(new int[]{v, minCost[v]});
                    }
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        Input input = new Input();
        System.out.println("--- Cheapest Flight ---");
        System.out.print("Number of cities: ");
        int n = input.inputInteger();
        System.out.print("Number of flights (edges): ");
        int edgesCount = input.inputInteger();

        int[][] flights = new int[edgesCount][3];
        for(int i=0; i<edgesCount; i++) {
            System.out.println("Flight " + (i+1));
            flights[i][0] = input.inputInteger(); // from
            flights[i][1] = input.inputInteger(); // to
            flights[i][2] = input.inputInteger(); // price
        }

        System.out.print("Source: ");
        int src = input.inputInteger();
        System.out.print("Destination: ");
        int dst = input.inputInteger();
        System.out.print("Max Stops: ");
        int k = input.inputInteger();

        System.out.println("Result: " + findCheapestPrice(n, flights, src, dst, k));
    }
}