import java.util.Scanner;
/*
discription: This program divides N servers into K contiguous clusters and minimizes the sum of unbalance (max minus min power) in each cluster.
author: Aman Jeet Singh
*/

public class OptimalServerLatency {

    static int unbalance(int[] power, int left, int right) {
        int min = power[left];
        int max = power[left];
        for (int i = left + 1; i <= right; i++) {
            min = Math.min(min, power[i]);
            max = Math.max(max, power[i]);
        }
        return max - min;
    }

    static int minTotalUnbalance(int size, int clusters, int[] power) {
        int inf = Integer.MAX_VALUE / 2;
        int[][] dp = new int[clusters + 1][size + 1];
        for (int k = 0; k <= clusters; k++) {
            for (int i = 0; i <= size; i++) {
                dp[k][i] = inf;
            }
        }
        dp[0][0] = 0;

        for (int k = 1; k <= clusters; k++) {
            for (int i = k; i <= size; i++) {
                for (int j = k - 1; j < i; j++) {
                    int cost = unbalance(power, j, i - 1);
                    dp[k][i] = Math.min(dp[k][i], dp[k - 1][j] + cost);
                }
            }
        }
        return dp[clusters][size];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter N and K: ");
        int size = scan.nextInt();
        int clusters = scan.nextInt();
        int[] power = new int[size];
        System.out.print("Enter server powers (space separated): ");
        for (int i = 0; i < size; i++) {
            power[i] = scan.nextInt();
        }

        System.out.println();
        System.out.println("N: " + size + ", K: " + clusters);
        System.out.print("Array A: ");
        for (int i = 0; i < size; i++) {
            System.out.print(power[i]);
            if (i < size - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("Minimum total unbalance: " + minTotalUnbalance(size, clusters, power));
        scan.close();
    }
}
