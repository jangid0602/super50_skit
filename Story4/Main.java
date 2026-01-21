package Oneup.Story5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.println("\nChoose option:");
                System.out.println("1. The Stair Case Architect");
                System.out.println("2. Check Palindrome using Recursion");
                System.out.println("3. Get Compressed String ");
                System.out.println("4. Rat And Maze ");
                System.out.println("5. Get Unique Code");
                System.out.println("8. Exit");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.println("Enter number of stairs:");
                        int stairs = Integer.parseInt(sc.nextLine());

                        TheStaircaseArchitect a =
                                new TheStaircaseArchitect();

                        System.out.println(
                                "Total number of ways: " +
                                a.getNumberofWays(stairs)
                        );
                        break;

                    case 2:
                        System.out.println("Enter String:");
                        String str = sc.nextLine();

                        MyString s1 = new MyString(str);

                        if (s1.IsPalindrome(str, 0, str.length() - 1))
                            System.out.println("It is a Palindrome String");
                        else
                            System.out.println("It is not a Palindrome String");
                        break;

                    case 3:
                        System.out.println("Enter String:");
                        str = sc.nextLine();
                    

                        MyString s2 = new MyString(str);
                        s2.GetComprasedString(str, 0, str.length() - 1);
                        System.out.println();
                        break;

                    case 4:
                        RatMaze r = new RatMaze();

                        System.out.print("Enter maze size N: ");
                        int n = sc.nextInt();
                        sc.nextLine();

                        int[][] maze = new int[n][n];

                        System.out.println("Enter maze values (0 or 1):");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                maze[i][j] = sc.nextInt();
                            }
                        }
                        sc.nextLine();
                        int size = maze.length;
                        boolean[][] visited = new boolean[n][n];
                        List<String> result = new ArrayList<>();

                        if (maze[0][0] == 1)
                            r.solve(maze, 0, 0, size, visited, "", result);

                        for (String s : result)
                            System.out.println(s);
                        break;

                    case 5:
                        System.out.print("Enter number of digits: ");
                        size = sc.nextInt();

                        int[] arr = new int[size];

                        System.out.println("Enter digits:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = sc.nextInt();
                        }

                        boolean[] used = new boolean[size];
                        UniqueCode u = new UniqueCode();

                        System.out.println(
                                "All possible codes (without repetition):"
                        );
                        u.generate(arr, used, "");
                        break;

                    case 6:
                        System.out.print("Enter number of elements: ");
                        int size1 = sc.nextInt();
                        sc.nextLine();

                        int[] array = new int[size1];

                        System.out.println("Enter elements:");
                        for (int i = 0; i < size1; i++) {
                            array[i] = sc.nextInt();
                            sc.nextLine();
                        }

                        System.out.print("Enter budget sum: ");
                        int budget = sc.nextInt();
                        sc.nextLine();

                        UniqueCode u2 = new UniqueCode();

                        System.out.println(
                                "Combinations that sum to budget:"
                        );
                        u2.findCombinations(
                                array, budget, 0, new ArrayList<>()
                        );
                        break;

                    case 8:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter vaid number");
            }

        } while (choice != 8);

        sc.close();
    }
}
