package Assignment_5;

import java.util.*;

public class Minimum_Camera_Coverage {

    int cameras = 0;

    public Minimum_Camera_Coverage() {

        Scanner sc = new Scanner(System.in);

        // Input tree
        System.out.print("Enter size of input array : ");
        int n = sc.nextInt();

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        TreeNode root = buildTree(arr);

        // If root is not covered, place one final camera
        if (dfs(root) == 0)
            cameras++;

        System.out.println("Minimum cameras required: " + cameras);
    }

    // Builds binary tree from level order traversal
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

    // Postorder DFS that returns node state
    int dfs(TreeNode node) {

        if (node == null)
            return 2; // null nodes are treated as covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If any child is not covered, place camera here
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // If any child has a camera, this node is covered
        if (left == 1 || right == 1)
            return 2;

        // Node is not covered
        return 0;
    }
}