package Assignment_5;

import java.util.*;

public class LCA_Of_Set {

    Set<Integer> targetSet = new HashSet<>();
    TreeNode answer = null;
    int M;

    public LCA_Of_Set() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        TreeNode root = buildTree(arr);

        System.out.print("Enter size of set M: ");
        M = sc.nextInt();

        System.out.println("Enter the M node values:");
        for (int i = 0; i < M; i++) {
            targetSet.add(sc.nextInt());
        }

        // Edge case: single node set
        if (M == 1) {
            System.out.println("LCA: " + targetSet.iterator().next());
            return;
        }

        dfs(root);

        System.out.println("LCA of given set: " + (answer != null ? answer.val : "Not Found"));
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

    // DFS returns how many target nodes are found in subtree
    int dfs(TreeNode node) {

        if (node == null)
            return 0;

        int leftCount = dfs(node.left);
        int rightCount = dfs(node.right);

        int self = targetSet.contains(node.val) ? 1 : 0;

        int total = leftCount + rightCount + self;

        // First node where all M nodes are found is the LCA
        if (total == M && answer == null) {
            answer = node;
        }

        return total;
    }
}