import java.util.Scanner;

/**
 * @Filename-KZiplineMerge.java
 * @Description-This merges the two lists by zipping them in
 *                   chunks of k.
 * @Author-Aditya Virmani
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class KZiplineMerge {
    public static Node merge(Node head1, Node head2, int k) {
        Node dummy = new Node(-1);
        Node newHead = dummy;
        Node temp1 = head1, temp2 = head2;
        if (k <= 0) {
            while (temp1 != null) {
                dummy.next = temp1;
                temp1 = temp1.next;
                dummy = dummy.next;
            }
            while (temp2 != null) {
                dummy.next = temp2;
                temp2 = temp2.next;
                dummy = dummy.next;
            }
            return newHead.next;
        }
        while (temp1 != null && temp2 != null) {
            int num = k;
            while (temp1 != null && num > 0) {
                dummy.next = temp1;
                dummy = dummy.next;
                temp1 = temp1.next;
                num--;
            }
            num = k;
            while (temp2 != null && num > 0) {
                dummy.next = temp2;
                dummy = dummy.next;
                temp2 = temp2.next;
                num--;
            }
        }
        while (temp1 != null) {
            dummy.next = temp1;
            dummy = dummy.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            dummy.next = temp2;
            dummy = dummy.next;
            temp2 = temp2.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head1 = null, head2 = null;
        int k;
        int size1, size2;
        System.out.println("Enter size of first linked list");
        size1 = scanner.nextInt();
        System.out.println("Enter elements of first linked list");
        Node temp = head1;
        for (int i = 1; i <= size1; i++) {
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            if (temp == null) {
                temp = newNode;
                head1 = temp;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        System.out.println("First linked list is:");
        temp = head1;
        for (int i = 1; i <= size1; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\nEnter size of second linked list");
        size2 = scanner.nextInt();
        System.out.println("Enter elements of second linked list");
        temp = head2;
        for (int i = 1; i <= size2; i++) {
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            if (temp == null) {
                temp = newNode;
                head2 = temp;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        System.out.println("Second linked list is:");
        temp = head2;
        for (int i = 1; i <= size2; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\nEnter the value of k");
        k = scanner.nextInt();
        Node mergedHead = merge(head1, head2, k);
        System.out.println("Merged list is:");
        Node traverse = mergedHead;
        for (int i = 1; i <= size1 + size2; i++) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
    }
}
