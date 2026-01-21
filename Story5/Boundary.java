import java.util.*;

/**
 * @filename - Boundary.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

// Node definition
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    // Left boundary
    void leftTree(Node root, List<Integer> ans) {
        if (root == null) return;

        if (root.left != null || root.right != null)
            ans.add(root.data);

        if (root.left != null)
            leftTree(root.left, ans);
        else
            leftTree(root.right, ans);
    }

    // Right boundary
    void rightTree(Node root, List<Integer> temp) {
        if (root == null) return;

        if (root.left != null || root.right != null)
            temp.add(root.data);

        if (root.right != null)
            rightTree(root.right, temp);
        else
            rightTree(root.left, temp);
    }

    // Leaf nodes
    void addNodes(Node root, List<Integer> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }
        addNodes(root.left, ans);
        addNodes(root.right, ans);
    }

    // Boundary traversal
    List<Integer> boundaryTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ans.add(root.data); // root

        leftTree(root.left, ans);
        addNodes(root.left, ans);
        addNodes(root.right, ans);

        List<Integer> temp = new ArrayList<>();
        rightTree(root.right, temp);
        for (int i = temp.size() - 1; i >= 0; i--)
            ans.add(temp.get(i));

        return ans;
    }

    // Tree creation from user input
    Node createTree(String[] values) {
        if (values.length == 0 || values[0].equals("null"))
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node curr = q.poll();

            // left child
            if (i < values.length && !values[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            // right child
            if (i < values.length && !values[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

public class Boundary{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter tree nodes (use null for no node):");
        String[] values = sc.nextLine().split(" ");

        Node root = sol.createTree(values);

        List<Integer> result = sol.boundaryTraversal(root);
        System.out.println("Boundary Traversal:");
        System.out.println(result);
    }
}
