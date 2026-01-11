import java.util.*;

/**
 * @filename - PowerSet.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */


class Solution {

    List<List<String>> result = new ArrayList<>();

    void subset(String[] nums, List<String> op, int i) {

        if (i == nums.length) {
            result.add(new ArrayList<>(op));
            return;
        }

        op.add(nums[i]);
        subset(nums, op, i + 1);

        // backtrack
        op.remove(op.size() - 1);

        // exclude current element
        subset(nums, op, i + 1);
    }

    List<List<String>> subsets(String[] nums) {
        subset(nums, new ArrayList<>(), 0);
        return result;
    }
}

public class PowerSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] nums = new String[n];

        // input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLine();
        }

        Solution sol = new Solution();
        List<List<String>> ans = sol.subsets(nums);

        // output
        System.out.println("Subsets:");
        System.out.println(ans);
    }
}
