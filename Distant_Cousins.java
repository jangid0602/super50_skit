package Assignment_5;

import java.util.*;

public class Distant_Cousins {

    public Distant_Cousins() {

        Scanner sc = new Scanner(System.in);

        // Input tree
        System.out.print("Enter size of input : ");
        int n = sc.nextInt();

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        System.out.print("Enter value X: ");
        int X = sc.nextInt();

        TreeNode root = buildTree(arr);

        List<Integer> cousins = findCousins(root, X);
        System.out.println("Cousins of " + X + ": " + cousins);
    }

    // Builds tree from level order traversal
    TreeNode buildTree(Integer[] levelOrder) {

        if (levelOrder.length == 0 || levelOrder[0] == null)
            return null;

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < levelOrder.length) {
            TreeNode curr = q.poll();

            if (i < levelOrder.length && levelOrder[i] != null) {
                curr.left = new TreeNode(levelOrder[i]);
                q.offer(curr.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != null) {
                curr.right = new TreeNode(levelOrder[i]);
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    // Finds cousins of node with value X
    List<Integer> findCousins(TreeNode root, int X) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean found = false;
        TreeNode parentOfX = null;

        // Level order traversal
        while (!q.isEmpty() && !found) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Check children to locate X and its parent
                if (curr.left != null) {
                    if (curr.left.val == X) {
                        found = true;
                        parentOfX = curr;
                    } else {
                        q.offer(curr.left);
                    }
                }

                if (curr.right != null) {
                    if (curr.right.val == X) {
                        found = true;
                        parentOfX = curr;
                    } else {
                        q.offer(curr.right);
                    }
                }
            }
        }

        // Remaining nodes in queue at this level are cousins
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}