import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Generates all unique permutations of a given set of digits using backtracking.
 * 
 * @author Aman Jeet Singh
 */
public class SecureVaultCode {

    /**
     * Generates all unique permutations of digits using backtracking.
     * 
     * @param currentIndex The current position being processed
     * @param allPermutations List to store all generated permutations
     * @param digitList The list of digits to permute
     */
    public static void generatePermutations(int currentIndex, List<List<Integer>> allPermutations, 
                                            List<Integer> digitList) {
        // Base case: all positions filled, add current permutation to results
        if (currentIndex == digitList.size()) {
            allPermutations.add(new ArrayList<>(digitList));
            return;
        }

        // Track digits used at current position to avoid duplicates
        HashSet<Integer> usedDigitsAtPosition = new HashSet<>();

        // Try each digit at current position
        for (int swapIndex = currentIndex; swapIndex < digitList.size(); swapIndex++) {
            // Skip if this digit was already used at current position
            if (usedDigitsAtPosition.contains(digitList.get(swapIndex))) {
                continue;
            }

            usedDigitsAtPosition.add(digitList.get(swapIndex));

            // Swap to place current digit at current position
            swapElements(digitList, swapIndex, currentIndex);
            // Recursively generate permutations for remaining positions
            generatePermutations(currentIndex + 1, allPermutations, digitList);
            // Backtrack: restore original order
            swapElements(digitList, swapIndex, currentIndex);
        }
    }

    /**
     * Swaps two elements in a list at given indices.
     * 
     * @param list The list to swap elements in
     * @param firstIndex Index of first element
     * @param secondIndex Index of second element
     */
    public static void swapElements(List<Integer> list, int firstIndex, int secondIndex) {
        int temporaryValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temporaryValue);
    }

    /**
     * Main method to interact with user and generate all unique permutations.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfDigits = 0;

        // Input validation: get number of digits
        while (true) {
            try {
                System.out.print("Enter number of digits: ");
                numberOfDigits = inputScanner.nextInt();

                if (numberOfDigits <= 0) {
                    System.out.println("Number must be positive!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Enter an integer.");
                inputScanner.nextLine();
            }
        }

        List<Integer> digitList = new ArrayList<>();

        // Collect all digits from user
        System.out.println("Enter digits:");
        for (int digitIndex = 0; digitIndex < numberOfDigits; digitIndex++) {
            int currentDigit;
            while (true) {
                try {
                    currentDigit = inputScanner.nextInt();
                    break;
                } catch (Exception inputException) {
                    System.out.println("Invalid input! Enter an integer.");
                    inputScanner.nextLine();
                }
            }
            digitList.add(currentDigit);
        }

        List<List<Integer>> allUniquePermutations = new ArrayList<>();

        // Generate all unique permutations
        generatePermutations(0, allUniquePermutations, digitList);

        // Display all generated unique vault codes
        System.out.println("\nAll Possible Unique Vault Codes:");
        for (List<Integer> vaultCode : allUniquePermutations) {
            for (int codeDigit : vaultCode) {
                System.out.print(codeDigit);
            }
            System.out.print(" ");
        }

        inputScanner.close();
    }
}
