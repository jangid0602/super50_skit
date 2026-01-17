package Assignment_5;

import java.util.*;

public class Boundary_Traversal {


    List<Integer> result = new ArrayList<>();

    public Boundary_Traversal() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Handle empty tree
        if (n == 0) {
            System.out.println("[]");
            return;
        }

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        TreeNode root = buildTree(arr);

        boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + result);
    }

    // Build tree from level order traversal
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

    // Main boundary traversal controller
    void boundaryTraversal(TreeNode root) {

        if (root == null)
            return;

        // Root is always part of boundary
        result.add(root.val);

        // Left boundary (excluding leaves)
        traverseLeft(root.left);

        // All leaf nodes
        traverseLeaves(root.left);
        traverseLeaves(root.right);

        // Right boundary (excluding leaves, bottom-up)
        traverseRight(root.right);
    }

    // Traverse left boundary excluding leaf nodes
    void traverseLeft(TreeNode node) {

        if (node == null)
            return;

        if (node.left != null) {
            result.add(node.val);
            traverseLeft(node.left);
        }
        else if (node.right != null) {
            result.add(node.val);
            traverseLeft(node.right);
        }
    }

    // Traverse leaf nodes in left-to-right order
    void traverseLeaves(TreeNode node) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        traverseLeaves(node.left);
        traverseLeaves(node.right);
    }

    // Traverse right boundary excluding leaf nodes (bottom-up)
    void traverseRight(TreeNode node) {

        if (node == null)
            return;

        if (node.right != null) {
            traverseRight(node.right);
            result.add(node.val);
        }
        else if (node.left != null) {
            traverseRight(node.left);
            result.add(node.val);
        }
    }
}