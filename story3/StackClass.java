

import java.util.Stack;

public class StackClass {
    static class Node{
        int value;
        int count;
        Node right;
        Node down;
        Node(int value){
            this.value = value;
            right = null;
            down = null;
        }
    }
    public boolean getIndentationValidation(String[] lines){
        Stack<Integer> stack = new Stack<>();
        for(String line : lines){
            int countOfLeadingSpaces = countLeadingSpaces(line);
            int topOfStack = stack.peek();
            if(countOfLeadingSpaces > topOfStack){
                stack.push(countOfLeadingSpaces);
            }
            else if (countOfLeadingSpaces < topOfStack) {
                while (!stack.isEmpty() && stack.peek() > countOfLeadingSpaces) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() != countOfLeadingSpaces) {
                    return false;
                }
            }
        }
        return true;
    }
    public int countLeadingSpaces(String line){
        int countOfSpaces = 0;
        while(countOfSpaces < line.length() && line.charAt(countOfSpaces) == ' '){
            countOfSpaces++;
        }
        return countOfSpaces;
    }

    public Node getTranspose(Node head){
        if(head == null) return null;
        Node row = head;
        while(row != null){
            Node col = row;
            while(col != null){
                Node temp = col.right;
                col.right = col.down;
                col.down = temp;
                col = col.right;
            }
            row = row.down;
        }

        return head;
    }

    public Node getZippedList(Node head1, Node head2,  int k){
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(0);
        Node newHead = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1 != null){
                for(int i = 0; i < k; i++){
                    newHead.right = temp1;
                    newHead = newHead.right;
                    temp1 = temp1.right;
                }
            }
            if(temp2 != null){
                for(int i = 0; i < k; i++){
                    newHead.right = temp2;
                    newHead = newHead.right;
                    temp2 = temp2.right;
                }
            }
        }
        newHead.right = null;
        return dummy.right;
    }
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public Node partitionPrimes(Node head) {

        if (head == null) return null;

        Node primeHead = null, primeTail = null;
        Node compHead = null, compTail = null;
        Node onesHead = null, onesTail = null;

        Node curr = head;

        while (curr != null) {
            Node next = curr.right;
            curr.right = null;

            int val = curr.value;

            if (val == 1) {
                if (onesHead == null) onesHead = curr;
                else onesTail.right = curr;
                onesTail = curr;
            }
            else if (isPrime(val)) {
                if (primeHead == null) primeHead = curr;
                else primeTail.right = curr;
                primeTail = curr;
            }
            else {
                if (compHead == null) compHead = curr;
                else compTail.right = curr;
                compTail = curr;
            }

            curr = next;
        }
        Node newHead = null;
        Node tail = null;
        if (primeHead != null) {
            newHead = primeHead;
            tail = primeTail;
        }
        if (compHead != null) {
            if (newHead == null) {
                newHead = compHead;
                tail = compTail;
            } else {
                tail.right = compHead;
                tail = compTail;
            }
        }

        if (onesHead != null) {
            if (newHead == null) {
                newHead = onesHead;
                tail = onesTail;
            } else {
                tail.right = onesHead;
                tail = onesTail;
            }
        }

        return newHead;
    }

    public Node collapse(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null && curr.right != null) {
            if (curr.value == curr.right.value) {
                curr.count += curr.right.count;
                curr.right = curr.right.right;
            } else {
                curr = curr.right;
            }
        }

        return head;
    }

}
