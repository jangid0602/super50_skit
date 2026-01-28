package Assignment_5;

import java.util.*;

public class Horizontal_distance {

    // Stores node along with its horizontal distance and level
    // Needed to correctly group and order nodes in vertical traversal
    static class Pair {
        TreeNode node;
        int hd, level;

        Pair(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public Horizontal_distance() {

        Scanner sc = new Scanner(System.in);

        // Read level order traversal
        System.out.print("Enter input size: ");
        int size = sc.nextInt();

        System.out.println("Enter level order traversal (-1 for null):");
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        // Build binary tree from level order representation
        TreeNode root = buildTree(arr);

        // Compute vertical silhouette of the tree
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
    }

    // Constructs a binary tree from level order traversal
    TreeNode buildTree(Integer[] levelOrder) {

        if (levelOrder.length == 0 || levelOrder[0] == null)
            return null;

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        // BFS-style construction to preserve level order structure
        while (!q.isEmpty() && i < levelOrder.length) {

            TreeNode curr = q.poll();

            // Attach left child
            if (i < levelOrder.length && levelOrder[i] != null) {
                curr.left = new TreeNode(levelOrder[i]);
                q.offer(curr.left);
            }
            i++;

            // Attach right child
            if (i < levelOrder.length && levelOrder[i] != null) {
                curr.right = new TreeNode(levelOrder[i]);
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    // Returns nodes grouped by horizontal distance from left to right
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // hd -> (level -> list of node values)
        // TreeMap ensures ordered traversal from leftmost HD to rightmost
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        // BFS guarantees correct top-to-bottom processing
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            // Insert node value at its corresponding HD and level
            map
                .computeIfAbsent(cur.hd, k -> new TreeMap<>())
                .computeIfAbsent(cur.level, k -> new ArrayList<>())
                .add(cur.node.val);

            // Left child moves one unit left in horizontal distance
            if (cur.node.left != null)
                q.offer(new Pair(cur.node.left, cur.hd - 1, cur.level + 1));

            // Right child moves one unit right in horizontal distance
            if (cur.node.right != null)
                q.offer(new Pair(cur.node.right, cur.hd + 1, cur.level + 1));
        }

        // Extract vertical columns in sorted HD order
        for (TreeMap<Integer, List<Integer>> levels : map.values()) {
            List<Integer> column = new ArrayList<>();

            // Nodes sharing the same HD and level must be sorted by value
            for (List<Integer> nodes : levels.values()) {
                Collections.sort(nodes);
                column.addAll(nodes);
            }
            result.add(column);
        }

        return result;
    }
}
