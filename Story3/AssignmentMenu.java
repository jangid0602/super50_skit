package Story3;

import java.util.*;

public class AssignmentMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        
        do {
            System.out.println("===== Week 3 Assignment Menu =====");
            System.out.println("1. O(1) Average Stack");
            System.out.println("2. Python Indentation Validator");
            System.out.println("3. 2D Linked List Transpose");
            System.out.println("4. K-Zipline Merge");
            System.out.println("5. Prime/Composite List Partition");
            System.out.println("6. Leaky Bucket Queue");
            System.out.println("7. Collapsing Count List");
            System.out.println("8. Zigzag Multi-Level Flatten");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    AssignmentSolutions.runAverageStackDemo();
                    break;
                case 2:
                    AssignmentSolutions.runIndentationValidatorDemo();
                    break;
                case 3:
                    AssignmentSolutions.runTransposeDemo();
                    break;
                case 4:
                    AssignmentSolutions.runKZiplineMergeDemo();
                    break;
                case 5:
                    AssignmentSolutions.runPartitionPrimesDemo();
                    break;
                case 6:
                    AssignmentSolutions.runLeakyBucketDemo();
                    break;
                case 7:
                    AssignmentSolutions.runCollapseDemo();
                    break;
                case 8:
                    AssignmentSolutions.runFlattenZigzagDemo();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 9);

        scanner.close();
    }
}

