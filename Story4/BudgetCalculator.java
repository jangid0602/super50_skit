/**

 * Description- You have a set of items with different prices. You want to find all
 combinations of items that sum up exactly to your total budget $B$. You
 can use each item multiple times.
 * Author - Mayank Rathore
 */
import java.util.ArrayList;
import java.util.List;


public class BudgetCalculator {

    static List<List<Integer>> result = new ArrayList<>();

    static void findCombinations(int[] prices, int budget, int index, List<Integer> current) {


        if (budget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (budget < 0) return;

        for (int i = index; i < prices.length; i++) {
            current.add(prices[i]);
            findCombinations(prices, budget - prices[i], i, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Input input=new Input();

        System.out.print("Enter number of items: ");
        int n = input.inputInteger();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price " + (i + 1) + ": ");
            prices[i] = input.inputInteger();
        }

        System.out.print("Enter total budget: ");
        int budget = input.inputInteger();

        findCombinations(prices, budget, 0, new ArrayList<>());

        System.out.println("\nPossible combinations:");
        System.out.println(result);


    }
}

