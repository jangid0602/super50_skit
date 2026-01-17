
/**
 * Filename - DistantCousins.java
 * Description - Two nodes are "Cousins" if they have the same depth but 
different parents. Given a value X, find all the cousins of the node with value X in 
the tree. 
 * Author - Nancy Jain
 * Date - 15/01/2026
 */

import java.util.*;

public class DistantCousins {

    public static List<Integer> findCousins(TreeNode root, int x) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean foundParent = false;
            List<Integer> cousins = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // If current node is parent of X
                if ((current.left != null && current.left.data == x) ||
                    (current.right != null && current.right.data == x)) {
                    foundParent = true;
                } 
                else {
                    if (current.left != null) {
                        cousins.add(current.left.data);
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        cousins.add(current.right.data);
                        queue.add(current.right);
                    }
                }
            }

            // Once parent is found, current level cousins are answer
            if (foundParent) {
                return cousins;
            }
        }

        return new ArrayList<>();
    }
}
