
package Story3;

class CollapsingCountList {

    // Node class with value, count, and next pointer
    static class Node {
        int value;
        int count;
        Node next;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
            this.next = null;
        }
    }

    // Collapse consecutive nodes with same value by summing their counts
    static Node collapse(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                // Merge next node into current
                curr.count += curr.next.count;
                curr.next = curr.next.next; // remove next node
                // Don't move curr forward, check new curr.next
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    // Print the linked list in (value, count) format
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("(" + curr.value + ", " + curr.count + ")");
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
