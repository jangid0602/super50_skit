// @filename - Main.java
// @description - Menu-driven Java program that executes multiple array, string, and hashmap-based operations using methods from Method.java for the given assignment problems (Week 2 Story).
// @author - Divyansh Tak

import java.util.*;

public class Main {

    
    static void getArray(int arr[], int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    arr[i] = sc.nextInt();
                    break; // valid input
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer value.");
                    sc.nextLine(); // clear invalid input
                }
            }
        }
    }

    
    static void getStringArray(String arr[], int n, Scanner sc) {
        sc.nextLine(); // clear buffer
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter string " + (i + 1) + ": ");
                    arr[i] = sc.nextLine();
                    if (arr[i].trim().isEmpty()) {
                        throw new Exception("String cannot be empty!");
                    }
                    break; // valid string entered
                } catch (Exception e) {
                    System.out.println("Invalid input! " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            try {
                System.out.println("\n--- WEEK 2 ASSIGNMENT ---");
                System.out.println("1. The Trendsetter Score");
                System.out.println("2. Encoded String Subsets");
                System.out.println("3. E-Commerce Funnel Analysis");
                System.out.println("4. Maximal Pair Matching");
                System.out.println("5. Subarray Color Balance");
                System.out.println("6. Text Editor Non-Overlapping Replace");
                System.out.println("7. Log File Compaction");
                System.out.println("8. E-commerce SKU Normalization");
                System.out.println("9. Chat Message Redaction");
                System.out.println("10. Resume Keyword Versioning");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");
                ch = sc.nextInt();

                switch (ch) {

                    //Trendsetter Score
                    case 1:
                        System.out.print("Enter array size: ");
                        int n1 = sc.nextInt();
                        int posts[] = new int[n1];
                        getArray(posts, n1, sc);
                        System.out.print("Enter window size k: ");
                        int k = sc.nextInt();
                        System.out.println("Trendsetter Score = " + Methods.trendsetterScore(posts, k));
                        break;

                    //Encoded String Subsets
                    case 2:
                        sc.nextLine();
                        System.out.print("Enter superstring: ");
                        String s1 = sc.nextLine();
                        System.out.print("Enter substring: ");
                        String s2 = sc.nextLine();
                        System.out.println("Contains permutation? " + Methods.encodedStringSubset(s1, s2));
                        break;

                    //E-Commerce Funnel Analysis
                    case 3:
                        System.out.print("Enter number of actions: ");
                        int n3 = sc.nextInt();
                        String actions[] = new String[n3];
                        getStringArray(actions, n3, sc);
                        System.out.println("Most frequent path: " + Methods.funnelAnalysis(actions));
                        break;

                    //Maximal Pair Matching
                    case 4:
                        System.out.print("Enter size of array: ");
                        int n4 = sc.nextInt();
                        int nums4[] = new int[n4];
                        getArray(nums4, n4, sc);
                        System.out.print("Enter target sum k: ");
                        int target = sc.nextInt();
                        System.out.println("Maximum pairs = " + Methods.maximalPairMatching(nums4, target));
                        break;

                    //Subarray Color Balance
                    case 5:
                        System.out.print("Enter size of array: ");
                        int n5 = sc.nextInt();
                        int nums5[] = new int[n5];
                        getArray(nums5, n5, sc);
                        System.out.println("Longest balanced subarray = " + Methods.subarrayColorBalance(nums5));
                        break;

                    //Text Editor Replace
                    case 6:
                        sc.nextLine();
                        System.out.print("Enter text: ");
                        String text = sc.nextLine();
                        System.out.print("Enter find string: ");
                        String find = sc.nextLine();
                        System.out.print("Enter replace string: ");
                        String rep = sc.nextLine();
                        System.out.println("Output = " + Methods.textEditorReplace(text, find, rep));
                        break;

                    //Log File Compaction
                    case 7:
                        sc.nextLine();
                        System.out.print("Enter log string (space separated): ");
                        String logs = sc.nextLine();
                        System.out.println("Compacted log = " + Methods.logFileCompaction(logs));
                        break;

                    //SKU Normalizer
                    case 8:
                        sc.nextLine();
                        System.out.print("Enter SKU: ");
                        String sku = sc.nextLine();
                        System.out.println("Result = " + Methods.skuNormalizer(sku));
                        break;

                    //Chat Redaction
                    case 9:
                        sc.nextLine();
                        System.out.print("Enter message: ");
                        String msg = sc.nextLine();
                        System.out.print("Enter number of banned words: ");
                        int n9 = sc.nextInt();
                        String banned[] = new String[n9];
                        getStringArray(banned, n9, sc);
                        System.out.println("Redacted Message: " + Methods.chatRedaction(msg, banned));
                        break;

                    //Resume Keyword Versioning
                    case 10:
                        System.out.print("Enter number of words in Resume V1: ");
                        int n10 = sc.nextInt();
                        String r1[] = new String[n10];
                        getStringArray(r1, n10, sc);
                        System.out.print("Enter number of words in Resume V2: ");
                        int m10 = sc.nextInt();
                        String r2[] = new String[m10];
                        getStringArray(r2, m10, sc);
                        System.out.println("Similarity Score = " + Methods.resumeSimilarity(r1, r2));
                        break;

                    //Exit
                    case 11:
                        System.out.println("Exiting program...");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type! Please enter numbers where required.");
                sc.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
