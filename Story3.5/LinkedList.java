public class LinkedList {
    class Node {
        int data;
        Node next;

        Node() {
            data = 0;
            next = null;
        }

        Node(int d) {
            data = d;
        }
    }
        Node head = null;
        void insert(int num){
            Node newNode = new Node(num);
            if(head == null){
                head = newNode;
            }
            else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        int getMiddleNode(){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
}
