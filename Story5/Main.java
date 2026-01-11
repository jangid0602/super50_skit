
package Story5;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Story 5");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Recursion on Numbers - Find Key");
            System.out.println("2. Recursion on Numbers - Fibonacci Sum");
            System.out.println("3. Recursion on Numbers - Calculate Legacy");
            System.out.println("4. Recursion on Strings - Check Palindrome");
            System.out.println("5. Backtracking on Strings - Generate Subset");
            System.out.println("6. Recursion on Numbers - Calculate Sum");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");

                    if (sc.hasNextInt()) {
                        int number = sc.nextInt();
                        if (number < 0) {
                            System.out.println("Please enter a non-negative number.");
                            break;
                        } else if (number > 1000) {
                            System.out.println("Number too large, may cause stack overflow.");
                            break;
                        }
                        RecursionOnNumbers object1 = new RecursionOnNumbers();
                        System.out.println("Find Key Result: " + object1.findKey(number));
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); // clear invalid input
                        break;
                    }

                case 2:
                    System.out.print("Enter a number: ");
                    if (sc.hasNextInt()) {
                        int num = sc.nextInt();
                        RecursionOnNumbers object2 = new RecursionOnNumbers();
                        System.out.println("Fibonacci Sum: " + object2.fibonaaciSum(num));
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); // clear invalid input
                        break;
                    }
                case 3:
                    System.out.print("Enter number of nodes: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next();
                        break;
                    }

                    int n = sc.nextInt();

                    if (n <= 0) {
                        System.out.println("Tree must have at least 1 node.");
                        break;
                    }

                    System.out.println("Enter node values level-wise (-1 for null):");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid root value.");
                        sc.next();
                        break;
                    }

                    int rootVal = sc.nextInt();
                    if (rootVal == -1) {
                        System.out.println("Root cannot be null.");
                        break;
                    }

                    TreeNode root = new TreeNode(rootVal);
                    LinkedList<TreeNode> queue = new LinkedList<>();
                    queue.add(root);

                    int count = 1;

                    while (!queue.isEmpty() && count < n) {
                        TreeNode curr = queue.poll();

                        // LEFT child
                        if (count < n) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Expected integer.");
                                sc.next();
                                break;
                            }
                            int leftVal = sc.nextInt();
                            if (leftVal != -1) {
                                curr.left = new TreeNode(leftVal);
                                queue.add(curr.left);
                            }
                            count++;
                        }

                        // RIGHT child
                        if (count < n) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid input. Expected integer.");
                                sc.next();
                                break;
                            }
                            int rightVal = sc.nextInt();
                            if (rightVal != -1) {
                                curr.right = new TreeNode(rightVal);
                                queue.add(curr.right);
                            }
                            count++;
                        }
                    }

                    RecursionOnNumbers obj3 = new RecursionOnNumbers();
                    System.out.println("Legacy Sum = " + obj3.calculatelegacy(root));
                    break;
                case 4:
                    System.out.print("Enter a string: ");
                    String string = sc.next();
                    RecursionOnStrings object3 = new RecursionOnStrings();
                    System.out.println("Is Palindrome: " + object3.isPalindrome(string));
                    break;
                case 5:
                    System.out.print("Enter number of teams: ");
                    int t = sc.nextInt();
                    LinkedList<String> teams = new LinkedList<>();
                    System.out.println("Enter team names:");
                    for (int i = 0; i < t; i++) {
                        teams.add(sc.next());
                    }
                    BacktrackingOnStrings obj4 = new BacktrackingOnStrings();
                    System.out.println("Generated Subsets: " + obj4.generateSubset(teams));
                    break;
                case 6:
                    System.out.print("Enter number of strings: ");
                    int s = sc.nextInt();
                    String[] characters = new String[s];
                    System.out.println("Enter strings:");
                    for (int i = 0; i < s; i++) {
                        characters[i] = sc.next();
                    }
                    RecursionOnNumbers obj6 = new RecursionOnNumbers();
                    System.out.println("Calculated Sum: " + obj6.compressString(characters));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
            }

        }
    }
}
