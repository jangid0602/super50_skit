import java.util.Scanner;


/**
 * @filename - ListPartition.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Node {
    int data;
    Node next;
    Node below;

    Node(int data) {
        this.data = data;
        next = null;
        below = null;
    }
}

class LinkedList {

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

    public static Node partitionPrimes(Node head) {
        if (head == null)
            return null;

        Node prime = new Node(0), primeTail = prime;
        Node comp = new Node(0), compTail = comp;
        Node one = new Node(0), oneTail = one;

        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;

            if (cur.data == 1) {

                oneTail.next = cur;
                oneTail = cur;
            } else if (cur.data > 1 && isPrime(cur.data)) {

                primeTail.next = cur;
                primeTail = cur;
            } else {

                compTail.next = cur;
                compTail = cur;
            }

            cur = next;
        }

        Node newHead = null;

        if (prime.next != null) {
            newHead = prime.next;
            primeTail.next = comp.next;
        } else if (comp.next != null) {
            newHead = comp.next;
        } else {
            newHead = one.next;
        }

        if (comp.next != null) {
            compTail.next = one.next;
        } else if (prime.next != null) {
            primeTail.next = one.next;
        }

        return newHead;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        int r = (int) Math.sqrt(n);
        for (int i = 5; i <= r; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

}

public class ListPartition {
    public static void create(LinkedList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = scanner.nextInt();
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            int node = scanner.nextInt();
            list.insert(node);
        }
        System.out.println("LinkedList is:");
        list.display();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        create(list);
        Node patitionHead = list.partitionPrimes(list.head);
        LinkedList partitionList = new LinkedList();
        partitionList.head = patitionHead;
        System.out.println("Linked after partition");
        partitionList.display();

    }
}
