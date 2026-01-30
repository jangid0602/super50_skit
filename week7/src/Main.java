import datastructure.TreeNode;
import util.CustomScanner;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class which implements Menu driven user input based simulation of problems of week 7 stories
 *
 * @author Bhavya Jain
 * @date 27 Jan 2026
 */
public class Main {
    public static void main(String[] args) {
        try {
            CustomScanner scanner = new CustomScanner(new InputStreamReader(System.in));
            ProblemSolver solver = new ProblemSolver();

            while (true) {
                System.out.println("\n===Dynamic Programming Problems Menu===");
                System.out.println("1.  Startup Revenue Maxima");
                System.out.println("2.  Codeup Mentorship Matching");
                System.out.println("3.  The Minimal Tech-Stack Swap");
                System.out.println("4.  Placement Marathon");
                System.out.println("5.  The Optimal Server Latency");
                System.out.println("6.  The Codeup Show: Ad Placement");
                System.out.println("7.  The Binary Tree Audit");
                System.out.println("8.  Jaipur Tech-Hub Routes");
                System.out.println("9.  The Circular Office Security");
                System.out.println("10. The Palindromic Deployment");
                System.out.println("0.  Exit.");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Exiting...");
                    break;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter number of days: ");
                        int noOfDays = scanner.nextInt();
                        System.out.println("Enter revenue for " + noOfDays + " days:");
                        int[] revenue = scanner.readIntArray(noOfDays);
                        int result = solver.getMaximumRevenue(noOfDays, revenue);
                        System.out.println("Maximum revenue possible is " + result);
                    }
                    case 2 -> {
                        System.out.print("Enter number of students/mentors (n): ");
                        int n = scanner.nextInt();
                        System.out.println("Enter compatibility score matrix (n x n)");
                        int[][] matrix = scanner.readIntMatrix(n, n);
                        int result = solver.getMaximumCompatibilityScore(n, matrix);
                        System.out.println("The maximum achievable compatibility score is " + result);
                    }
                    case 7 -> {
                        System.out.println("Enter Binary Tree (Level Order):");
                        System.out.println("(Press Ctrl+D(Win) or Ctrl+Z(Mac/Linux) to submit)");
                        TreeNode root = scanner.readTree();
                        int result = solver.getMaxEfficiency(root);
                        System.out.println("Maximum efficiency achievable is " + result);
                    }
                    case 8 -> {
                        System.out.print("Enter left and right bounds: ");
                        long left = scanner.nextLong();
                        long right = scanner.nextLong();
                        long result = solver.countPrimes(left,right);
                        System.out.println("Count of numbers matching the criteria are " + result);
                    }
                    case 9 -> {
                        System.out.print("Enter number of cabins: ");
                        int n = scanner.nextInt();
                        System.out.println("Enter value of each cabin: ");
                        int[] cabins = scanner.readIntArray(n);
                        int result = solver.getMaxAuditAmount(cabins);
                        System.out.println("The maximum audited value possible is " + result);
                    }
                    case 3, 4, 5, 6, 10 -> System.out.println("To be implemented...");
                    default -> System.out.println("Invalid Choice!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
