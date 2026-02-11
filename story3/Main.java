// @filename - Main.java
// @description - Menu-driven Java program that executes Linked List , stack operations using methods from Methods.java for the given assignment problems (Week 3 Story).
// @author - Mayank Rathore

import static java.lang.System.out;
import java.util.*;

public class Main {

    // get int array
    static int[] getIntArray(int n, Scanner sc) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    out.print("Enter element " + (i + 1) + ": ");
                    arr[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    out.println("Invalid input! Enter an integer.");
                    sc.nextLine();
                }
            }
        }
        return arr;
    }

    // get string array
    static String[] getStringArray(int n, Scanner sc) {
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    out.print("Enter string " + (i + 1) + ": ");
                    arr[i] = sc.nextLine();
                    if (arr[i].trim().isEmpty())
                        throw new Exception("Cannot be empty!");
                    break;
                } catch (Exception e) {
                    out.println("Invalid input! " + e.getMessage());
                }
            }
        }
        return arr;
    }

    // create linked list from int array
    static Methods.Node createLinkedList(int[] arr) {
        Methods.Node head = null, tail = null;
        for (int val : arr) {
            Methods.Node node = new Methods.Node(val);
            if (head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }
        return head;
    }

    // print linked list
    static void printLinkedList(Methods.Node head) {
        Methods.Node ptr = head;
        while (ptr != null) {
            out.print(ptr.value);
            ptr = ptr.next;
            if (ptr != null)
                out.print(" -> ");
        }
        out.println();
    }

    // create simple ZigNode chain interactively
    static Methods.ZigNode createZigList(Scanner sc) {
        out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine();
        Methods.ZigNode head = null, prev = null;
        for (int i = 0; i < n; i++) {
            out.print("Enter value of node " + (i + 1) + ": ");
            int val = sc.nextInt();
            sc.nextLine();
            Methods.ZigNode node = new Methods.ZigNode(val);
            if (head == null)
                head = node;
            else
                prev.next = node;
            prev = node;
        }
        return head;
    }

    // Convert List<Object> to linked list of NodeObj
    static Methods.NodeObj createObjList(List<Object> list) {
        Methods.NodeObj head = null, tail = null;
        for (Object val : list) {
            Methods.NodeObj node = new Methods.NodeObj(val);
            if (head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                out.println("\n--- WEEK 3 ASSIGNMENT ---");
                out.println("1. O(1) Average Stack");
                out.println("2. Python Indentation Validator");
                out.println("3. 2D Linked List Transpose");
                out.println("4. K-Zipline Merge");
                out.println("5. Prime/Composite Partition");
                out.println("6. Leaky Bucket Queue");
                out.println("7. C-String Interweaver");
                out.println("8. Collapsing Count List");
                out.println("9. Zigzag Multi-Level Flatten");
                out.println("10. Exit");
                out.print("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {

                    case 1: // Average Stack
                        Methods.AverageStack stack = new Methods.AverageStack();
                        sc.nextLine(); // clear buffer

                        while (true) {
                            out.println("\n--- Average Stack Operations ---");
                            out.println("1. Push");
                            out.println("2. Pop");
                            out.println("3. Top");
                            out.println("4. Get Average");
                            out.println("5. Exit");
                            out.print("Enter your choice: ");

                            int op = -1;
                            try {
                                op = Integer.parseInt(sc.nextLine().trim());
                            } catch (NumberFormatException e) {
                                out.println("Invalid input! Enter a number 1-5.");
                                continue;
                            }

                            switch (op) {
                                case 1: // Push
                                    out.print("Enter value to push: ");
                                    try {
                                        int val = Integer.parseInt(sc.nextLine().trim());
                                        stack.push(val);
                                        out.println("Pushed " + val);
                                    } catch (NumberFormatException e) {
                                        out.println("Invalid number!");
                                    }
                                    break;

                                case 2: // Pop
                                    out.println("Popped " + stack.pop());
                                    break;

                                case 3: // Top
                                    out.println("Top = " + stack.top());
                                    break;

                                case 4: // Get Average
                                    out.println("Average = " + stack.getAverage());
                                    break;

                                case 5: // Exit
                                    out.println("Exiting stack operations...");
                                    break;

                                default:
                                    out.println("Invalid choice! Enter 1-5.");
                            }

                            if (op == 5)
                                break;
                        }
                        break;

                    case 2: // Python Indentation
                        out.print("Enter number of lines: ");
                        int n2 = sc.nextInt();
                        String[] lines = getStringArray(n2, sc);
                        out.println("Valid Indentation? " + Methods.isValidIndentation(lines));
                        break;

                    case 3: // 2D Linked List Transpose
                        out.print("Enter number of rows: ");
                        int r = sc.nextInt();
                        sc.nextLine();
                        Methods.Node2D head2D = null, prevRow = null;
                        for (int i = 0; i < r; i++) {
                            out.print("Enter row elements (space-separated): ");
                            String[] parts = sc.nextLine().split(" ");
                            Methods.Node2D rowHead = null, prev = null;
                            for (String p : parts) {
                                Methods.Node2D node = new Methods.Node2D(Integer.parseInt(p));
                                if (rowHead == null)
                                    rowHead = node;
                                if (prev != null)
                                    prev.right = node;
                                prev = node;
                            }
                            if (prevRow == null)
                                head2D = rowHead;
                            else {
                                Methods.Node2D temp = prevRow;
                                while (temp.down != null)
                                    temp = temp.down;
                                temp.down = rowHead;
                            }
                            prevRow = rowHead;
                        }
                        Methods.Node2D transposed = Methods.transpose(head2D);
                        out.println("Transposed Matrix:");
                        Methods.Node2D rptr = transposed;
                        while (rptr != null) {
                            Methods.Node2D cptr = rptr;
                            while (cptr != null) {
                                out.print(cptr.val + " ");
                                cptr = cptr.right;
                            }
                            out.println();
                            rptr = rptr.down;
                        }
                        break;

                    // K-Zipline Merge
                    case 4:
                        sc.nextLine();
                        out.print("Enter elements of list1 (space separated): ");
                        String[] a1 = sc.nextLine().split(" ");
                        List<Object> list1 = new ArrayList<>();
                        Collections.addAll(list1, a1); // list1 elements as Strings

                        out.print("Enter elements of list2 (space separated): ");
                        String[] a2 = sc.nextLine().split(" ");
                        List<Object> list2 = new ArrayList<>();
                        Collections.addAll(list2, a2); // list2 elements as Strings

                        out.print("Enter k: ");
                        int k = sc.nextInt();

                        Methods.NodeObj h1 = createObjList(list1);
                        Methods.NodeObj h2 = createObjList(list2);

                        Methods.NodeObj merged = Methods.kZiplineMerge(h1, h2, k);

                        out.print("Merged List: ");
                        while (merged != null) {
                            out.print(merged.value);
                            merged = merged.next;
                            if (merged != null)
                                out.print(" -> ");
                        }
                        out.println();
                        break;

                    case 5: // Prime/Composite
                        out.print("Enter size of list: ");
                        int n5 = sc.nextInt();
                        int[] arr5 = getIntArray(n5, sc);
                        Methods.Node listHead = createLinkedList(arr5);
                        Methods.Node partitioned = Methods.partitionPrimes(listHead);
                        out.print("Partitioned List: ");
                        printLinkedList(partitioned);
                        break;

                    case 6: // Leaky Bucket
                        out.print("Enter bucket capacity: ");
                        int cap = sc.nextInt();
                        sc.nextLine();
                        Methods.LeakyBucket bucket = new Methods.LeakyBucket(cap);

                        while (true) {
                            out.println("\n--- Leaky Bucket Operations ---");
                            out.println("1. Enqueue");
                            out.println("2. Process");
                            out.println("3. Exit");
                            out.print("Enter your choice: ");

                            int op = -1;
                            try {
                                op = Integer.parseInt(sc.nextLine().trim());
                            } catch (NumberFormatException e) {
                                out.println("Invalid input! Enter a number 1-3.");
                                continue;
                            }

                            switch (op) {
                                case 1: // Enqueue
                                    out.print("Enter value to enqueue: ");
                                    String val = sc.nextLine();
                                    bucket.enqueue(val);
                                    out.println("Enqueued: " + val);
                                    break;

                                case 2: // Process
                                    out.print("Enter number of items to process: ");
                                    try {
                                        int num = Integer.parseInt(sc.nextLine().trim());
                                        List<Object> res = bucket.process(num);
                                        out.println("Processed: " + res);
                                    } catch (NumberFormatException e) {
                                        out.println("Invalid number!");
                                    }
                                    break;

                                case 3: // Exit
                                    out.println("Exiting Leaky Bucket operations...");
                                    break;

                                default:
                                    out.println("Invalid choice! Enter 1-3.");
                            }

                            if (op == 3)
                                break;
                        }
                        break;

                    case 7: // Interweave
                        sc.nextLine();
                        out.print("Enter first string: ");
                        String s1 = sc.nextLine();
                        out.print("Enter second string: ");
                        String s2 = sc.nextLine();
                        out.println("Interwoven String: " + Methods.interweave(s1, s2));
                        break;

                    case 8: // Collapsing Count List
                        out.print("Enter number of nodes: ");
                        int n8 = sc.nextInt();
                        sc.nextLine();
                        Methods.CountNode headCount = null, tailCount = null;
                        for (int i = 0; i < n8; i++) {
                            out.print("Enter value: ");
                            String val = sc.nextLine();
                            out.print("Enter count: ");
                            int cnt = sc.nextInt();
                            sc.nextLine();
                            Methods.CountNode node = new Methods.CountNode(val, cnt);
                            if (headCount == null)
                                headCount = node;
                            else
                                tailCount.next = node;
                            tailCount = node;
                        }
                        Methods.CountNode collapsed = Methods.collapse(headCount);
                        out.print("Collapsed List: ");
                        Methods.CountNode ptr = collapsed;
                        while (ptr != null) {
                            out.print("(" + ptr.val + "," + ptr.count + ") ");
                            ptr = ptr.next;
                            if (ptr != null)
                                out.print(" -> ");
                        }
                        out.println();
                        break;

                    case 9: // Zigzag Flatten
                        out.println("Creating simple Zigzag list (no multi-level children for simplicity).");
                        Methods.ZigNode zigHead = createZigList(sc);
                        List<Integer> flat = Methods.zigzagFlatten(zigHead);
                        out.println("Flattened List: " + flat);
                        break;

                    case 10:
                        out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        out.println("Invalid choice!");
                }

            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}