import java.util.*;

/**
 * @filename - DistantCousins.java
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

    // Build tree from level order with "null"
    Node createTree(String[] values) {
        if (values.length == 0 || values[0].equals("null"))
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node curr = q.poll();

            if (i < values.length && !values[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Find cousins of X
    List<Integer> findCousins(Node root, int x) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || root.data == x) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean found = false;
        Node parentOfX = null;

        while (!q.isEmpty() && !found) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // Check left child
                if (curr.left != null) {
                    if (curr.left.data == x) {
                        found = true;
                        parentOfX = curr;
                    } else {
                        q.add(curr.left);
                    }
                }

                // Check right child
                if (curr.right != null) {
                    if (curr.right.data == x) {
                        found = true;
                        parentOfX = curr;
                    } else {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Remaining nodes in queue are cousins
        if (found) {
            for (Node node : q) {
                if (node != parentOfX.left && node != parentOfX.right) {
                    ans.add(node.data);
                }
            }
        }

        return ans;
    }
}


public class DistantCousins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input
        int n = sc.nextInt();
        sc.nextLine();
        String[] tree = sc.nextLine().split(" ");
        int x = sc.nextInt();

        Node root = sol.createTree(tree);
        List<Integer> cousins = sol.findCousins(root, x);

        System.out.println(cousins);
    }
}
