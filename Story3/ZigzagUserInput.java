import java.util.*;

/*
author: Aman Jeet Singh
description: Implementation of a program that builds a multi-level doubly linked list based on user input and flattens it in a zigzag manner.
file: ZigzagUserInput.java
*/

class NodeLevel {
    int val;
    NodeLevel prev, next, child;

    NodeLevel(int v) {
        this.val = v;
        prev = next = child = null;
    }
}

public class ZigzagUserInput {

    static Scanner sc = new Scanner(System.in);
    // ZigzagUserInput() {
    //     NodeLevel head = buildList(0, null);
    // }
    static int readInt() {
        while (true) {
            try { return Integer.parseInt(sc.next()); }
            catch (Exception e) { System.out.print("Invalid! Enter again: "); }
        }
    }

    // Build list with detailed level navigation messages
    static NodeLevel buildList(int level, Integer parentVal) {

        if (parentVal == null)
            System.out.println("\n=== ENTERING LEVEL " + level + " (TOP LEVEL) ===");
        else
            System.out.println("\n=== ENTERING LEVEL " + level + " (CHILD OF NODE " + parentVal + ") ===");

        System.out.print("Enter number of nodes in this level: ");
        int n = readInt();
        if (n <= 0) return null;

        NodeLevel head = null, tail = null;

        for (int i = 0; i < n; i++) {

            System.out.println("\n[LEVEL " + level + "] Entering NodeLevel " + (i + 1));

            System.out.print(" Value of node " + (i + 1) + ": ");
            int v = readInt();

            NodeLevel newNode = new NodeLevel(v);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            System.out.print(" Does node " + v + " have a child? (0/1): ");
            int hasChild = readInt();

            if (hasChild == 1) {

                // GOING INTO CHILD
                newNode.child = buildList(level + 1, v);

                // RETURNING BACK
                System.out.println("\n=== Finished child of node " + v + 
                    ". Returning back to LEVEL " + level + " ===");

                if (i + 1 < n)
                    System.out.println("Now continuing LEVEL " + level + 
                        ": next node is position " + (i + 2));
                else
                    System.out.println("End of LEVEL " + level + " nodes.");
            }
        }

        System.out.println("\n=== FINISHED LEVEL " + level + " ===");
        return head;
    }

    // Zigzag flatten based on depth (same logic)
    static void zigzagFlatten(NodeLevel head, int depth, List<Integer> out) {
        if (head == null) return;

        boolean leftToRight = (depth % 2 == 0);

        if (leftToRight) {
            for (NodeLevel cur = head; cur != null; cur = cur.next) {
                out.add(cur.val);
                if (cur.child != null)
                    zigzagFlatten(cur.child, depth + 1, out);
            }
        } else {
            NodeLevel tail = head;
            while (tail.next != null) tail = tail.next;

            for (NodeLevel cur = tail; cur != null; cur = cur.prev) {
                out.add(cur.val);
                if (cur.child != null)
                    zigzagFlatten(cur.child, depth + 1, out);
            }
        }
    }

    public static void main(String[] args) {

        NodeLevel head = buildList(0, null);

        List<Integer> result = new ArrayList<>();
        zigzagFlatten(head, 0, result);

        System.out.println("\nZigzag Flattened Output:");
        for (int x : result) System.out.print(x + "-");
        System.out.println("NULL");
    }
}
