import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

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

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Exiting...");
                break;
            }

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter number of posts: ");
                        String n1 = input.nextLine();
                        int postCount = Integer.parseInt(n1);
                        int posts[] = new int[postCount];

                        System.out.println("Enter post IDs:");
                        for (int i = 0; i < postCount; i++)
                            posts[i] = input.nextInt();
                        System.out.print("Enter window size k: ");
                        int k = input.nextInt();

                        System.out.println("Trendsetter Score: " + obj.getTrendScore(posts, k));
                    } catch (Exception e) {
                        System.out.println("Error in Trendsetter Score: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter superstring: ");
                        String superString = input.nextLine();
                        System.out.print("Enter substring: ");
                        String subString = input.nextLine();

                        if (superString == null || subString == null)
                            throw new NullPointerException("Input strings cannot be null.");

                        System.out.println("Permutation exists? " + obj.isSubstring(superString, subString));
                    } catch (Exception e) {
                        System.out.println("Error in Substring Permutation Check: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter number of user actions: ");
                        int n2 = input.nextInt();
                        input.nextLine();
                        String actions[] = new String[n2];

                        System.out.println("Enter actions (userID,pageID):");
                        for (int i = 0; i < n2; i++)
                            actions[i] = input.nextLine();

                        System.out.println("Most frequent 2-step path: " + obj.mostFrequent2StepPath(actions));
                    } catch (Exception e) {
                        System.out.println("Error in Most Frequent 2-Step Path: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter array size: ");
                        int n3 = input.nextInt();
                        int nums[] = new int[n3];
                        System.out.println("Enter elements:");
                        for (int i = 0; i < n3; i++)
                            nums[i] = input.nextInt();

                        System.out.print("Enter target sum k: ");
                        int k4 = input.nextInt();

                        System.out.println("Max number of pairs: " + obj.getMaxNumberOfPairs(nums, k4));
                    } catch (Exception e) {
                        System.out.println("Error in Max Number of Pairs: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter array size: ");
                        int n5 = input.nextInt();
                        int colors[] = new int[n5];
                        System.out.println("Enter elements (0=neutral, 1=red, 2=blue):");
                        for (int i = 0; i < n5; i++)
                            colors[i] = input.nextInt();

                        System.out.println("Longest balanced subarray length: " + obj.getLongestColorBalancedSubarray(colors));
                    } catch (Exception e) {
                        System.out.println("Error in Longest Color Balanced Subarray: " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter text: ");
                        String text = input.nextLine();
                        System.out.print("Enter find string: ");
                        String find = input.nextLine();
                        System.out.print("Enter replace string: ");
                        String replace = input.nextLine();

                        System.out.println("After replacement: " + obj.nonOverlappingReplace(text, find, replace));
                    } catch (Exception e) {
                        System.out.println("Error in Non-Overlapping Replace: " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Enter log string (space-separated): ");
                        String logs = input.nextLine();
                        System.out.println("Compacted logs: " + obj.compactLogs(logs));
                    } catch (Exception e) {
                        System.out.println("Error in Compact Logs: " + e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.print("Enter SKU: ");
                        String sku = input.nextLine();
                        System.out.println("Normalized SKU: " + obj.normalizeSKU(sku));
                    } catch (Exception e) {
                        System.out.println("Error in Normalize SKU: " + e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.print("Enter message: ");
                        String message = input.nextLine();
                        System.out.print("Enter number of banned words: ");
                        int n9 = input.nextInt();
                        input.nextLine();

                        List<String> banned = new ArrayList<>();
                        System.out.println("Enter banned words:");
                        for (int i = 0; i < n9; i++)
                            banned.add(input.nextLine());

                        System.out.println("Redacted message: " + obj.redactMessage(message, banned));
                    } catch (Exception e) {
                        System.out.println("Error in Redact Message: " + e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        System.out.print("Enter number of words in Resume V1: ");
                        int n10a = input.nextInt();
                        input.nextLine();
                        String resumeV1[] = new String[n10a];
                        System.out.println("Enter words for Resume V1:");
                        for (int i = 0; i < n10a; i++)
                            resumeV1[i] = input.nextLine();

                        System.out.print("Enter number of words in Resume V2: ");
                        int n10b = input.nextInt();
                        input.nextLine();
                        String resumeV2[] = new String[n10b];
                        System.out.println("Enter words for Resume V2:");
                        for (int i = 0; i < n10b; i++)
                            resumeV2[i] = input.nextLine();

                        System.out.println("Similarity Score: " + obj.getResumeSimilarityScore(resumeV1, resumeV2));
                    } catch (Exception e) {
                        System.out.println("Error in Resume Similarity Score: " + e.getMessage());
                    }
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
