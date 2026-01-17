package Assignment_5;

import java.util.*;

public class Tree_Path_K_Sum {

    int K;
    int maxLen = 0;

    // Stores prefixSum -> earliest level where it appeared
    Map<Integer, Integer> prefixMap = new HashMap<>();

    public Tree_Path_K_Sum() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        System.out.print("Enter K value: ");
        K = sc.nextInt();

        TreeNode root = buildTree(arr);

        // Base case: prefix sum 0 occurs before starting (level 0)
        prefixMap.put(0, 0);

        dfs(root, 0, 1);

        System.out.println("Longest path length with sum " + K + ": " + maxLen);
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

    // DFS with prefix sum tracking
    void dfs(TreeNode node, int currSum, int level) {

        if (node == null)
            return;

        currSum += node.val;

        // If (currSum - K) exists, we found a valid path
        if (prefixMap.containsKey(currSum - K)) {
            int prevLevel = prefixMap.get(currSum - K);
            maxLen = Math.max(maxLen, level - prevLevel);
        }

        // Store earliest occurrence of this prefix sum
        prefixMap.putIfAbsent(currSum, level);

        dfs(node.left, currSum, level + 1);
        dfs(node.right, currSum, level + 1);

        // Backtrack: remove prefix sum if it was added at this level
        if (prefixMap.get(currSum) == level)
            prefixMap.remove(currSum);
    }
}