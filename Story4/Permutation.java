import java.util.*;

/**
 * @filename - Permutations.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void solve(int[] nums, List<Integer> ans, boolean[] check) {
        // Base case
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                ans.add(nums[i]);
                check[i] = true;

                solve(nums, ans, check);

                // backtrack
                ans.remove(ans.size() - 1);
                check[i] = false;
            }
        }
    }

    List<List<Integer>> permute(int[] nums) {
        boolean[] check = new boolean[nums.length];
        solve(nums, new ArrayList<>(), check);
        return result;
    }
}

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> permutations = sol.permute(nums);

        for (List<Integer> p : permutations) {
            System.out.println(p);
        }
    }
}
