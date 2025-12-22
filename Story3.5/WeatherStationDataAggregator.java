import java.util.Scanner;

/**
 * @Filename-WeatherStationDataAggregator.java
 * @Description-This program counts how many days set a new temperature record at a weather
 *                   station. A day sets a record if its temperature is higher than all
 *                   previous days' temperatures. The first day is always counted as a record
 *                   day since it has no previous days to compare against. The algorithm
 *                   maintains a running maximum temperature and increments the count whenever
 *                   a new maximum is encountered.
 * @Author- Aman Jeet Singh
 */
public class WeatherStationDataAggregator {
    public static int countRecordDays(int[] temperature, int days) {
        if (days == 0) {
            return 0;
        }
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

    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int days = readInt(scanner);
        int temperature[] = new int[days];

        System.out.println("Enter temperatures:");
        for (int i = 0; i < days; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperature[i] = readInt(scanner);
        }
        int recordDays = countRecordDays(temperature, days);

        System.out.println("No of days that set a new temperature record are: " + recordDays);
        scanner.close();
    }
}