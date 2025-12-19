import java.util.Scanner;

/**
 * @Filename-WeatherStationDataAggregator.java
 * @Description- This counts how many days set a new temperature record.
 * @Author-Aditya Virmani
 */
public class WeatherStationDataAggregator {
    public static int countRecordDays(int[] temperature, int days) {
        if (days == 0)
            return 0;
        int result = 1;
        int maximum = temperature[0];

        for (int i = 1; i < days; i++) {
            if (temperature[i] > maximum) {
                result++;
                maximum = temperature[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of days");
        int days = InputHelper.readInt(scanner);
        int temperature[] = new int[days];

        System.out.println("Enter temperatures:");
        for (int i = 0; i < days; i++) {
            temperature[i] = InputHelper.readInt(scanner);
        }
        int recordDays = countRecordDays(temperature, days);

        System.out.println("No of days that set a new temperature record are: " + recordDays);
        scanner.close();
    }
}
