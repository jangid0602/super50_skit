
package Week3_5;

public class WeatherAggregator {
    // Counts days that set a new record high compared to all previous days.
    public static int countRecordDays(int[] temps) {
        if (temps == null || temps.length == 0) return 0;
        int records = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int t : temps) {
            if (t > maxSoFar) {
                records++;
                maxSoFar = t;
            }
        }
        return records;
    }
}
