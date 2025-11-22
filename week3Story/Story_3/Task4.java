/*
 * Filename  - Task4.java
 * Description - You are given two singly linked lists, head1 and head2, and an integer k. Write a
        function kZiplineMerge(head1, head2, k) that merges the two lists by "zipping" them in
        chunks of k. You should take k nodes from head1, then k nodes from head2, then the next k
        nodes from head1, and so on.
        If one list runs out of nodes, append the remainder of the other list's current chunk, and then
        append the rest of the other list. This must be done in-place by modifying pointers.
 * Author - Nancy Jain
 */import java.util.*;

public class Task4 {

    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.print("Invalid input! Enter again: ");
            }
        }
    }

    static class Node {
        char value;
        Node next;

        Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    static Node buildList(char[] arr) {
        Node head = null, tail = null;
        for (char ch : arr) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    static Node extractKNodes(Node[] headRef, int k) {
        Node head = headRef[0];
        if (head == null) return null;
        Node start = head;
        Node last = null;
        while (head != null && k-- > 0) {
            last = head;
            head = head.next;
        }
        if (last != null) last.next = null;
        headRef[0] = head;   
        return start;
    }

    static Node kZipMerge(Node head1, Node head2, int k) {
        Node mergedHead = null, mergedTail = null;
        boolean takeFirst = true;
        Node[] ref1 = {head1};
        Node[] ref2 = {head2};
        while (ref1[0] != null || ref2[0] != null) {
            Node chunk = takeFirst ? extractKNodes(ref1, k): extractKNodes(ref2, k);
            takeFirst = !takeFirst;
            if (chunk == null) continue;
            if (mergedHead == null) {
                mergedHead = mergedTail = chunk;
            } else {
                mergedTail.next = chunk;
            }
            while (mergedTail.next != null) {
                mergedTail = mergedTail.next;
            }
        }
        return mergedHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter size of List 1: ");
            int n1 = readInt(sc);
            char[] arr1 = new char[n1];
            System.out.println("Enter elements of List 1: ");
            for (int i = 0; i < n1; i++) {
                arr1[i] = sc.next().charAt(0);
            }
            System.out.print("Enter size of List 2: ");
            int n2 = readInt(sc);
            char[] arr2 = new char[n2];
            System.out.println("Enter elements of List 2: ");
            for (int i = 0; i < n2; i++) {
                arr2[i] = sc.next().charAt(0);
            }
            System.out.print("Enter k: ");
            int k = readInt(sc);
            Node head1 = buildList(arr1);
            Node head2 = buildList(arr2);
            System.out.println("\nList 1:");
            printList(head1);
            System.out.println("List 2:");
            printList(head2);
            Node merged = kZipMerge(head1, head2, k);
            System.out.println("\nMerged (K-Zipline) List:");
            printList(merged);

            System.out.print("\nDo you want to continue? (yes-1 / no-0): ");
            int ch = readInt(sc);
            if (ch == 0) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
