import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        HashmapAndStringProblems obj = new HashmapAndStringProblems();

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Trendsetter Score (Sliding Window)");
            System.out.println("2. Substring Permutation Check");
            System.out.println("3. Most Frequent 2-Step Path");
            System.out.println("4. Max Number of Pairs");
            System.out.println("5. Longest Color Balanced Subarray");
            System.out.println("6. Non-Overlapping Replace");
            System.out.println("7. Compact Logs");
            System.out.println("8. Normalize SKU");
            System.out.println("9. Redact Message");
            System.out.println("10. Resume Similarity Score");
            System.out.println("11. Exit");
            System.out.print("Enter your choice (1–11): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Exiting...");
                break;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter number of posts: ");
                    int n1 = sc.nextInt();
                    int posts[] = new int[n1];
                    System.out.println("Enter post IDs:");
                    for (int i = 0; i < n1; i++)
                        posts[i] = sc.nextInt();
                    System.out.print("Enter window size k: ");
                    int k = sc.nextInt();
                    System.out.println("Trendsetter Score: " + obj.trendScore(posts, k));
                    break;

                case 2:
                    System.out.print("Enter superstring: ");
                    String superString = sc.nextLine();
                    System.out.print("Enter substring: ");
                    String subString = sc.nextLine();
                    System.out.println("Permutation exists? " + obj.isSubstring(superString, subString));
                    break;

                case 3:
                    System.out.print("Enter number of user actions: ");
                    int n2 = sc.nextInt();
                    sc.nextLine();
                    String actions[] = new String[n2];
                    System.out.println("Enter actions (userID,pageID):");
                    for (int i = 0; i < n2; i++)
                        actions[i] = sc.nextLine();
                    System.out.println("Most frequent 2-step path: " + obj.mostFrequent2StepPath(actions));
                    break;

                case 4:
                    System.out.print("Enter array size: ");
                    int n3 = sc.nextInt();
                    int nums[] = new int[n3];
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n3; i++)
                        nums[i] = sc.nextInt();
                    System.out.print("Enter target sum k: ");
                    int k4 = sc.nextInt();
                    System.out.println("Max number of pairs: " + obj.maxNumberOfPairs(nums, k4));
                    break;

                case 5:
                    System.out.print("Enter array size: ");
                    int n5 = sc.nextInt();
                    int colors[] = new int[n5];
                    System.out.println("Enter elements (0=neutral, 1=red, 2=blue):");
                    for (int i = 0; i < n5; i++)
                        colors[i] = sc.nextInt();
                    System.out.println("Longest balanced subarray length: " + obj.longestColorBalancedSubarray(colors));
                    break;

                case 6:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    System.out.print("Enter find string: ");
                    String find = sc.nextLine();
                    System.out.print("Enter replace string: ");
                    String replace = sc.nextLine();
                    System.out.println("After replacement: " + obj.nonOverlappingReplace(text, find, replace));
                    break;

                case 7:
                    System.out.print("Enter log string (space-separated): ");
                    String logs = sc.nextLine();
                    System.out.println("Compacted logs: " + obj.compactLogs(logs));
                    break;

                case 8:
                    System.out.print("Enter SKU: ");
                    String sku = sc.nextLine();
                    System.out.println("Normalized SKU: " + obj.normalizeSKU(sku));
                    break;

                case 9:
                    System.out.print("Enter message: ");
                    String message = sc.nextLine();
                    System.out.print("Enter number of banned words: ");
                    int n9 = sc.nextInt();
                    sc.nextLine();
                    List<String> banned = new ArrayList<>();
                    System.out.println("Enter banned words:");
                    for (int i = 0; i < n9; i++)
                        banned.add(sc.nextLine());
                    System.out.println("Redacted message: " + obj.redactMessage(message, banned));
                    break;

                case 10:
                    System.out.print("Enter number of words in Resume V1: ");
                    int n10a = sc.nextInt();
                    sc.nextLine();
                    String resumeV1[] = new String[n10a];
                    System.out.println("Enter words for Resume V1:");
                    for (int i = 0; i < n10a; i++)
                        resumeV1[i] = sc.nextLine();

                    System.out.print("Enter number of words in Resume V2: ");
                    int n10b = sc.nextInt();
                    sc.nextLine();
                    String resumeV2[] = new String[n10b];
                    System.out.println("Enter words for Resume V2:");
                    for (int i = 0; i < n10b; i++)
                        resumeV2[i] = sc.nextLine();

                    System.out.println("Similarity Score: " + obj.resumeSimilarityScore(resumeV1, resumeV2));
                    break;

                case 11:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
