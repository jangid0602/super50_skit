import java.util.Scanner;

/**
 * @Filename-MidpointFinder.java
 * @Description-This program finds the middle node of a linked list using the efficient
 *                   two-pointer technique (also known as the slow and fast pointer approach).
 *                   The slow pointer moves one step at a time while the fast pointer moves
 *                   two steps per iteration. When the fast pointer reaches the end of the
 *                   list, the slow pointer will be at the middle node, achieving O(n) time
 *                   complexity with O(1) space complexity.
 * @Author- Aman Jeet Singh
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
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    /**
     * Safely reads a non-empty string from the scanner, prompting user until valid input is provided.
     */
    private static String readString(Scanner scanner) {
        String input = scanner.next().trim();
        while (input.isEmpty()) {
            System.out.println("Invalid input! Please enter a non-empty string.");
            input = scanner.next().trim();
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of the list: ");
        int size = readInt(scanner);

        Node dummy = new Node("-1");
        Node head = dummy;
        System.out.println("Enter node values:");
        for (int i = 1; i <= size; i++) {
            System.out.print("Node " + i + ": ");
            String data = readString(scanner);
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