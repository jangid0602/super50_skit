import java.util.*;
public class q2 {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public static Node swap(Node head,int x){
        Node temp = head;
        if(head==null || head.next==null)return null;
        if(head.data==x){
            Node t = head;
            Node s = t.next;
            t.next=t.next.next;
            s.next=t;
            t=s;

        }
        while(temp.next.next!=null){
            if(temp.next.data==x){
                Node s = temp.next;
                temp.next=temp.next.next;
                s.next=temp.next.next;
                temp.next.next=s;
                break;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next=b;
        b.next=c;
        c.next=d;
        int x = 2;
        Node res = swap(a,x);
        Node temp = res;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
