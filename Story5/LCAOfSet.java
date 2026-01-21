import java.util.*;


/**
 * @Filename-LCAOfSet.java
 * @Description- This is To find LCA of a set of nodes
 * @Author-Arman Agrawal
 */



public class LCAOfSet {

    static TreeNode lca(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;

        TreeNode l = lca(root.left, a, b);
        TreeNode r = lca(root.right, a, b);

        if (l != null && r != null) return root;
        return l != null ? l : r;
    }

    static TreeNode lcaOfSet(TreeNode root, int[] nodes) {
        TreeNode ans = root;
        for (int i = 0; i < nodes.length; i++) {
            ans = lca(root, ans.val, nodes[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = TreeBuilder.buildTree(sc);

        System.out.print("Enter number of nodes: ");
        int m = InputUtil.readInt(sc);

        int[] nodes = new int[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = InputUtil.readInt(sc);
        }

        System.out.println("LCA = " + lcaOfSet(root, nodes).val);
        sc.close();
    }
}
