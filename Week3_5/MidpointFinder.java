package Week3_5;

public class MidpointFinder {
    public static class ListNode {
        public String val;
        public ListNode next;
        public ListNode(String val) { this.val = val; }
    }

    // Returns the value of the middle node (second middle if even length).
    public static String middleValue(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
