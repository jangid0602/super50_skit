import java.util.*;

public class ZigzagMultilevelFlatten {

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int v) { val = v; }
    }

    public static Node flattenZigzag(Node head) {
        if (head == null) return null;

        List<Node> order = new ArrayList<>();
        zigzagDFS(head, order, 0);

        // Rebuild doubly linked list
        if (order.isEmpty()) return null;
        
        // Set prev of first node to null
        order.get(0).prev = null;
        
        for (int i = 0; i < order.size() - 1; i++) {
            order.get(i).next = order.get(i + 1);
            order.get(i + 1).prev = order.get(i);
            order.get(i).child = null;
        }
        
        // Set next of last node to null and clear its child
        if (order.size() > 0) {
            order.get(order.size() - 1).next = null;
            order.get(order.size() - 1).child = null;
        }

        return order.get(0);
    }

    private static void zigzagDFS(Node head, List<Node> out, int level) {

        List<Node> sameLevel = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            sameLevel.add(temp);
            temp = temp.next;
        }

        if (level % 2 == 1)
            Collections.reverse(sameLevel);

        for (Node node : sameLevel) {
            out.add(node);
            if (node.child != null)
                zigzagDFS(node.child, out, level + 1);
        }
    }
}
