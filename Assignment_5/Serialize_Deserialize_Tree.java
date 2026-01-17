package Assignment_5;

import java.util.*;

public class Serialize_Deserialize_Tree {

    public Serialize_Deserialize_Tree() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Handle empty tree case
        if (n == 0) {
            System.out.println("Serialized: null");
            System.out.println("Deserialized tree is null");
            return;
        }

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        TreeNode root = buildTree(arr);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode newRoot = deserialize(serialized);
        System.out.println("Tree deserialized successfully");
    }

    // Build tree from level order input
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

    // Serialize tree into string using BFS
    String serialize(TreeNode root) {

        if (root == null)
            return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append("null,");
                continue;
            }

            sb.append(curr.val).append(",");
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Deserialize string back to binary tree
    TreeNode deserialize(String data) {

        if (data.equals("null"))
            return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < values.length) {
            TreeNode curr = q.poll();

            if (!values[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.left);
            }
            i++;

            if (!values[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}