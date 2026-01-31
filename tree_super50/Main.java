import java.util.*;

public class Main {

    // Build Tree (Level Order)
    public static TreeNode buildTree(Scanner sc) {
        System.out.print("Enter root (-1 for null): ");
        int val = sc.nextInt();
        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            System.out.print("Left of " + curr.val + ": ");
            int left = sc.nextInt();
            if (left != -1) {
                curr.left = new TreeNode(left);
                q.add(curr.left);
            }

            System.out.print("Right of " + curr.val + ": ");
            int right = sc.nextInt();
            if (right != -1) {
                curr.right = new TreeNode(right);
                q.add(curr.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeImplementation impl = new TreeImplementation();

        while (true) {
            System.out.println("\n1 Palindromic Path");
            System.out.println("2 Vertical Traversal");
            System.out.println("3 Cousins");
            System.out.println("4 Min Camera");
            System.out.println("5 Serialize");
            System.out.println("6 K Sum Path");
            System.out.println("7 Boundary");
            System.out.println("8 LCA Set");
            System.out.println("0 Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;

            TreeNode root = buildTree(sc);

            if (ch == 1) {
                System.out.println(impl.palindromicPaths(root));
            } 
            else if (ch == 2) {
                System.out.println(impl.verticalTraversal(root));
            } 
            else if (ch == 3) {
                System.out.print("Enter X: ");
                int x = sc.nextInt();
                System.out.println(impl.cousins(root, x));
            } 
            else if (ch == 4) {
                System.out.println(impl.minCameraCover(root));
            } 
            else if (ch == 5) {
                String s = impl.serialize(root);
                System.out.println("Serialized: " + s);
                System.out.println("Again: " + impl.serialize(impl.deserialize(s)));
            } 
            else if (ch == 6) {
                System.out.print("Enter K: ");
                int k = sc.nextInt();
                System.out.println(impl.kSumPath(root, k));
            } 
            else if (ch == 7) {
                System.out.println(impl.boundary(root));
            } 
            else if (ch == 8) {
                System.out.print("Set size: ");
                int n = sc.nextInt();
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(sc.nextInt());
                }
                TreeNode ans = impl.lcaSet(root, set);
                System.out.println(ans != null ? ans.val : -1);
            } 
            else {
                System.out.println("Wrong choice");
            }
        }
    }
}
