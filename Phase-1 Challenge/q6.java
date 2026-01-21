public class q6 {

    static Node head = null;
    static Node tail = null;
    static class Node{

        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
            this.next = null;
        }
    }
  
    public void insertNode(int val)
    {
        Node newNode = new Node(val);
        if(head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail =newNode;

    }
    
     static void swapValue(Node head,int x)
    {
         Node temp = head;
         Node prev = head;
         while(temp != null)
         {
             if(temp.value == x && temp.next!= null)
             {
                Node nextVal = temp.next;
                temp.next = nextVal.next;
                prev.next = nextVal;
                nextVal.next = temp;


                temp = temp.next;
             }
             prev = temp;
             temp = temp.next;
         }
    }

    public static void main(String[] args) {
        
        q6 obj = new q6();
        obj.insertNode(1);
        obj.insertNode(2);
        obj.insertNode(3);
        obj.insertNode(4);
        
       
        int x =2;

        swapValue(head,x);

        Node temp =head;

        while(temp!= null)
        {
            System.out.print(temp.value);
            if(temp.next!=null) System.out.print(" -> ");
            temp = temp.next;
        }

       

    }
    
}
