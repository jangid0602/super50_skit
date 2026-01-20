import java.util.LinkedList;
import java.util.Queue;

/**
 * Utility class for building binary trees from level-order arrays.
 * Used for creating test trees across Week 5 problems.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */

public class TreeUtils {

    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();

            if (i < levelOrder.length && levelOrder[i] != null) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != null) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode buildCharTree(Character[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();

            if (i < levelOrder.length && levelOrder[i] != null) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != null) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("null, ");
            } else {
                sb.append(current.val).append(", ");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        String result = sb.toString().replaceAll(", $", "");
        result = result.replaceAll("(, null)+$", "");
        System.out.println(result + "]");
    }
}
