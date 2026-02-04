import java.util.Scanner;
/*
discription: This program finds the maximum profit for a T-second video slot using M ads, where repeating the same ad gives 50% profit on the second instance.
author: Aman Jeet Singh
*/

public class AdPlacement {

    static double profitForUses(int baseProfit, int uses) {
        if (uses == 0) return 0;
        double sum = baseProfit;
        double mult = 0.5;
        for (int u = 1; u < uses; u++) {
            sum += baseProfit * mult;
            mult *= 0.5;
        }
        return sum;
    }

    static double maxProfit(int totalSec, int[] duration, int[] profit) {
        int numAds = duration.length;
        double[] dp = new double[totalSec + 1];
        for (int a = 0; a < numAds; a++) {
            int d = duration[a];
            int p = profit[a];
            double[] next = dp.clone();
            for (int t = totalSec; t >= d; t--) {
                for (int uses = 1; uses * d <= t; uses++) {
                    int rem = t - uses * d;
                    double gain = profitForUses(p, uses);
                    next[t] = Math.max(next[t], dp[rem] + gain);
                }
            }
            dp = next;
        }
        return dp[totalSec];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter total seconds T: ");
        int totalSec = scan.nextInt();
        System.out.print("Enter number of ads M: ");
        int numAds = scan.nextInt();
        int[] duration = new int[numAds];
        int[] profit = new int[numAds];
        System.out.println("Enter each ad as: duration profit");
        for (int i = 0; i < numAds; i++) {
            duration[i] = scan.nextInt();
            profit[i] = scan.nextInt();
        }

        System.out.println();
        System.out.println("T: " + totalSec + ", M: " + numAds);
        for (int i = 0; i < numAds; i++) {
            System.out.println("  Ad " + (i + 1) + ": (" + duration[i] + ", " + profit[i] + ")");
        }
        System.out.println("Maximum profit: " + (int) maxProfit(totalSec, duration, profit));
        scan.close();
    }
}
