import java.util.List;
import java.util.ArrayList;

/**
 * @Filename- BudgetCalculator.java
 * @Description- This is our budget calculator code in which we have use combinations sum to find combinations that are equal to our budget 
 * @Author- Arman Agrawal
 */



public class BudgetCalculator {

    public static void findCombinations(
            int[] prices,
            int remainingBudget,
            int index,
            List<Integer> currentCombination,
            List<List<Integer>> allCombinations) {

        if (remainingBudget == 0) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingBudget < 0 || index >= prices.length) {
            return;
        }

        currentCombination.add(prices[index]);
        findCombinations(
                prices,
                remainingBudget - prices[index],
                index,
                currentCombination,
                allCombinations
        );
        currentCombination.remove(currentCombination.size() - 1);

        findCombinations(
                prices,
                remainingBudget,
                index + 1,
                currentCombination,
                allCombinations
        );
    }
}
