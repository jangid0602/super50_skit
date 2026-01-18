import java.util.*;

/**
 * @filename - Calculator.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    void comb(int[] candidates, int target, List<Integer> op, int i) {
        // base case
        if (target == 0) {
            result.add(new ArrayList<>(op));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        op.add(candidates[i]);
        comb(candidates, target - candidates[i], op, i + 1);
        op.remove(op.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        comb(candidates, target, op, i + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort like C++
        comb(candidates, target, new ArrayList<>(), 0);
        return result;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];

        // input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        // input target
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum2(candidates, target);

        // output
        System.out.println("Combinations:");
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
