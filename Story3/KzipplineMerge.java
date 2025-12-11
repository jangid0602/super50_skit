import java.util.Scanner;

/**
 * @filename - Kzippline.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    void insert(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void display() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static Node kZiplineMerge(Node head1, Node head2, int k) {

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        if (k <= 0)
            k = 1;

        Node p1 = head1;
        Node p2 = head2;

        Node mergedHead = null;
        Node mergedTail = null;

        boolean takeFromFirst = true;

        while (p1 != null && p2 != null) {

            Node current = takeFromFirst ? p1 : p2;

            Node Start = current;
            Node End = current;

            int count = 1;
            while (count < k && End.next != null) {
                End = End.next;
                count++;
            }

            Node nextNode = End.next;
            End.next = null;

            if (takeFromFirst)
                p1 = nextNode;
            else
                p2 = nextNode;

            if (mergedHead == null) {
                mergedHead = Start;
                mergedTail = End;
            } else {
                mergedTail.next = Start;
                mergedTail = End;
            }

            takeFromFirst = !takeFromFirst;
        }

        if (mergedHead == null) {
            return p1 != null ? p1 : p2;
        }

        if (p1 != null)
            mergedTail.next = p1;
        else if (p2 != null)
            mergedTail.next = p2;

        return mergedHead;
    }

}

public class KzipplineMerge {
    public static void create(LinkedList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = scanner.nextInt();
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {

            String node = scanner.next();
            list.insert(node);
        }
        System.out.println("LinkedList is");
        list.display();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList list1 = new LinkedList();
        create(list1);
        LinkedList list2 = new LinkedList();
        create(list2);

        System.out.println("Enter value of K");
        int k = scanner.nextInt();

        Node mergedHead = LinkedList.kZiplineMerge(list1.head, list2.head, k);

        LinkedList mergedList = new LinkedList();
        mergedList.head = mergedHead;
        System.out.println("LinkedList after merge");
        mergedList.display();

        scanner.close();
    }
}
