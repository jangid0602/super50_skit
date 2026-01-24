import java.util.*;

/**
 * @Filename- CheapestFlightWithinKStops.java
 * @Description- This is to find the minimum cost to travel from src to dest using at most k stops
 * @Author- Aman Jeet Singh
 */
public class CheapestFlightWithinKStops {

    public static int findCheapestPrice(int numberOfCities, int[][] flights, int src, int dest, int k) {
        List<int[]>[] adjacencyList = new ArrayList[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adjacencyList[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> minimumHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minimumHeap.offer(new int[]{0, src, 0});

        int[][] minimumCost = new int[numberOfCities][k + 2];
        for (int i = 0; i < numberOfCities; i++) {
            Arrays.fill(minimumCost[i], Integer.MAX_VALUE);
        }

        minimumCost[src][0] = 0;

        while (!minimumHeap.isEmpty()) {
            int[] state = minimumHeap.poll();
            int currentCost = state[0];
            int currentCity = state[1];
            int stopsUsed = state[2];

            if (currentCity == dest) {
                return currentCost;
            }

            if (stopsUsed > k) {
                continue;
            }

            for (int[] edge : adjacencyList[currentCity]) {
                int nextCity = edge[0];
                int nextCost = currentCost + edge[1];

                if (nextCost < minimumCost[nextCity][stopsUsed + 1]) {
                    minimumCost[nextCity][stopsUsed + 1] = nextCost;
                    minimumHeap.offer(new int[]{nextCost, nextCity, stopsUsed + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int numberOfCities = InputUtil.getInt("Enter number of cities: ");
        int numberOfFlights = InputUtil.getInt("Enter number of flights: ");

        int[][] flights = new int[numberOfFlights][3];
        System.out.println("Enter flights (from to price):");
        for (int i = 0; i < numberOfFlights; i++) {
            flights[i][0] = InputUtil.getInt("From: ");
            flights[i][1] = InputUtil.getInt("To: ");
            flights[i][2] = InputUtil.getInt("Price: ");
        }

        int src = InputUtil.getInt("Enter source city: ");
        int dest = InputUtil.getInt("Enter destination city: ");
        int k = InputUtil.getInt("Enter max stops (k): ");

        int result = findCheapestPrice(numberOfCities, flights, src, dest, k);
        System.out.println("Cheapest Price: " + result);
    }
}
