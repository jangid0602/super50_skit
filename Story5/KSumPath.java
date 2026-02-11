
/**
 * Filename - KSumPath.java
 * Description - Given a tree where each node has an integer value, find 
the length of the longest downward path whose sum is exactly K.  
 * Author - Nancy Jain
 * Date - 16/01/2026
 */

public class KSumPath {

    int maxLength = 0;

    public int longestKSumPath(TreeNode root, int K) {
        findPath(root, K, 0, 0);
        return maxLength;
    }

    private void findPath(TreeNode node, int K, int currentSum, int length) {

        if (node == null) {
            return;
        }

        currentSum += node.data;
        length++;

        if (currentSum == K) {
            maxLength = Math.max(maxLength, length);
        }

        // Continue downward
        findPath(node.left, K, currentSum, length);
        findPath(node.right, K, currentSum, length);
    }
}
