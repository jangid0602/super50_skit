import java.util.*;


/**
 * @Filename-BoundaryTraversal.java
 * @Description- This is to print boundary nodes of a binary tree in anti-clockwise
order
 * @Author-Arman Agrawal
 */



public class BoundaryTraversal {

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void leftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.val);
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    static void leafNodes(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        leafNodes(root.left, res);
        leafNodes(root.right, res);
    }

    static void rightBoundary(TreeNode root, List<Integer> res) {
        Stack<Integer> st = new Stack<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) st.push(curr.val);
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        while (!st.isEmpty()) res.add(st.pop());
    }

    static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);
        leftBoundary(root, res);
        leafNodes(root, res);
        rightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = TreeBuilder.buildTree(sc);
        System.out.println(boundaryTraversal(root));
        sc.close();
    }
}
