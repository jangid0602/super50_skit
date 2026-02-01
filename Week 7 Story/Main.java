// @filename - Main.java
// @description - Menu-driven program for Week 7 Story DP problems
// @author - Divyansh Tak

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- WEEK 7 ASSIGNMENT ---");
                System.out.println("1. Startup Revenue Maxima");
                System.out.println("2. Minimal Tech-Stack Swap");
                System.out.println("3. Placement Marathon");
                System.out.println("4. Circular Office Security");
                System.out.println("5. Palindromic Deployment");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.print("Enter N: ");
                        int n = sc.nextInt();
                        int arr[] = new int[n];

                        for(int i = 0; i < n; i++){
                            arr[i] = sc.nextInt();
                        }

                        System.out.println("Max Revenue = " + Method.maxRevenue(arr, n));
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("Enter string 1: ");
                        String s1 = sc.nextLine();
                        System.out.print("Enter string 2: ");
                        String s2 = sc.nextLine();
                        System.out.print("Enter cost insert: ");
                        int costi = sc.nextInt();
                        System.out.print("Enter cost delete: ");
                        int costd = sc.nextInt();
                        System.out.print("Enter cost replace: ");
                        int costu = sc.nextInt();

                        System.out.println("Minimum Cost = " + Method.minEditCost(s1, s2, costi, costd, costu));
                        break;

                    case 3:
                        System.out.print("Enter N: ");
                        int n3 = sc.nextInt();
                        System.out.print("Enter K: ");
                        int K = sc.nextInt();

                        int arr1[] = new int[n3];

                        for(int i = 0; i < n3; i++){
                            arr1[i] = sc.nextInt();
                        }

                        System.out.println("Longest Length = " + Method.longestSubsequence(arr1, n3, K));
                        break;

                    case 4:
                        System.out.print("Enter N: ");
                        int n4 = sc.nextInt();
                        int arr2[] = new int[n4];

                        for(int i = 0; i < n4; i++){
                            arr2[i] = sc.nextInt();
                        }

                        System.out.println("Max Value = " + Method.maxCircularValue(arr2, n4));
                        break;

                    case 5:
                        sc.nextLine();
                        System.out.print("Enter string: ");
                        String s = sc.nextLine();

                        System.out.println("Min Insertions = " + Method.minInsertions(s));
                        break;

                    case 6:
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
