/*
author: Aman Jeet Singh
description: Implementation of a function that merges two linked lists in a k-zipline fashion.
file: KZiplineMerge.java
*/

public class KZiplineMerge {

    static class Node {
        String val;
        Node next;
        Node(String v) { val = v; }
    }

    public static Node kZiplineMerge(Node head1, Node head2, int k) {

        Node dummy = new Node("");
        Node tail = dummy;

        Node p1 = head1, p2 = head2;
        boolean takeFromFirst = true;

        while (p1 != null || p2 != null) {

            int count = 0;

            if (takeFromFirst) {
                while (p1 != null && count < k) {
                    tail.next = p1;
                    tail = tail.next;
                    p1 = p1.next;
                    count++;
                }
            } else {
                while (p2 != null && count < k) {
                    tail.next = p2;
                    tail = tail.next;
                    p2 = p2.next;
                    count++;
                }
            }
            takeFromFirst = !takeFromFirst;
        }

        return dummy.next;
    }
}
