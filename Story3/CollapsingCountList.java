public class CollapsingCountList {

    static class Node {
        String value;
        int count;
        Node next;

        Node(String v, int c) {
            value = v;
            count = c;
        }
    }

    public static Node collapse(Node head) {
        Node current = head;

        while (current != null && current.next != null) {

            if (current.value.equals(current.next.value)) {
                current.count += current.next.count;
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
