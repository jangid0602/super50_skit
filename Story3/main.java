import java.util.*;

/*
author: Aman Jeet Singh
description: Main menu to access various data structure and algorithm implementations.
file: main.java
*/

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=============== MAIN MENU ===============");
            System.out.println("1. O(1) Average Stack");
            System.out.println("2. Python Indentation Validator");
            System.out.println("3. 2D Linked List Transpose");
            System.out.println("4. K-Zipline Merge");
            System.out.println("5. Prime/Composite Partition");
            System.out.println("6. Leaky Bucket Queue");
            System.out.println("7. C-String Interweaver");
            System.out.println("8. Collapsing Count List");
            System.out.println("9. Zigzag Multi-Level Flatten");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1": runAverageStack(sc); break;
                case "2": runIndentation(sc); break;
                case "3": runTranspose2D(sc); break;
                case "4": runKZipline(sc); break;
                case "5": runPrimePartition(sc); break;
                case "6": runLeakyBucket(sc); break;
                case "7": runCStringInterweaver(sc); break;
                case "8": runCollapsingCountList(sc); break;
                case "9": runZigzagFlatten(sc); break;

                case "10":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // ---------------------- TASK 1 ----------------------
    private static void runAverageStack(Scanner sc) {

        AverageStack st = new AverageStack();

        System.out.println("\nCommands: push X | pop | top | avg | back");

        while (true) {
            System.out.print("> ");
            String cmd = sc.nextLine();

            if (cmd.equals("back")) return;

            if (cmd.startsWith("push")) {
                String[] p = cmd.split(" ");
                st.push(Integer.parseInt(p[1]));
            }
            else if (cmd.equals("pop")) {
                System.out.println(st.pop());
            }
            else if (cmd.equals("top")) {
                System.out.println(st.top());
            }
            else if (cmd.equals("avg")) {
                System.out.println(st.getAverage());
            }
            else {
                System.out.println("Invalid command.");
            }
        }
    }

    // ---------------------- TASK 2 ----------------------
    private static void runIndentation(Scanner sc) {

        System.out.print("Enter number of lines: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] lines = new String[n];

        for (int i = 0; i < n; i++)
            lines[i] = sc.nextLine();

        boolean ok = IndentationValidator.isValidIndentation(lines);

        System.out.println(ok ? "VALID" : "INVALID");
    }

    // ---------------------- TASK 3 ----------------------
    private static void runTranspose2D(Scanner sc) {

        System.out.print("Rows: ");
        int r = sc.nextInt();
        System.out.print("Columns: ");
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Enter matrix:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = sc.nextInt();

        sc.nextLine();

        Node head = TwoDLinkedList.build(mat);

        System.out.println("Original:");
        TwoDLinkedList.print(head);

        Node newHead = TwoDLinkedList.transpose(head);

        System.out.println("Transposed:");
        TwoDLinkedList.print(newHead);
    }

    // ---------------------- TASK 4 ----------------------
    private static void runKZipline(Scanner sc) {

        System.out.print("Enter size of list1: ");
        int n1 = Integer.parseInt(sc.nextLine());

        KZiplineMerge.Node head1 = null, tail1 = null;

        System.out.println("Enter list1 values:");
        for (int i = 0; i < n1; i++) {
            KZiplineMerge.Node newNode = new KZiplineMerge.Node(sc.nextLine());
            if (head1 == null) head1 = tail1 = newNode;
            else { tail1.next = newNode; tail1 = newNode; }
        }

        System.out.print("Enter size of list2: ");
        int n2 = Integer.parseInt(sc.nextLine());

        KZiplineMerge.Node head2 = null, tail2 = null;

        System.out.println("Enter list2 values:");
        for (int i = 0; i < n2; i++) {
            KZiplineMerge.Node newNode = new KZiplineMerge.Node(sc.nextLine());
            if (head2 == null) head2 = tail2 = newNode;
            else { tail2.next = newNode; tail2 = newNode; }
        }

        System.out.print("Enter k: ");
        int k = Integer.parseInt(sc.nextLine());

        KZiplineMerge.Node result = KZiplineMerge.kZiplineMerge(head1, head2, k);

        System.out.println("Merged List:");
        KZiplineMerge.Node p = result;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    // ---------------------- TASK 5 ----------------------
    private static void runPrimePartition(Scanner sc) {

        System.out.print("Enter size of list: ");
        int n = Integer.parseInt(sc.nextLine());

        PrimeCompositePartition.Node head = null, tail = null;

        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) {
            PrimeCompositePartition.Node newNode =
                    new PrimeCompositePartition.Node(Integer.parseInt(sc.nextLine()));
            if (head == null) head = tail = newNode;
            else { tail.next = newNode; tail = newNode; }
        }

        PrimeCompositePartition.Node res =
                PrimeCompositePartition.partitionPrimes(head);

        System.out.println("Partitioned List:");
        PrimeCompositePartition.Node p = res;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    // ---------------------- TASK 6 ----------------------
    private static void runLeakyBucket(Scanner sc) {

        System.out.print("Capacity: ");
        int cap = Integer.parseInt(sc.nextLine());

        LeakyBucket bucket = new LeakyBucket(cap);

        System.out.println("Commands: enqueue X | process K | back");

        while (true) {

            System.out.print("> ");
            String cmd = sc.nextLine();

            if (cmd.equals("back")) return;

            if (cmd.startsWith("enqueue")) {
                String[] p = cmd.split(" ");
                if( p.length != 2) {
                    System.out.println("Invalid command.");
                    continue;
                }
                bucket.enqueue(p[1]);
            }
            else if (cmd.startsWith("process")) {
                String[] p = cmd.split(" ");
                if( p.length != 2) {
                    System.out.println("Invalid command.");
                    continue;
                }
                int k = Integer.parseInt(p[1]);
                System.out.println(bucket.process(k));
            }
            else {
                System.out.println("Invalid command.");
            }
        }
    }

    // ---------------------- TASK 7 ----------------------
    private static void runCStringInterweaver(Scanner sc) {
        System.out.print("Enter string 1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter string 2: ");
        String s2 = sc.nextLine();

        String result = CStringInterweaver.interweave(s1, s2);

        System.out.println("Interwoven String:");
        System.out.println(result);
    }

    // ---------------------- TASK 8 ----------------------
    private static void runCollapsingCountList(Scanner sc) {

        System.out.print("Enter number of nodes: ");
        int n = Integer.parseInt(sc.nextLine());

        CollapsingCountList.Node head = null, tail = null;

        System.out.println("Enter <value> <count> pairs:");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Try again.");
                i--;
                continue;
            }
            CollapsingCountList.Node newNode =
                    new CollapsingCountList.Node(parts[0], Integer.parseInt(parts[1]));

            if (head == null) head = tail = newNode;
            else { tail.next = newNode; tail = newNode; }
        }

        CollapsingCountList.Node result = CollapsingCountList.collapse(head);

        System.out.println("Collapsed List:");
        CollapsingCountList.Node p = result;
        while (p != null) {
            System.out.print("(" + p.value + "," + p.count + ") ");
            p = p.next;
        }
        System.out.println();
    }

    // ---------------------- TASK 9 ----------------------
    private static void runZigzagFlatten(Scanner sc) {
        System.out.println("\n=== ZIGZAG MULTI-LEVEL FLATTEN ===");

    // Build list using your input menu
    NodeLevel head = ZigzagUserInput.buildList(0, null);

    List<Integer> result = new ArrayList<>();

    // Perform zigzag flatten
    ZigzagUserInput.zigzagFlatten(head, 0, result);

    // Print the result
    System.out.println("\nZigzag Flattened Output:");
    for (int x : result) {
        System.out.print(x + "-");
    }
    System.out.println("NULL");
        
    }
}
