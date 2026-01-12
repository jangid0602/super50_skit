import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Filename-SeatManager.java
 * @Description-This program manages concert seat assignments and determines the first
 *                   customer who requests a seat that has already been requested by another
 *                   customer. It uses a HashSet data structure to efficiently track assigned
 *                   seats and identify duplicate seat requests in O(1) average time complexity.
 *                   The program processes customer requests sequentially and stops when the
 *                   first duplicate is found.
 * @Author- Aman Jeet Singh
 */
public class SeatManager {
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

    /**
     * Safely reads a non-empty string from the scanner, prompting user until valid input is provided.
     */
    private static String readString(Scanner scanner) {
        String input = scanner.next().trim();
        while (input.isEmpty()) {
            System.out.println("Invalid input! Please enter a non-empty string.");
            input = scanner.next().trim();
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int customers = readInt(scanner);

        Set<String> assignedSeats = new HashSet<>();
        boolean duplicateFound = false;

        System.out.println("Enter [CustomerID SeatNumber]:");
        for (int i = 0; i < customers; i++) {
            System.out.print("Customer " + (i + 1) + " - CustomerID: ");
            String customerID = readString(scanner);
            System.out.print("Customer " + (i + 1) + " - SeatNumber: ");
            String seatNo = readString(scanner);

            // If seat already assigned, duplicate found
            if (assignedSeats.contains(seatNo)) {
                System.out.println("Duplicate found, Customer ID: " + customerID);
                duplicateFound = true;
                break;
            }
            assignedSeats.add(seatNo);
        }

        // If no duplicate seat request occurs
        if (!duplicateFound) {
            System.out.println("No duplicate found: -1");
        }
        scanner.close();
    }
}