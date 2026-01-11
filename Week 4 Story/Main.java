// @filename - Main.java
// @description - Menu-driven program for recursion & backtracking Week 4 Story
// @author - Divyansh Tak

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- WEEK 4 ASSIGNMENT ---");
                System.out.println("1. Russian Doll Mystery");
                System.out.println("2. Staircase Architect");
                System.out.println("3. Digital Ancestry Tree");
                System.out.println("4. Word Mirror");
                System.out.println("5. Maze Runner");
                System.out.println("6. Perfect Team Assembly");
                System.out.println("7. Secure Vault Code");
                System.out.println("8. String Tiling Challenge");
                System.out.println("9. Budget Calculator");
                System.out.println("10. Project Builder Blueprint");
                System.out.println("11. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.print("Enter doll size: ");
                        int size = sc.nextInt();
                        System.out.println(Method.findKey(size) ? "Key Found!" : "Key Not Found");
                        break;

                    case 2:
                        System.out.print("Enter steps: ");
                        int n = sc.nextInt();
                        System.out.println("Ways = " + Method.countWays(n));
                        break;

                    case 3:
                        System.out.print("Enter wealth: ");
                        int wealth = sc.nextInt();
                        System.out.print("Enter number of children: ");
                        int c = sc.nextInt();
                        int children[] = new int[c];
                        for (int i = 0; i < c; i++)
                            children[i] = sc.nextInt();
                        System.out.println("Total Legacy = " +
                                Method.calculateLegacy(wealth, children, 0));
                        break;

                    case 4:
                        sc.nextLine();
                        System.out.print("Enter word: ");
                        String word = sc.nextLine();
                        System.out.println(Method.isPalindrome(word, 0, word.length() - 1));
                        break;

                    case 5:
                        System.out.print("Enter maze size: ");
                        int m = sc.nextInt();
                        int maze[][] = new int[m][m];
                        for (int i = 0; i < m; i++)
                            for (int j = 0; j < m; j++)
                                maze[i][j] = sc.nextInt();
                        System.out.println(Method.pathExists(maze, 0, 0));
                        break;

                    case 6:
                        System.out.print("Enter number of developers: ");
                        int d = sc.nextInt();
                        sc.nextLine();
                        String devs[] = new String[d];
                        for (int i = 0; i < d; i++)
                            devs[i] = sc.nextLine();

                        ArrayList<ArrayList<String>> subsets = new ArrayList<>();
                        Method.generateSubsets(devs, 0, new ArrayList<>(), subsets);
                        System.out.println(subsets);
                        break;

                    case 7:
                        System.out.print("Enter number of digits: ");
                        int digitLength = sc.nextInt();

                        int arr[] = new int[digitLength];
                        for (int i = 0; i < digitLength; i++) {
                          arr[i] = sc.nextInt();
                        }

                       ArrayList<String> result = new ArrayList<>();
                       Method.generatePermutations(arr, new boolean[digitLength], new StringBuilder(), result);
                       System.out.println(result);
                       break;

                    case 8:
                        sc.nextLine();
                        System.out.print("Enter string: ");
                        String s = sc.nextLine();
                        System.out.println(Method.compressString(s, 0));
                        break;

                    case 9:
                        System.out.print("Enter number of items: ");
                        int it = sc.nextInt();
                        int price[] = new int[it];
                        for (int i = 0; i < it; i++)
                            price[i] = sc.nextInt();
                        System.out.print("Enter budget: ");
                        int b = sc.nextInt();

                        ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
                        Method.combinationSum(price, b, 0, new ArrayList<>(), combos);
                        System.out.println(combos);
                        break;

                    case 10:
                        sc.nextLine();
                        System.out.print("Enter number of tasks: ");
                        int t = sc.nextInt();
                        sc.nextLine();
                        String tasks[] = new String[t];
                        for (int i = 0; i < t; i++)
                            tasks[i] = sc.nextLine();
                          
                        System.out.println("Tasks to do : ");
                        System.out.println("");

                        Method.printTasks(tasks, 0, 0);
                        break;

                    case 11:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}
