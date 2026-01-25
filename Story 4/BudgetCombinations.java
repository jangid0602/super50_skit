/**
 * <p>This class solves  The Budget Calculator problem using recursion and backtracking </p>
 *
 * @Author- Aaditya Jain
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetCombinations {

    static void findCombinations(int[] prices, int budget, int start,
                                 List<Integer> current,
                                 List<List<Integer>> result) {


        if (budget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (budget < 0)
            return;

        for (int i = start; i < prices.length; i++) {
            current.add(prices[i]);
            findCombinations(prices, budget - prices[i], i, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scannerobj = new Scanner(System.in);


        System.out.print("Enter number of items: ");
        int inputsize = scannerobj.nextInt();

        int[] prices = new int[inputsize];


        System.out.println("Enter item prices:");
        for (int index = 0; index < inputsize; index++) {
            prices[index] = scannerobj.nextInt();
        }


        System.out.print("Enter total budget: ");
        int budget = scannerobj.nextInt();

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(prices, budget, 0, new ArrayList<>(), result);

        System.out.println("Possible combinations:");
        System.out.println(result);

        scannerobj.close();
    }
}
