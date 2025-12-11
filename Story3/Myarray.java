import java.util.ArrayList;
import java.util.Scanner;

/**
 * @filename - Myarray.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class AverageStack {
    ArrayList<Integer> list = new ArrayList<>();
    double sum = 0;

    AverageStack() {
    }

    void push(int value) {
        list.add(value);
        sum += value;
    }

    void pop() {
        if (list.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        int n = list.size() - 1;
        sum -= list.get(n);
        list.remove(n);
    }

    double getAverage() {
        if (list.isEmpty())
            return 0;
        return sum / list.size();
    }
}

public class Myarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AverageStack stack = null;

        System.out.println("\n--- MENU ---");
        System.out.println("1 → Create AverageStack");
        System.out.println("2 → push(x)");
        System.out.println("3 → pop()");
        System.out.println("4 → getAverage()");
        System.out.println("5 → exit");
        System.out.println("------------------");

        while (true) {
            System.out.print("\nEnter operation: ");
            int op = sc.nextInt();

            switch (op) {

                case 1:
                    stack = new AverageStack();
                    System.out.println("AverageStack created");
                    break;

                case 2:
                    if (stack == null) {
                        System.out.println("Stack not created!");
                        break;
                    }
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    System.out.println("Pushed: " + val);
                    break;

                case 3:
                    if (stack == null) {
                        System.out.println("Stack not created!");
                        break;
                    }
                    stack.pop();
                    break;

                case 4:
                    if (stack == null) {
                        System.out.println("Stack not created!");
                        break;
                    }
                    System.out.println("Average: " + stack.getAverage());
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid operation!");
            }
        }
    }
}
