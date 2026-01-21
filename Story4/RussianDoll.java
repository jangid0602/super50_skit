import java.util.Scanner;

/**
 * Recursively searches through nested dolls to find a key.
 * 
 * @author Aman Jeet Singh
 */
class Doll {
    int dollSize;
    boolean containsKey;
    Doll innerDoll;

    /**
     * Constructor to create a new doll.
     * 
     * @param dollSize The size of the doll
     * @param containsKey Whether this doll contains the key
     */
    Doll(int dollSize, boolean containsKey) {
        this.dollSize = dollSize;
        this.containsKey = containsKey;
        this.innerDoll = null;
    }
}

public class RussianDoll {

    /**
     * Recursively searches through nested dolls to find the key.
     * 
     * @param currentDoll The doll to check for the key
     */
    public static void findKey(Doll currentDoll) {
        // Base case: null doll reference
        if (currentDoll == null) {
            System.out.println("Error: Doll does not exist!");
            return;
        }

        System.out.println("Opening Doll of size: " + currentDoll.dollSize);

        // If current doll has the key, search is complete
        if (currentDoll.containsKey) {
            System.out.println("Key Found!");
            return;
        }

        // If no inner doll exists, key is not found
        if (currentDoll.innerDoll == null) {
            System.out.println("No more dolls inside and key not found!");
            return;
        }

        // Recursive case: continue searching in the inner doll
        findKey(currentDoll.innerDoll);
    }

    /**
     * Main method to interact with user and search for key.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfDolls = 0;
        boolean isKeyInSmallestDoll = false;

        // Input validation: get number of dolls
        while (true) {
            try {
                System.out.print("Enter number of dolls: ");
                numberOfDolls = inputScanner.nextInt();

                if (numberOfDolls <= 0) {
                    System.out.println("Error: Number of dolls must be positive!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Please enter an integer value.");
                inputScanner.nextLine();
            }
        }

        // Input validation: check if smallest doll has the key
        while (true) {
            try {
                System.out.print("Does the smallest doll have the key? (true/false): ");
                isKeyInSmallestDoll = inputScanner.nextBoolean();
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Please enter true or false.");
                inputScanner.nextLine();
            }
        }

        // Build nested doll structure: start with smallest (innermost) doll
        Doll currentDoll = new Doll(1, isKeyInSmallestDoll);

        // Create outer dolls, each containing the previous doll
        for (int dollSize = 2; dollSize <= numberOfDolls; dollSize++) {
            Doll outerDoll = new Doll(dollSize, false);
            outerDoll.innerDoll = currentDoll;
            currentDoll = outerDoll;
        }

        // Search for the key starting from outermost doll
        findKey(currentDoll);
        inputScanner.close();
    }
}
