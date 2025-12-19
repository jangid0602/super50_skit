import java.util.Scanner;

/**
 * @Filename-MidpointFinder.java
 * @Description-This returns the value of the middle node of the linked list.
 * @Author-Aditya Virmani
 */
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class MidpointFinder {
    public static Node findMiddle(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the list");
        int size = InputHelper.readInt(scanner);

        Node dummy = new Node("-1");
        Node head = dummy;
        System.out.println("Enter node values");
        for (int i = 1; i <= size; i++) {
            String data = scanner.next();
            Node newNode = new Node(data);
            dummy.next = newNode;
            dummy = dummy.next;
        }

        head = head.next;

        Node middleNode = findMiddle(head);
        System.out.println(middleNode == null ? "List is empty.No middle node exists"
                : "The value of middle node is: " + middleNode.data);
        scanner.close();
    }
}
