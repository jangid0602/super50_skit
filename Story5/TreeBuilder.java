import java.util.*;



/**
 * @Filename-TreeBuilder.java
 * @Description- This is To take treeNode as input
 * @Author-Arman Agrawal
 */



class TreeBuilder {

    public static TreeNode buildTree(Scanner sc) {
        System.out.print("Enter root value (or null): ");
        String rootInput = InputUtil.readNode(sc);

        if (rootInput.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(rootInput));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            System.out.print("Enter left child of " + curr.val + " (or null): ");
            String leftInput = InputUtil.readNode(sc);
            if (!leftInput.equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(leftInput));
                q.add(curr.left);
            }

            System.out.print("Enter right child of " + curr.val + " (or null): ");
            String rightInput = InputUtil.readNode(sc);
            if (!rightInput.equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(rightInput));
                q.add(curr.right);
            }
        }
        return root;
    }
}
