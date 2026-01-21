import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
        left = right = null;
    }
}

public class TreeImplementation {

    // ---------- 1. Palindromic Path ----------
    public int palindromicPaths(TreeNode root) {
        return dfsPal(root, 0);
    }

    private int dfsPal(TreeNode node, int mask) {
        if (node == null) return 0;

        mask ^= (1 << node.val);

        if (node.left == null && node.right == null) {
            if ((mask & (mask - 1)) == 0) return 1;
            return 0;
        }

        return dfsPal(node.left, mask) + dfsPal(node.right, mask);
    }

    // ---------- 2. Vertical Order ----------
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0});

        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            TreeNode node = (TreeNode) cur[0];
            int hd = (int) cur[1];

            if (node == null) continue;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.val);

            q.add(new Object[]{node.left, hd - 1});
            q.add(new Object[]{node.right, hd + 1});
        }

        return new ArrayList<>(map.values());
    }

    // ---------- 3. Cousins ----------
    public List<Integer> cousins(TreeNode root, int x) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if ((node.left != null && node.left.val == x) ||
                    (node.right != null && node.right.val == x)) {
                    found = true;
                } else {
                    if (node.left != null) {
                        q.add(node.left);
                        level.add(node.left.val);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                        level.add(node.right.val);
                    }
                }
            }

            if (found) return level;
        }

        return new ArrayList<>();
    }

    // ---------- 4. Min Camera ----------
    int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        if (dfs(root) == 0) cameras++;
        return cameras;
    }

    int dfs(TreeNode node) {
        if (node == null) return 2;

        int l = dfs(node.left);
        int r = dfs(node.right);

        if (l == 0 || r == 0) {
            cameras++;
            return 1;
        }
        if (l == 1 || r == 1) return 2;

        return 0;
    }

    // ---------- 5. Serialize ----------
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    int idx;
    public TreeNode deserialize(String s) {
        idx = 0;
        String[] arr = s.split(",");
        return build(arr);
    }

    TreeNode build(String[] arr) {
        if (arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = build(arr);
        node.right = build(arr);
        return node;
    }

    // ---------- 6. K Sum Path ----------
    int maxLen;

    public int kSumPath(TreeNode root, int k) {
        maxLen = 0;
        path(root, k, new ArrayList<>());
        return maxLen;
    }

    void path(TreeNode node, int k, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);

        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == k)
                maxLen = Math.max(maxLen, list.size() - i);
        }

        path(node.left, k, list);
        path(node.right, k, list);

        list.remove(list.size() - 1);
    }

    // ---------- 7. Boundary ----------
    public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);
        left(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        right(root.right, res);

        return res;
    }

    void left(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null)) return;
        res.add(node.val);
        if (node.left != null) left(node.left, res);
        else left(node.right, res);
    }

    void right(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right != null) right(node.right, res);
        else right(node.left, res);
        res.add(node.val);
    }

    void leaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        leaves(node.left, res);
        leaves(node.right, res);
    }

    // ---------- 8. LCA of Set ----------
    public TreeNode lcaSet(TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        if (set.contains(root.val)) return root;

        TreeNode l = lcaSet(root.left, set);
        TreeNode r = lcaSet(root.right, set);

        if (l != null && r != null) return root;
        return l != null ? l : r;
    }
}

