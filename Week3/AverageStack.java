
import java.util.Scanner;
import java.util.Stack;

/**
 * @Filename-AverageStack.java
 * @Description-This supports the push,pop,top and getAverage operation in O(1)
 *                   time.
 * @Author-Aditya Virmani
 */
class Node {
    int value;
    Node next;

    Node(int val) {
        this.value = val;
        this.next = null;
    }
}

public class AverageStack {
    private Node top;
    private int size;
    private long sum;

    public AverageStack() {
        top = null;
        size = 0;
        sum = 0;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        sum += val;
        size++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int topVal = top.value;
        size--;
        sum -= topVal;
        top = top.next;
        return topVal;
    }

    public int top() {
        if (top == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int topVal = top.value;
        return topVal;
    }

    public float getAverage() {
        if (top == null) {
            System.out.println("Stack is empty");
            return 0.0f;
        }
        float average = 0.0f;
        average = (float) sum / size;
        return average;
    }

    public static int readInt(Scanner scanner, String prompt) {
        int number = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (!validInput);

        return number;
    }

    public static void main(String[] args) {
        AverageStack stack = new AverageStack();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get top element");
            System.out.println("4. Get average");
            System.out.println("0. Exit");

            choice = readInt(scanner, "Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the value to be pushed");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                }

                case 2 -> {
                    int poppedValue = stack.pop();
                    if (poppedValue != Integer.MIN_VALUE) {
                        System.out.println("Popped element is: " + poppedValue);
                    }
                }

                case 3 -> {
                    int topElement = stack.top();
                    if (topElement != Integer.MIN_VALUE) {
                        System.out.println("Top element is: " + topElement);
                    }
                }

                case 4 -> {
                    float average = stack.getAverage();
                    System.out.println("Average is:" + average);
                }

                case 0 -> System.out.println("Exiting program... Goodbye!");

                default -> System.out.println("Invalid choice! Please enter a number between 0 to 4.");
            }
        } while (choice != 0);
    }
}
