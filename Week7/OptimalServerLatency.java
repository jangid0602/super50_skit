import java.util.*;

/**
 * @Filename-OptimalServerLatency.java
 * @Description-Minimizes total unbalance by partitioning servers into K
 *                        contiguous clusters.
 * @Author-Aditya Virmani
 */

public class OptimalServerLatency {

    public static int minimumUnbalance(int totalServers, int totalClusters, int[] powerArray) {

        int[][] unbalance = new int[totalServers][totalServers];

        for (int start = 0; start < totalServers; start++) {
            int minPower = powerArray[start];
            int maxPower = powerArray[start];

            for (int end = start; end < totalServers; end++) {
                minPower = Math.min(minPower, powerArray[end]);
                maxPower = Math.max(maxPower, powerArray[end]);
                unbalance[start][end] = maxPower - minPower;
            }
        }

        int[][] dp = new int[totalClusters + 1][totalServers + 1];

        for (int k = 0; k <= totalClusters; k++) {
            Arrays.fill(dp[k], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int k = 1; k <= totalClusters; k++) {
            for (int i = 1; i <= totalServers; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[k - 1][j] != Integer.MAX_VALUE) {
                        dp[k][i] = Math.min(
                                dp[k][i],
                                dp[k - 1][j] + unbalance[j][i - 1]);
                    }
                }
            }
        }

        return dp[totalClusters][totalServers];
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of servers: ");
            int totalServers = scanner.nextInt();

            System.out.print("Enter number of clusters: ");
            int totalClusters = scanner.nextInt();

            int[] powerArray = new int[totalServers];

            System.out.println("Enter server processing powers:");
            for (int i = 0; i < totalServers; i++) {
                powerArray[i] = scanner.nextInt();
            }

            int result = minimumUnbalance(totalServers, totalClusters, powerArray);
            System.out.println("Minimum Total Unbalance: " + result);

            scanner.close();

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values.");
        }
    }
}
