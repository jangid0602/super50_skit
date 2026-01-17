
/**
 * Filename - LCASet.java
 * Description - Given a set of M nodes in a tree of N nodes, find the lowest 
common ancestor that is a common ancestor to all M nodes. 
 * Author - Nancy Jain
 * Date - 16/01/2026
 */

import java.util.Set;

public class LCASet {

    public static TreeNode findLCA(TreeNode root, Set<Integer> set) {

        if (root == null) {
            return null;
        }

        // If current node is in the set
        if (set.contains(root.data)) {
            return root;
        }

        TreeNode left = findLCA(root.left, set);
        TreeNode right = findLCA(root.right, set);

        // If nodes are found in both subtrees
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return non-null child
        return (left != null) ? left : right;
    }
}
