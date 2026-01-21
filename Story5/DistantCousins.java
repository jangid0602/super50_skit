import java.util.*;

/**
 * @Filename-DistantCousins.java
 * @Description- This is to find distinct cousins of node X
 * @Author-Arman Agrawal
 */



public class DistantCousins {

    static List<Integer> findCousins(TreeNode root, int X) {
        List<Integer> result = new ArrayList<>();
        if (root == null || root.val == X) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if ((curr.left != null && curr.left.val == X) ||
                    (curr.right != null && curr.right.val == X)) {
                    found = true;
                } else {
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }

            if (found) {
                while (!q.isEmpty()) {
                    result.add(q.poll().val);
                }
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = TreeBuilder.buildTree(sc);

        System.out.print("Enter value X: ");
        int X = sc.nextInt();

        List<Integer> cousins = findCousins(root, X);

        System.out.println("Cousins of " + X + " are:");
        System.out.println(cousins);

        sc.close();
    }
}
