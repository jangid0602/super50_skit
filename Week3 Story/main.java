/* 
 * @filename - main.java
 * @description - Menu driven program for story3 solutions
 * @author - Khushi
 */


import java.util.*;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==============================");
            System.out.println("     WEEK 3 — MENU PROGRAM");
            System.out.println("==============================");
            System.out.println("1. O(1) Average Stack");
            System.out.println("2. Python Indentation Validator");
            System.out.println("3. 2D Linked List Transpose");
            System.out.println("4. K-Zipline Merge");
            System.out.println("5. Prime/Composite Partition");
            System.out.println("6. Leaky Bucket Queue");
            System.out.println("7. C-String Interweaver");
            System.out.println("8. Collapsing Count List");
            System.out.println("9. Zigzag Multi-Level Flatten");
            System.out.println("10. EXIT");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {
                case 1: runAverageStack(); break;
                case 2: runIndentValidator(); break;
                case 3: runTranspose2D(); break;
                case 4: runKZipMerge(); break;
                case 5: runPrimePartition(); break;
                case 6: runLeakyBucket(); break;
                case 7: runInterweaver(); break;
                case 8: runCollapseList(); break;
                case 9: runZigzagFlatten(); break;
                case 10: 
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ============= 1. Average Stack =============
    private static void runAverageStack() {
        MySolution.AverageStack st = new MySolution.AverageStack();
        st.push(10);
        st.push(20);
        System.out.println("Average = " + st.getAverage());
        st.push(30);
        System.out.println("Average = " + st.getAverage());
        System.out.println("Popped = " + st.pop());
        System.out.println("Average = " + st.getAverage());
    }


    // ============= 2. Python Indentation Validator =============
    private static void runIndentValidator() {
        System.out.print("Enter number of lines: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] lines = new String[n];
        System.out.println("Enter code lines:");
        for (int i = 0; i < n; i++) lines[i] = sc.nextLine();

        System.out.println("Valid? " + MySolution.isValidIndentation(lines));
    }


    // ============= 3. 2D Linked List Transpose =============
    private static void runTranspose2D() {
        MySolution.Node2D a = new MySolution.Node2D(1);
        MySolution.Node2D b = new MySolution.Node2D(2);
        MySolution.Node2D c = new MySolution.Node2D(3);

        MySolution.Node2D d = new MySolution.Node2D(4);
        MySolution.Node2D e = new MySolution.Node2D(5);
        MySolution.Node2D f = new MySolution.Node2D(6);

        a.right = b; b.right = c;
        a.down = d; b.down = e; c.down = f;

        MySolution.transpose(a);

        System.out.println("Transposed (row wise): ");
        MySolution.Node2D cur = a;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }


    // ============= 4. K Zipline Merge =============
    private static void runKZipMerge() {
        MySolution.Node h1 = new MySolution.Node(1);
        h1.next = new MySolution.Node(2);
        h1.next.next = new MySolution.Node(3);

        MySolution.Node h2 = new MySolution.Node(10);
        h2.next = new MySolution.Node(20);
        h2.next.next = new MySolution.Node(30);

        MySolution.Node out = MySolution.kZiplineMerge(h1, h2, 2);

        System.out.println("Zipped List:");
        while (out != null) {
            System.out.print(out.val + " ");
            out = out.next;
        }
    }


    // ============= 5. Prime Composite Partition =============
    private static void runPrimePartition() {
        MySolution.Node head = new MySolution.Node(3);
        head.next = new MySolution.Node(4);
        head.next.next = new MySolution.Node(1);
        head.next.next.next = new MySolution.Node(2);

        MySolution.Node out = MySolution.partitionPrimes(head);

        System.out.println("Partitioned:");
        while (out != null) {
            System.out.print(out.val + " ");
            out = out.next;
        }
    }


    // ============= 6. Leaky Bucket =============
    private static void runLeakyBucket() {
        MySolution.LeakyBucket b = new MySolution.LeakyBucket(3);
        b.enqueue(1); b.enqueue(2); b.enqueue(3);
        b.enqueue(4);
        System.out.println("Processed: " + b.process(2));
    }


    // ============= 7. Interweaver =============
    private static void runInterweaver() {
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        System.out.println("Interwoven: " + MySolution.interweave(s1, s2));
    }


    // ============= 8. Collapsing Count List =============
    private static void runCollapseList() {
        MySolution.CNT a = new MySolution.CNT("A", 2);
        MySolution.CNT b = new MySolution.CNT("A", 3);
        MySolution.CNT c = new MySolution.CNT("B", 1);

        a.next = b; b.next = c;

        MySolution.CNT out = MySolution.collapse(a);
        System.out.println("Collapsed List:");

        while (out != null) {
            System.out.print("(" + out.val + "," + out.count + ") ");
            out = out.next;
        }
    }


    // ============= 9. Zigzag Flatten =============
    private static void runZigzagFlatten() {
        MySolution.DNode a = new MySolution.DNode(1);
        MySolution.DNode b = new MySolution.DNode(2);
        MySolution.DNode c = new MySolution.DNode(3);
        a.next = b; b.next = c;

        MySolution.DNode child = new MySolution.DNode(10);
        a.child = child;

        List<Integer> res = MySolution.zigzagFlatten(a);
        System.out.println("Flatten: " + res);
    }
}
