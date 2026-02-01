import java.util.*;


/**
 * @Filename- CheapestFlightWithinKStops.java
 * @Description- This is to find the minimum cost to travel from src to dst using at most k stops
 * @Author- Arman Agrawal
 */




public class CheapestFlightWithinKStops {

    public static int findCheapestPrice(int size, int[][] flights,
                                        int src, int dest, int k) {

        List<int[]>[] adjacencyList = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adjacencyList[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> minimumHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minimumHeap.offer(new int[]{0, src, 0});

        int[][] minimumCost = new int[size][k + 2];
        for (int i = 0; i < size; i++) {
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

            if (stopsUsed > k) continue;

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
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        System.out.print("Enter number of flights: ");
        int m = sc.nextInt();

        int[][] flights = new int[m][3];
        System.out.println("Enter flights (from to price):");
        for (int i = 0; i < m; i++) {
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
        }

        System.out.print("Enter source city: ");
        int src = sc.nextInt();

        System.out.print("Enter destination city: ");
        int dest = sc.nextInt();

        System.out.print("Enter max stops (k): ");
        int k = sc.nextInt();

        int result = findCheapestPrice(n, flights, src, dest, k);

        System.out.println("Cheapest Price: " + result);
        sc.close();
    }
}
