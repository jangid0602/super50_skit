/*
 * Filename - AverageStackTask.java
 * Description - Stack with O(1) average calculation
 * Author - Nancy Jain
 */

import java.util.Scanner;
import java.util.Stack;

public class AverageStackTask {
    private Stack<Integer> dataStack;
    private long totalSum;

    public AverageStackTask() {
        dataStack = new Stack<>();
        totalSum = 0;
    }

    public void push(int value) {
        dataStack.push(value);
        totalSum += value;
    }

    public int pop() {
        if (dataStack.isEmpty())
            return -1;

        int topValue = dataStack.pop();
        totalSum -= topValue;
        return topValue;
    }

    public int top() {
        if (dataStack.isEmpty())
            return -1;
        return dataStack.peek();
    }

    public double getAverage() {
        if (dataStack.isEmpty())
            return 0.0;
        return (double) totalSum / dataStack.size();
    }

    public static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.print("Invalid input! Enter an integer: ");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {
        AverageStackTask stack = new AverageStackTask();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. PUSH ELEMENT");
        System.out.println("2. POP ELEMENT");
        System.out.println("3. TOP ELEMENT");
        System.out.println("4. GET AVERAGE");
        System.out.println("5. QUIT");

        while (true) {
            System.out.print("\nEnter choice: ");
            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int pushElement = readInt(sc);
                    stack.push(pushElement);
                    System.out.println("Element pushed successfully!");
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println(popped + " popped successfully!");
                    } else {
                        System.out.println("Can't pop element — Stack is empty.");
                    }
                    break;

                case 3:
                    int topElement = stack.top();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    } else {
                        System.out.println("No top element — Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Average of Stack Elements: " + stack.getAverage());
                    break;

                case 5:
                    System.out.print("Do you really want to quit (1 = YES, 0 = NO)? ");
                    int quit = readInt(sc);
                    if (quit == 1) {
                        System.out.println("EXITING...");
                        return;
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
