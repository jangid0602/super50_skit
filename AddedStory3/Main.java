import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AverageStack averageStack = new AverageStack();
        StackClass stackClass = new StackClass();
        LeakyBucket<Integer> leakyBucket = null;

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. AverageStack Operations");
            System.out.println("2. StackClass Operations");
            System.out.println("3. LeakyBucket Operations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    handleAverageStack(averageStack, sc);
                    break;
                case 2:
                    handleStackClass(stackClass, sc);
                    break;
                case 3:
                    if (leakyBucket == null) {
                        System.out.print("Enter capacity for LeakyBucket: ");
                        int capacity = sc.nextInt();
                        leakyBucket = new LeakyBucket<>(capacity);
                    }
                    handleLeakyBucket(leakyBucket, sc);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleAverageStack(AverageStack stack, Scanner sc) {
        while (true) {
            System.out.println("\n--- AverageStack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Get Average");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    int popped = stack.pop();
                    System.out.println("Popped: " + popped);
                    break;
                case 3:
                    int top = stack.top();
                    System.out.println("Top: " + top);
                    break;
                case 4:
                    float avg = stack.getAverage();
                    System.out.println("Average: " + avg);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleStackClass(StackClass scClass, Scanner sc) {
        while (true) {
            System.out.println("\n--- StackClass Menu ---");
            System.out.println("1. Indentation Validation");
            System.out.println("2. Transpose Linked List");
            System.out.println("3. Zipped List");
            System.out.println("4. Partition Primes");
            System.out.println("5. Collapse List");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of lines: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    String[] lines = new String[n];
                    for (int i = 0; i < n; i++) {
                        lines[i] = sc.nextLine();
                    }
                    boolean valid = scClass.getIndentationValidation(lines);
                    System.out.println("Indentation is " + (valid ? "valid" : "invalid"));
                    break;
                case 2:
                    StackClass.Node headT = inputLinkedList(sc, scClass);
                    StackClass.Node transposed = scClass.getTranspose(headT);
                    printLinkedList(transposed);
                    break;
                case 3:
                    System.out.println("Input first list:");
                    StackClass.Node h1 = inputLinkedList(sc, scClass);
                    System.out.println("Input second list:");
                    StackClass.Node h2 = inputLinkedList(sc, scClass);
                    System.out.print("Enter k: ");
                    int k = sc.nextInt();
                    StackClass.Node zipped = scClass.getZippedList(h1, h2, k);
                    printLinkedList(zipped);
                    break;
                case 4:
                    StackClass.Node headP = inputLinkedList(sc, scClass);
                    StackClass.Node partitioned = scClass.partitionPrimes(headP);
                    printLinkedList(partitioned);
                    break;
                case 5:
                    StackClass.Node headC = inputLinkedList(sc, scClass);
                    StackClass.Node collapsed = scClass.collapse(headC);
                    printLinkedList(collapsed);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleLeakyBucket(LeakyBucket<Integer> bucket, Scanner sc) {
        while (true) {
            System.out.println("\n--- LeakyBucket Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Process k items");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to enqueue: ");
                    int item = sc.nextInt();
                    bucket.enqueue(item);
                    System.out.println("Item enqueued.");
                    break;
                case 2:
                    System.out.print("Enter k: ");
                    int k = sc.nextInt();
                    List<Integer> processed = bucket.process(k);
                    System.out.println("Processed items: " + processed);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static StackClass.Node inputLinkedList(Scanner sc, StackClass scClass) {
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        if (n <= 0) return null;

        StackClass.Node dummy = new StackClass.Node(0);
        StackClass.Node curr = dummy;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int val = sc.nextInt();
            curr.right = new StackClass.Node(val);
            curr = curr.right;
        }
        return dummy.right;
    }

    private static void printLinkedList(StackClass.Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        StackClass.Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
        System.out.println();
    }
}
