import java.util.Scanner;

/**
 * @Filename-DigitalLibrary.java
 * @Description-Middle of a linkedlist
 * @Author-Anushka Kumawat
 **/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;

    void insert(int data) {
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
}

class Solve {
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

public class LinkedList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        System.out.println("Enter number of nodes:");
        int n = scanner.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.insert(scanner.nextInt());
        }

        System.out.println("LinkedList is:");
        list.display();

        Solve s = new Solve();
        Node middle = s.middleNode(list.head);

        if (middle != null) {
            System.out.println("Middle Node: " + middle.data);
        } else {
            System.out.println("List is empty");
        }

        scanner.close();
    }
}
