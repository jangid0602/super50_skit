import java.util.*;

/**
 * @filename - LCA.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

// Node definition
class Node {
    int data;
    Node lc, rc;

    Node(int val) {
        data = val;
        lc = rc = null;
    }
}

class Solution {

    // Create binary tree from array (level order)
    Node create(int[] tree) {
    if (tree.length == 0 || tree[0] == -1) return null;

    Queue<Node> q = new LinkedList<>();
    Node root = new Node(tree[0]);
    q.add(root);

    int i = 1;

    while (!q.isEmpty() && i < tree.length) {
        Node curr = q.poll();

        // Left child
        if (i < tree.length && tree[i] != -1) {
            curr.lc = new Node(tree[i]);
            q.add(curr.lc);
        }
        i++;

        // Right child
        if (i < tree.length && tree[i] != -1) {
            curr.rc = new Node(tree[i]);
            q.add(curr.rc);
        }
        i++;
    }
    return root;
}

    // LCA of two nodes
    Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (root.data == p.data || root.data == q.data)
            return root;

        Node left = lowestCommonAncestor(root.lc, p, q);
        Node right = lowestCommonAncestor(root.rc, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    // LCA of a set of nodes
    Node lcaOfSet(Node root, List<Node> nodes) {
        if (nodes.size() == 0) return null;
        if (nodes.size() == 1) return nodes.get(0);

        Node ans = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            ans = lowestCommonAncestor(root, ans, nodes.get(i));
        }
        return ans;
    }

    // Find node by value
    Node findNode(Node root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;

        Node left = findNode(root.lc, val);
        if (left != null) return left;

        return findNode(root.rc, val);
    }
}

public class LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input tree
        System.out.println("Enter size of tree");
        int n = sc.nextInt();
        int[] tree = new int[n];
        System.out.println("Enter tree if node doesnt exist write -1");
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        Node root = sol.create(tree);

        // Input set size
        System.out.println("Enter size of lca set");
        int m = sc.nextInt();
        List<Node> nodes = new ArrayList<>();
        System.out.println("Enter lca set");
        for (int i = 0; i < m; i++) {
            int val = sc.nextInt();
            Node node = sol.findNode(root, val);
            if (node != null) {
                nodes.add(node);
            }
        }

        Node result = sol.lcaOfSet(root, nodes);

        if (result != null)
            System.out.println(result.data);
        else
            System.out.println("No LCA found");
    }
}
