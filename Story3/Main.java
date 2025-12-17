
package Story3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Average Stack");
            System.out.println("2. Merge K elements of 2 LinkedLists");
            System.out.println("3. Partition LinkedList (Primes first)");
            System.out.println("4. Leaky Bucket Simulation");
            System.out.println("5. Transpose 2D LinkedList");
            System.out.println("6. Collapsing Count List");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    AverageStack stack = new AverageStack();
                    System.out.print("Enter number of elements to push: ");
                    int n1 = sc.nextInt();
                    for (int i = 0; i < n1; i++) {
                        System.out.print("Element " + (i + 1) + ": ");
                        stack.push(sc.nextInt());
                    }
                    System.out.println("Top element: " + stack.top());
                    System.out.println("Average: " + stack.getAverage());
                    System.out.println("Pop element: " + stack.pop());
                    System.out.println("New Top: " + (stack.stack.isEmpty() ? "Empty" : stack.top()));
                    break;

                case 2:
                    KLinkedListMerge mergeObj = new KLinkedListMerge();
                    LinkedList<Integer> list1 = new LinkedList<>();
                    LinkedList<Character> list2 = new LinkedList<>();
                    System.out.print("Enter size of Integer list: ");
                    int size1 = sc.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < size1; i++)
                        list1.add(sc.nextInt());
                    System.out.print("Enter size of Character list: ");
                    int size2 = sc.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < size2; i++)
                        list2.add(sc.next().charAt(0));
                    System.out.print("Enter k value: ");
                    int k = sc.nextInt();
                    System.out.println("Merged List: " + mergeObj.merge(list1, list2, k));
                    break;

                case 3:
                    LinkedList<Integer> plist = new LinkedList<>();
                    System.out.print("Enter size of list: ");
                    int sz = sc.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < sz; i++)
                        plist.add(sc.nextInt());
                    LinkedList<Integer> partitioned = PartitionLinkedList.partition(plist);
                    System.out.println("Partitioned List: " + partitioned);
                    break;

                case 4:
                    System.out.print("Enter capacity of Leaky Bucket: ");
                    int cap = sc.nextInt();
                    LeakyBucket lb = new LeakyBucket(cap);
                    while (true) {
                        System.out.println(
                                "1. Enqueue item\n2. Process k items\n3. Display bucket\n0. Back to main menu");
                        int sub = sc.nextInt();
                        if (sub == 0)
                            break;
                        switch (sub) {
                            case 1:
                                System.out.print("Enter item to enqueue: ");
                                lb.enqueue(sc.nextInt());
                                break;
                            case 2:
                                System.out.print("Enter k to process: ");
                                lb.process(sc.nextInt());
                                break;
                            case 3:
                                lb.display();
                                break;
                        }
                    }
                    break;

                case 5:
               Transpose2DLinkedList  tObj = new Transpose2DLinkedList();
                    LinkedList<LinkedList<Integer>> matrix = new LinkedList<>();
                    System.out.print("Enter number of rows: ");
                    int r = sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c = sc.nextInt();
                    for (int i = 0; i < r; i++) {
                        LinkedList<Integer> row = new LinkedList<>();
                        System.out.println("Enter elements for row " + (i + 1) + ":");
                        for (int j = 0; j < c; j++)
                            row.add(sc.nextInt());
                        matrix.add(row);
                    }
                    System.out.println("Original Matrix:");
                    tObj.printMatrix(matrix);
                    LinkedList<LinkedList<Integer>> transposed = tObj.transpose(matrix);
                    System.out.println("Transposed Matrix:");
                    tObj.printMatrix(transposed);
                    break;

                case 6:
                    System.out.print("Enter number of nodes: ");
                    int nNodes = sc.nextInt();
                    CollapsingCountList.Node head = null, tail = null;
                    for (int i = 0; i < nNodes; i++) {
                        System.out.print("Enter value and count for node " + (i + 1) + ": ");
                        int val = sc.nextInt(), cnt = sc.nextInt();
                        CollapsingCountList.Node node = new CollapsingCountList.Node(val, cnt);
                        if (head == null) {
                            head = tail = node;
                        } else {
                            tail.next = node;
                            tail = node;
                        }
                    }
                    System.out.println("Original list:");
                    CollapsingCountList.printList(head);
                    head = CollapsingCountList.collapse(head);
                    System.out.println("Collapsed list:");
                    CollapsingCountList.printList(head);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
