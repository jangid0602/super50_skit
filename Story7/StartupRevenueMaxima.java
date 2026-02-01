import java.util.Arrays;


/**
 * @Filename- StartupRevenueMaxima.java
 * @Description- This is to find the maximum revenue you can generate over N days.
 * @Author- Arman Agrawal
 */


public class StartupRevenueMaxima {

    static int calculateMaximumRevenue(
            int currentDayIndex,
            int[] dailyRevenue,
            int[] memoRevenue) {

        if (currentDayIndex < 0) {
            return 0;
        }

        if (memoRevenue[currentDayIndex] != -1) {
            return memoRevenue[currentDayIndex];
        }

        int revenueToday;
        if ((currentDayIndex + 1) % 7 == 0) {
            revenueToday = 2 * dailyRevenue[currentDayIndex];
        } else {
            revenueToday = dailyRevenue[currentDayIndex];
        }

        int takeCurrentDay =
                revenueToday +
                calculateMaximumRevenue(
                        currentDayIndex - 2,
                        dailyRevenue,
                        memoRevenue
                );

        int skipCurrentDay =
                calculateMaximumRevenue(
                        currentDayIndex - 1,
                        dailyRevenue,
                        memoRevenue
                );

        memoRevenue[currentDayIndex] =
                Math.max(takeCurrentDay, skipCurrentDay);

        return memoRevenue[currentDayIndex];
    }

    public static void main(String[] args) {

        System.out.print("Enter number of days: ");
        int numberOfDays = InputUtil.readInt();

        int[] dailyRevenue = new int[numberOfDays];

        System.out.println("Enter daily revenues:");
        for (int i = 0; i < numberOfDays; i++) {
            dailyRevenue[i] = InputUtil.readInt();
        }

        int[] memoRevenue = new int[numberOfDays];
        Arrays.fill(memoRevenue, -1);

        int maximumRevenue =
                calculateMaximumRevenue(
                        numberOfDays - 1,
                        dailyRevenue,
                        memoRevenue
                );

        System.out.println("Maximum Revenue: " + maximumRevenue);
    }
}
