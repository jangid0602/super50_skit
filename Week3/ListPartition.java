import java.util.Scanner;

/**
 * @Filename-ListPartition.java
 * @Description-This rearranges the list such that all nodes with prime values
 *                   come before all nodes with composite values.
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

public class ListPartition {

    public static boolean isPrime(int n) {
        // Using Sieve of Eratosthenes
        if (n < 2) {
            return false;
        }
        boolean[] sieve = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            sieve[i] = true;
        }

        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve[n];
    }

    public static Node partition(Node head) {
        if (head == null)
            return null;

        Node primeDummy = new Node(-1), compDummy = new Node(-1), oneDummy = new Node(-1);
        Node primeTail = primeDummy, compTail = compDummy, oneTail = oneDummy;

        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = null;

            if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = temp;
            } else if (isPrime(temp.data)) {
                primeTail.next = temp;
                primeTail = temp;
            } else {
                compTail.next = temp;
                compTail = temp;
            }

            temp = nextNode;
        }
        primeTail.next = compDummy.next;
        compTail.next = oneDummy.next;

        return primeDummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the list");
        int size = scanner.nextInt();
        Node dummy = new Node(-1);
        Node head = dummy;
        System.out.println("Enter elements");
        for (int i = 1; i <= size; i++) {
            int value = scanner.nextInt();
            Node temp = new Node(value);
            dummy.next = temp;
            dummy = dummy.next;
        }
        head = head.next;
        Node temp = head;
        System.out.println("List before partition is:");
        for (int i = 1; i <= size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        Node partitionNode = partition(head);
        System.out.println("List after partition is:");
        Node traverse = partitionNode;
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
    }
}
