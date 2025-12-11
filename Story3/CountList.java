import java.util.Scanner;

/**
 * @filename - CountList.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Node {
    char value;
    int count;
    Node next;

    Node(char value, int count) {
        this.value = value;
        this.count = count;
        this.next = null;
    }
}

class LinkedList {
    public static Node insert(Node head, char value, int count) {
        Node newNode = new Node(value, count);

        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + ", " + temp.count + ")");
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node mergeConsecutive(Node head) {
        if (head == null)
            return null;

        Node current = head;

        while (current != null && current.next != null) {
            if (current.value == current.next.value) {

                current.count += current.next.count;

                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

}

public class CountList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        LinkedList list = new LinkedList();
        Node head = null; // start with empty list

        System.out.println("Enter elements with count");
        for (int i = 0; i < n; i++) {
            char value = scanner.next().charAt(0);
            int count = scanner.nextInt();

            head = list.insert(head, value, count);
        }

        System.out.println("Linked List:");
        list.display(head);

        System.out.println("After merging:");
        list.mergeConsecutive(head);
        list.display(head);
    }

}
