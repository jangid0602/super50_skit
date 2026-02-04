import java.util.*;

/**
 * @Filename-KSumPath.java
 * @Description- Finds the longest path in a binary tree where the sum of node values
 *               equals a given target K. Uses prefix sum technique with hash map to
 *               efficiently track cumulative sums and find valid subpaths.
 * @Author-Aman Jeet Singh
 */



public class KSumPath {

    static int maximumPathLength = 0;

    /**
     * Recursive helper function to find longest path with sum K
     * Uses prefix sum technique with hash map for O(1) lookups
     * @param currentNode Current node being processed
     * @param targetSum Target sum value K
     * @param currentPrefixSum Cumulative sum from root to current node
     * @param currentLevel Depth level of current node (1-indexed)
     * @param prefixSumMap Map storing prefix sum -> level mapping
     */
    static void findLongestPathWithSum(TreeNode currentNode, int targetSum, int currentPrefixSum,
                      int currentLevel, Map<Integer, Integer> prefixSumMap) {

        if (currentNode == null) return;

        currentPrefixSum += currentNode.val;

        prefixSumMap.putIfAbsent(currentPrefixSum, currentLevel);

        if (prefixSumMap.containsKey(currentPrefixSum - targetSum)) {
            int pathLength = currentLevel - prefixSumMap.get(currentPrefixSum - targetSum);
            maximumPathLength = Math.max(maximumPathLength, pathLength);
        }

        findLongestPathWithSum(currentNode.left, targetSum, currentPrefixSum, currentLevel + 1, prefixSumMap);
        findLongestPathWithSum(currentNode.right, targetSum, currentPrefixSum, currentLevel + 1, prefixSumMap);

        // Backtrack: remove current prefix sum if it was added at current level
        if (prefixSumMap.get(currentPrefixSum) == currentLevel) {
            prefixSumMap.remove(currentPrefixSum);
        }
    }

    /**
     * Finds the longest path in binary tree where sum equals K
     * @param rootNode Root of the binary tree
     * @param targetSum Target sum value K
     * @return Length of longest path with sum K
     */
    static int longestKSumPath(TreeNode rootNode, int targetSum) {
        maximumPathLength = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 0); // Base case: prefix sum 0 at level 0
        findLongestPathWithSum(rootNode, targetSum, 0, 1, prefixSumMap);
        return maximumPathLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeNode rootNode = TreeBuilder.buildTree(scanner);

        System.out.print("Enter K: ");
        int targetSum = InputUtil.readInt(scanner);

        System.out.println("Longest path length = " + longestKSumPath(rootNode, targetSum));
        scanner.close();
    }
}
