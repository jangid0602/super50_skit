import java.util.Scanner;

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

public class CoollapseLinkedList {
    public static Node collapse(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null && curr.next != null) {

            if (curr.value == curr.next.value) {
                curr.count += curr.next.count;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + "," + temp.count + ") ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Node head = null, tail = null;

    while (true) {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Create List");
        System.out.println("2. Print List");
        System.out.println("3. Collapse Adjacent Same Values");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter number of nodes: ");
                int n = sc.nextInt();

                head = null;
                tail = null;

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter character value (A-Z): ");
                    char val = sc.next().charAt(0);

                    System.out.print("Enter count: ");
                    int cnt = sc.nextInt();

                    Node node = new Node(val, cnt);

                    if (head == null) {
                        head = tail = node;
                    } else {
                        tail.next = node;
                        tail = node;
                    }
                }

                System.out.println("List created successfully.");
                break;
            case 2:
                System.out.print("List: ");
                printList(head);
                break;
            case 3:
                head = collapse(head);
                System.out.println("List collapsed (in-place).");
                System.out.print("Updated List: ");
                printList(head);
                break;

            case 4:
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }
}

}
