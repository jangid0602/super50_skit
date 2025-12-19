package Story3.5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Assignments assignments = new Assignments();

        while (true) {
            System.out.println("\n===== WEEK 3.5 ASSIGNMENTS MENU =====");
            System.out.println("1. Cosmic Courier Challenge");
            System.out.println("2. Digital Library System");
            System.out.println("3. Factory Floor Robot");
            System.out.println("4. Spy’s Cipher");
            System.out.println("5. Concert Seat Manager");
            System.out.println("6. Weather Station Data Aggregator");
            System.out.println("7. Midpoint Finder");
            System.out.println("8. Browser History Navigator");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> assignments.cosmicCourierChallenge();
                case 2 -> assignments.digitalLibrarySystem();
                case 3 -> assignments.factoryFloorRobot();
                case 4 -> assignments.spiesCipher();
                case 5 -> assignments.concertSeatManager();
                case 6 -> assignments.weatherStationAggregator();
                case 7 -> assignments.midpointFinder();
                case 8 -> assignments.browserHistoryNavigator();
                case 9 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
