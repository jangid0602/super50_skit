import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Finds all unique combinations of items whose prices sum exactly to a given budget.
 * Items can be used multiple times.
 * 
 * @author Aman Jeet Singh
 */
public class BudgetCalculator {

    /**
     * Finds all unique combinations of items that sum exactly to the budget.
     * 
     * @param startIndex Starting index in prices list
     * @param remainingBudget Remaining budget
     * @param itemPrices List of all item prices
     * @param currentCombination Current combination being built
     * @param allValidCombinations List to store all valid combinations
     */
    public static void findCombinations(int startIndex, int remainingBudget, List<Integer> itemPrices,
                                       List<Integer> currentCombination, List<List<Integer>> allValidCombinations) {
        // Base case: exact budget match, add current combination to results
        if (remainingBudget == 0) {
            allValidCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // Try each item starting from startIndex
        for (int priceIndex = startIndex; priceIndex < itemPrices.size(); priceIndex++) {
            // Skip duplicate prices at same level to avoid duplicate combinations
            if (priceIndex > startIndex && itemPrices.get(priceIndex).equals(itemPrices.get(priceIndex - 1))) {
                continue;
            }

            // If current item price exceeds remaining budget, skip (prices are sorted)
            if (itemPrices.get(priceIndex) > remainingBudget) {
                break;
            }

            // Include current item in combination
            currentCombination.add(itemPrices.get(priceIndex));
            // Recursively find combinations with remaining budget
            // Start from same index to allow multiple uses of same item
            findCombinations(priceIndex, remainingBudget - itemPrices.get(priceIndex), 
                           itemPrices, currentCombination, allValidCombinations);
            // Backtrack: remove current item to try other combinations
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    /**
     * Main method to interact with user and find all valid combinations.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfItems = 0;
        int totalBudget = 0;

        // Input validation: get number of items
        while (true) {
            try {
                System.out.print("Enter number of items: ");
                numberOfItems = inputScanner.nextInt();

                if (numberOfItems <= 0) {
                    System.out.println("Number of items must be positive!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Enter an integer.");
                inputScanner.nextLine();
            }
        }

        List<Integer> itemPrices = new ArrayList<>();
        System.out.println("Enter item prices:");

        // Collect all item prices
        for (int itemIndex = 0; itemIndex < numberOfItems; itemIndex++) {
            while (true) {
                try {
                    int itemPrice = inputScanner.nextInt();
                    if (itemPrice <= 0) {
                        System.out.println("Price must be positive!");
                        continue;
                    }
                    itemPrices.add(itemPrice);
                    break;
                } catch (Exception inputException) {
                    System.out.println("Invalid input! Enter an integer.");
                    inputScanner.nextLine();
                }
            }
        }

        // Input validation: get total budget
        while (true) {
            try {
                System.out.print("Enter total budget: ");
                totalBudget = inputScanner.nextInt();

                if (totalBudget <= 0) {
                    System.out.println("Budget must be positive!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Enter an integer.");
                inputScanner.nextLine();
            }
        }

        // Sort prices to enable efficient duplicate detection
        Collections.sort(itemPrices);

        List<List<Integer>> allValidCombinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        // Find all valid combinations
        findCombinations(0, totalBudget, itemPrices, currentCombination, allValidCombinations);

        // Display all valid combinations
        System.out.println("\nValid combinations:");
        System.out.println(allValidCombinations);

        inputScanner.close();
    }
}
