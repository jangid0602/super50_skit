/*
*Filename - Task5.java
*Description - You are given the head of a singly linked list of integers. Write a function
    partitionPrimes(head) that rearranges the list such that all nodes with prime values come
    before all nodes with composite values. The number 1 is considered neither prime nor
    composite and should be placed at the very end of the list.
    You must maintain the original relative order of the primes among themselves, and the
    composites among themselves. This must be done in-place (O(1) extra space).
Author - Nancy Jain
 */

import java.util.*;

public class Task5 {

    // ---------------- SAFE READ INT ----------------
    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.print("Invalid input! Enter again: ");
            }
        }
    }

    // ---------------- LINKED LIST NODE -------------
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // ---------------- CHECK PRIME -------------------
    static boolean isPrime(int number) {

        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int d = 3; d * d <= number; d += 2) {
            if (number % d == 0)
                return false;
        }
        return true;
    }

    // ----------- PARTITION INTO PRIME/COMPOSITE/ONES --------
    static Node partitionList(Node head) {

        Node primeHead = null, primeTail = null;
        Node compositeHead = null, compositeTail = null;
        Node onesHead = null, onesTail = null;

        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = null; // detach

            if (current.value == 1) {
                // Ones list
                if (onesHead == null) onesHead = onesTail = current;
                else {
                    onesTail.next = current;
                    onesTail = current;
                }
            } 
            else if (isPrime(current.value)) {
                // Prime list
                if (primeHead == null) primeHead = primeTail = current;
                else {
                    primeTail.next = current;
                    primeTail = current;
                }
            } 
            else {
                // Composite list
                if (compositeHead == null) compositeHead = compositeTail = current;
                else {
                    compositeTail.next = current;
                    compositeTail = current;
                }
            }

            current = next;
        }

        // Combine lists: Primes → Composites → Ones
        Node finalHead = null, finalTail = null;

        if (primeHead != null) {
            finalHead = primeHead;
            finalTail = primeTail;
        }

        if (compositeHead != null) {
            if (finalHead == null) finalHead = compositeHead;
            else finalTail.next = compositeHead;
            finalTail = compositeTail;
        }

        if (onesHead != null) {
            if (finalHead == null) finalHead = onesHead;
            else finalTail.next = onesHead;
        }

        return finalHead;
    }

    // ---------------- BUILD LIST ----------------------
    static Node buildList(int[] arr) {
        Node head = null, tail = null;
        for (int num : arr) {
            Node newNode = new Node(num);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // ---------------- PRINT LIST ----------------------
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // ---------------- MAIN ----------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter number of nodes: ");
            int n = readInt(sc);

            int[] arr = new int[n];
            System.out.println("Enter values:");
            for (int i = 0; i < n; i++) {
                arr[i] = readInt(sc);
            }

            Node head = buildList(arr);

            System.out.println("\nOriginal List:");
            printList(head);

            head = partitionList(head);

            System.out.println("\nRearranged List (Primes → Composites → Ones):");
            printList(head);

            System.out.print("\nDo you want to continue? (yes-1 / no-0): ");
            int ch = readInt(sc);

            if (ch == 0) {
                System.out.println("Exiting…");
                break;
            }
        }
    }
}
