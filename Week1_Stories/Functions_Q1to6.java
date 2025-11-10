/**
 * @Filename - Functions_Q1to6.java
 * @Description - Contains logic implementations for Questions 1 to 6.
 * @Author - Rishu Sharma
 * @Date - 31-October-2025
 * @Subject - Week 1 Stories
 */

import java.util.*;

public class Functions_Q1to6 {

    /**
     * Q1 - The Efficient Traveler
     * Finds the farthest city index reachable without running out of energy.
     */
    public static int farthestCity(int[] nums, int initialEnergy) {
        int energy = initialEnergy;
        for (int i = 0; i < nums.length; i++) {
            energy -= nums[i];
            if (energy < 0) return i;
        }
        return nums.length - 1;
    }

    /**
     * Q2 - The Sum That Stands Out
     * Finds the equilibrium index where prefix and suffix sums are equal.
     */
    public static int equilibriumIndex(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == total - prefix - nums[i])
                return i;
            prefix += nums[i];
        }
        return -1;
    }

    /**
     * Q3 - Flip the Switch
     * Finds the minimum number of flips required to make all elements equal.
     */
    public static int minFlipsToEqual(int[] nums) {
        int zeros = 0, ones = 0;
        for (int num : nums) {
            if (num == 0) zeros++;
            else ones++;
        }
        return Math.min(zeros, ones);
    }

    /**
     * Q4 - The Odd One Out
     * Returns the element which appears only once (using XOR logic).
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num; // XOR cancels duplicates
        return result;
    }

    /**
     * Q5 - Smart Pair Finder
     * Checks if any two numbers form a given target sum.
     */
    public static boolean hasPairWithSum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(k - num)) return true;
            set.add(num);
        }
        return false;
    }

    /**
     * Q6 - The Minimalist Painter
     * Calculates minimal total paint time after skipping one wall.
     */
    public static int minimalPaintTime(int[] time) {
        if (time.length == 0) return 0;
        int sum = 0, max = 0;
        for (int t : time) {
            sum += t;
            max = Math.max(max, t);
        }
        return sum - max;
    }
}
