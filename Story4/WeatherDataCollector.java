package Story4;
public class WeatherDataCollector {
    public static int countRecordDays(int[] temps) {
        if (temps.length == 0)
            return 0;

        int count = 1; // first day is always a record
        int maxSoFar = temps[0];

        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > maxSoFar) {
                count++;
                maxSoFar = temps[i];
            }
        }
        return count;
    }
}
