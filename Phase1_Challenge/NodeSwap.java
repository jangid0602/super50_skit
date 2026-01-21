class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class NodeSwap{
    static Node solve(Node head, int X){
    if(head == null || head.next == null){
            return head;
        }
        
        if(head.data == X){
            Node temp = head.next;
            head.next = temp.next;
            temp.next = head;       
            head = temp;
        }

        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.next != null){  
            if(curr.data == X){
                Node temp = curr.next;
                curr.next = temp.next;
                prev.next = temp;
                temp.next = curr;
                prev = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(6);


        int X = 6;
        head = solve(head, X);

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}