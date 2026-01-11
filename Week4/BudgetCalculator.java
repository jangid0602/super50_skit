import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Filename-BudgetCalculator.java
 * @Description-Finds all unique combinations of items whose sum equals the
 *                    budget
 * @Author-Aditya Virmani
 */
public class BudgetCalculator {

    static void findCombinations(int index, int budget, List<Integer> prices, List<Integer> currentCombination,
            List<List<Integer>> allCombinations) {

        if (budget == 0) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = index; i < prices.size(); i++) {
            if (i > index && prices.get(i).equals(prices.get(i - 1))) {
                continue;
            }

            if (prices.get(i) > budget) {
                break;
            }
            currentCombination.add(prices.get(i));
            findCombinations(i, budget - prices.get(i), prices, currentCombination, allCombinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int numberOfItems = 0;
        int budget = 0;
        while (true) {
            try {
                System.out.print("Enter number of items: ");
                numberOfItems = userInput.nextInt();

                if (numberOfItems <= 0) {
                    System.out.println("Number of items must be positive!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter an integer.");
                userInput.nextLine();
            }
        }

        List<Integer> prices = new ArrayList<>();
        System.out.println("Enter item prices:");

        for (int i = 0; i < numberOfItems; i++) {
            while (true) {
                try {
                    int price = userInput.nextInt();
                    if (price <= 0) {
                        System.out.println("Price must be positive!");
                        continue;
                    }
                    prices.add(price);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Enter an integer.");
                    userInput.nextLine();
                }
            }
        }

        while (true) {
            try {
                System.out.print("Enter total budget: ");
                budget = userInput.nextInt();

                if (budget <= 0) {
                    System.out.println("Budget must be positive!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter an integer.");
                userInput.nextLine();
            }
        }

        Collections.sort(prices);

        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        findCombinations(0, budget, prices, currentCombination, allCombinations);

        System.out.println("\nValid combinations:");
        System.out.println(allCombinations);

        userInput.close();
    }
}
