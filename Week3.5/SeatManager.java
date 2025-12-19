import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * @Filename-ConcertSeatManager.java
 * @Description-This determines the first customer who requests a seat
 *                   that has already been requested by someone else.
 * @Author-Aditya Virmani
 */
public class SeatManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking integer input with the help of InputHelper class
        System.out.println("Enter the number of customers");
        int customers = InputHelper.readInt(scanner);

        Set<String> assignedSeats = new HashSet<>();
        boolean duplicateFound = false;

        System.out.println("Enter [CustomerID SeatNumber]");

        for (int i = 0; i < customers; i++) {
            String customerID = scanner.next();
            String seatNo = scanner.next();

            // If seat already assigned, duplicate found
            if (assignedSeats.contains(seatNo)) {
                System.out.println("Duplicate found,Customer ID: " + customerID);
                duplicateFound = true;
                break;
            }
            assignedSeats.add(seatNo);
        }

        // If no duplicate seat request occurs
        if (!duplicateFound) {
            System.out.println("No duplicate found:-1");
        }
        scanner.close();
    }
}
