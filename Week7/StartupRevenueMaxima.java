import java.util.*;
/**
* @Filename-StartupRevenueMaxima.java
* @Description-Finds the maximum revenue over N days.
* @Author-Aditya Virmani
*/

public class StartupRevenueMaxima {

    public static int getMaxRevenue(int totalDays, int[] revenueArray) {

        if (totalDays == 0)
            return 0;
        if (totalDays == 1)
            return revenueArray[0];

        int[] dp = new int[totalDays];

        dp[0] = revenueArray[0];
        dp[1] = Math.max(revenueArray[0], revenueArray[1]);

        for (int day = 2; day < totalDays; day++) {
            int todaysRevenue = revenueArray[day];
            if ((day + 1) % 7 == 0) {
                todaysRevenue = 2 * todaysRevenue;
            }

            int workToday = todaysRevenue + dp[day - 2];
            int restToday = dp[day - 1];

            dp[day] = Math.max(workToday, restToday);
        }

        return dp[totalDays - 1];
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of days: ");
            int totalDays = scanner.nextInt();

            int[] revenueArray = new int[totalDays];

            System.out.println("Enter revenue for each day:");
            for (int i = 0; i < totalDays; i++) {
                revenueArray[i] = scanner.nextInt();
            }

            int maxRevenue = getMaxRevenue(totalDays, revenueArray);
            System.out.println("Maximum Revenue: " + maxRevenue);

            scanner.close();

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values.");
        }
    }
}
