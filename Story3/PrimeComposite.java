import java.util.*;

class Node {
    int val;
    Node next;
    Node(int v) { val = v; }
}

public class PrimeComposite {

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    static Node partitionPrimes(Node head) {

        Node primeHead = null, primeTail = null;
        Node compHead = null, compTail = null;
        Node oneHead = null, oneTail = null;

        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = null;

            if (curr.val == 1) {
                if (oneHead == null) oneHead = oneTail = curr;
                else oneTail = oneTail.next = curr;
            }
            else if (isPrime(curr.val)) {
                if (primeHead == null) primeHead = primeTail = curr;
                else primeTail = primeTail.next = curr;
            }
            else {
                if (compHead == null) compHead = compTail = curr;
                else compTail = compTail.next = curr;
            }

            curr = next;
        }

        Node newHead = null, tail = null;

        if (primeHead != null) {
            newHead = primeHead;
            tail = primeTail;
        }

        if (compHead != null) {
            if (newHead == null) newHead = compHead;
            else tail.next = compHead;
            tail = compTail;
        }

        if (oneHead != null) {
            if (newHead == null) newHead = oneHead;
            else tail.next = oneHead;
            tail = oneTail;
        }

        return newHead;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null, tail = null;
        Node result = null;

        while (true) {

            System.out.println("\n----- MENU -----");
            System.out.println("1. Create Linked List");
            System.out.println("2. Print List");
            System.out.println("3. Partition");
            System.out.println("4. Print Partitioned List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("How many nodes? ");
                    int n = sc.nextInt();

                    head = tail = null;
                    System.out.println("Enter values: ");

                    for (int i = 0; i < n; i++) {
                        int v = sc.nextInt();
                        Node node = new Node(v);

                        if (head == null) head = tail = node;
                        else {
                            tail.next = node;
                            tail = node;
                        }
                    }
                    System.out.println("List created.");
                    break;

                case 2:
                    System.out.print("List: ");
                    print(head);
                    break;

                case 3:
                    result = partitionPrimes(head);
                    System.out.println("Partition complete.");
                    break;

                case 4:
                    System.out.print("Partitioned: ");
                    print(result);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
