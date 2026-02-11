/**
 * Filename : MidpointFinder.java
 * Description : find the value of the middle node. If the list has an even number of nodes, return the second middle node.
 * Author : Nancy Jain
 */


public class MidpointFinder {
    public static class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
    public static int findMiddle(Node head){
        if(head == null) return -1;
        Node slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
