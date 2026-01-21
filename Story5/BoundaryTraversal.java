
/**
 * Filename - BoundaryTraversal.java
 * Description -  Print the boundary nodes of a binary tree in anti-clockwise 
order: Left boundary (excluding leaves), all leaves (left to right), and Right 
boundary (bottom to top, excluding leaves). 
 * Author - Nancy Jain
 * Date - 16/01/2026
 */

import java.util.*;

public class BoundaryTraversal {

    public static List<Character> boundaryTraversal(TreeNodeChar root) {

        List<Character> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.data);
        addLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result);

        return result;
    }

    // Left boundary excluding leaf nodes
    private static void addLeftBoundary(TreeNodeChar node, List<Character> result) {
        if (node == null) return;

        if (node.left != null) {
            result.add(node.data);
            addLeftBoundary(node.left, result);
        } else if (node.right != null) {
            result.add(node.data);
            addLeftBoundary(node.right, result);
        }
    }

    // Right boundary excluding leaf nodes (added in reverse)
    private static void addRightBoundary(TreeNodeChar node, List<Character> result) {
        if (node == null) return;

        if (node.right != null) {
            addRightBoundary(node.right, result);
            result.add(node.data);
        } else if (node.left != null) {
            addRightBoundary(node.left, result);
            result.add(node.data);
        }
    }

    // Add leaf nodes
    private static void addLeaves(TreeNodeChar right, List<Character> result) {
        if (right == null) return;

        if (right.left == null && right.right == null) {
            result.add((char) right.data);
            return;
        }

        addLeaves(right.left, result);
        addLeaves(right.right, result);
    }
}
