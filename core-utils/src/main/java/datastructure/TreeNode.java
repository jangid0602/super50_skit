package datastructure;

public class TreeNode implements Node {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inorderTraversal(this, sb);
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private void inorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null, ");
            return;
        }
        inorderTraversal(node.left, sb);
        sb.append(node.val).append(", ");
        inorderTraversal(node.right, sb);
    }
}
