import java.util.*;

/**
 * @filename - SerialDeserial.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

// Node class
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

// Solution class for serialize & deserialize
class Solution{

    // Serialize tree to string
    public String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                sb.append("null,");
                continue;
            }

            sb.append(curr.data).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Deserialize string to tree
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] values = data.split(",");
        if (values[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node curr = q.poll();

            // Left child
            if (!values[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

public class SerialDeserial{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter tree nodes (level order, use null):");
        String[] input = sc.nextLine().split(" ");

        
        Node root = buildTree(input);

        // Serialize
        String serialized = sol.serialize(root);
        System.out.println("Serialized Tree:");
        System.out.println(serialized);

        // Deserialize
        Node deserializedRoot = sol.deserialize(serialized);

        // Serialize again to verify
        String check = sol.serialize(deserializedRoot);
        System.out.println("After Deserialization (Serialized again):");
        System.out.println(check);
    }

    // Helper to build tree from user input
    static Node buildTree(String[] values) {
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
}
