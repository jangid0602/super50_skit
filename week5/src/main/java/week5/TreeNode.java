/**
 * A generic TreeNode class for binary tree operations used across Week 5
 * problems.
 * Supports both integer values and character values for different problem
 * types.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */

public class TreeNode {
    public int val;
    public char charVal;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.charVal = '\0';
        this.left = null;
        this.right = null;
    }

    public TreeNode(char charVal) {
        this.charVal = charVal;
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.charVal = '\0';
        this.left = left;
        this.right = right;
    }

    public TreeNode(char charVal, TreeNode left, TreeNode right) {
        this.charVal = charVal;
        this.val = 0;
        this.left = left;
        this.right = right;
    }
}
