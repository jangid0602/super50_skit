import java.util.Scanner;

class NewNode {
    int val;
    NewNode next;

    NewNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class StackAndLinkedList {
    private NewNode top;
    private int sum = 0;
    private int size = 0;

    public StackAndLinkedList() {
        top = null;
        sum = 0;
        size = 0;
    }

    public int push(int val) {
        NewNode newNode = new NewNode(val);
        newNode.next = top;
        top = newNode;

        sum += val;
        size++;
        return val;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }

        int removed = top.val;
        top = top.next;

        sum -= removed;
        size--;
        return removed;
    }

    public int top() {
        if (top == null) {
            return -1; 
        }
        return top.val;
    }

    public double getAverage() {
        if (size == 0) return 0.0;
        return (double) sum / size;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackAndLinkedList stack = new StackAndLinkedList();

        while (true) {

            System.out.println("\n=== AVERAGE STACK MENU ===");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Get Average");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter value: ");
                    int v = sc.nextInt();
                    stack.push(v);
                    System.out.println("Pushed: " + v);
                    break;

                case 2:
                    int removed = stack.pop();
                    System.out.println(removed == -1
                            ? "Stack is empty! Cannot pop."
                            : "Popped: " + removed);
                    break;

                case 3:
                    int t = stack.top();
                    System.out.println(t == -1
                            ? "Stack is empty! No top element."
                            : "Top element: " + t);
                    break;

                case 4:
                    System.out.println("Average: " + stack.getAverage());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
