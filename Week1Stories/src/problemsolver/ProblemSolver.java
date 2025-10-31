package problemsolver;


/**
 * ProblemSolver contains core logic for six independent computational problems.
 * Each method corresponds to a menu option from Main.java.
 * <p>
 * This class is purely static and stateless — no object creation is required.
 * All algorithms are optimized for clarity and efficiency under given constraints.
 * <p>
 * Author: Nasir Ahmed
 * Date: 30 October 2025
 */
public class ProblemSolver {

    /** Sorts the given array using Merge Sort algorithm. */
    private static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int left = low, right = mid + 1, idx = 0;
        int[] temp = new int[high - low + 1];

        while (left <= mid && right <= high)
            temp[idx++] = (nums[left] < nums[right]) ? nums[left++] : nums[right++];

        while (left <= mid) temp[idx++] = nums[left++];
        while (right <= high) temp[idx++] = nums[right++];

        for (int i = 0; i < temp.length; i++)
            nums[low + i] = temp[i];
    }

    /**
     * Problem 1: The Efficient Traveler
     * Finds the farthest city index reachable without running out of energy.
     *
     * @param nums          Array representing energy cost per city
     * @param initialEnergy Starting energy
     * @return Index of the farthest reachable city
     */
    public static int getFarthestCityIndex(int[] nums, int initialEnergy) {
        int energy = initialEnergy;
        for (int i = 0; i < nums.length; i++) {
            if (energy < nums[i]) return i - 1;
            energy -= nums[i];
        }
        return nums.length - 1;
    }

    /**
     * Problem 2: The Sum That Stands Out
     * Finds an index where prefix sum equals suffix sum (excluding that element).
     *
     * @param nums Integer array
     * @return Equilibrium index, or -1 if none exists
     */
    public static int findEquilibriumIndex(int[] nums) {
        long totalSum = 0;
        for (int n : nums) totalSum += n;

        long prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            long rightSum = totalSum - prefixSum - nums[i];
            if (prefixSum == rightSum) return i;
            prefixSum += nums[i];
        }
        return -1;
    }

    /**
     * Problem 3: Flip the Switch
     * Finds the minimum number of flips required to make all binary elements equal.
     *
     * @param nums Binary array (0s and 1s only)
     * @return Minimum number of flips
     */
    public static int minFlipsToMakeEqual(int[] nums) {
        int countZero = 0, countOne = 0;
        for (int n : nums) {
            if (n == 0) countZero++;
            else countOne++;
        }
        return Math.min(countZero, countOne);
    }

    /**
     * Problem 4: The Odd One Out
     * Finds the single unique element in an array where all others appear twice.
     *
     * @param nums Integer array
     * @return The distinct (odd one out) element
     */
    public static int findUniqueElement(int[] nums) {
        sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2)
            if (nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }

    /**
     * Problem 5: Smart Pair Finder
     * Checks if there exists a pair (i, j) such that nums[i] + nums[j] == target.
     *
     * @param nums   Integer array
     * @param target Target sum value
     * @return True if such a pair exists, otherwise false
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    /**
     * Problem 6: The Minimalist Painter
     * Finds the minimum total painting time after skipping one wall.
     *
     * @param time Array representing time to paint each wall
     * @return Minimum total time after skipping the most time-consuming wall
     */
    public static int minPaintTimeAfterSkip(int[] time) {
        int total = 0, max = 0;
        for (int t : time) {
            total += t;
            if (t > max) max = t;
        }
        return total - max;
    }
}
