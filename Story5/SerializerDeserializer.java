
/**
 * Filename - SerializerDeserializer.java
 * Description - Design an algorithm to serialize a binary tree into a string 
and deserialize that string back into the original tree structure.  
 * Author - Nancy Jain
 * Date - 14/01/2026
 */

import java.util.LinkedList;
import java.util.Queue;

public class SerializerDeserializer {

    // Serialize tree to string (Level Order)
    public static String serialize(TreeNodeChar root) {

        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNodeChar> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNodeChar current = queue.poll();

            if (current == null) {
                sb.append("null ");
            } else {
                sb.append(current.data + " ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return sb.toString().trim();
    }

    // Deserialize string back to tree
    public static TreeNodeChar deserialize(String data) {

        if (data.equals("null") || data.length() == 0) {
            return null;
        }

        String[] values = data.split(" ");
        TreeNodeChar root = new TreeNodeChar((char) Integer.parseInt(values[0]));

        Queue<TreeNodeChar> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNodeChar current = queue.poll();

            // Left child
            if (!values[i].equals("null")) {
                current.left = new TreeNodeChar((char) Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNodeChar((char) Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}