package ChallengePhase1;

public class NodeSwapByValue {
    static class Node{
        int val ; 
        Node next ; 
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void printList(Node root){
        Node temp = root;
        while (temp!=null) {
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public static Node swapNodeByValue(Node node , int value){
        // Base case
        if(node==null) return null;
        Node root = node;
        // Swapping condition
        if(node.val==value){
            if(node.next==null) return root;
            Node nextNode = node.next;
            Node nextIteration = nextNode.next;
            // Swapping
            Node temp = node;
            node.next=swapNodeByValue(nextIteration,value);
            nextNode.next=temp;
            root=nextNode;
            return root;
        }
        node.next=swapNodeByValue(node.next , value);
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;
        // Print initial list
        printList(node1);
        // After swapping
        System.out.println("-----------");
        printList(swapNodeByValue(node1, 5));
        
    }
}
