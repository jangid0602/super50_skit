import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        while (true) {
            System.out.println("\nChoose problem to run (1-10) or 0 to exit:");
            System.out.println("1. The Trendsetter Score");
            System.out.println("2. Encoded String Subsets (permutation exists)");
            System.out.println("3. E-Commerce Funnel Analysis (most frequent 2-step path)");
            System.out.println("4. Maximal Pair Matching (max pairs sum to k)");
            System.out.println("5. Subarray Color Balance (longest with equal 1 and 2)");
            System.out.println("6. Text Editor Non-Overlapping Replace");
            System.out.println("7. Log File Compaction (run-length encoding)");
            System.out.println("8. E-commerce SKU Normalization");
            System.out.println("9. Chat Message Redaction");
            System.out.println("10. Resume Keyword Versioning (similarity score)");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Exiting.");
                break;
            }

            switch (choice) {
                case 1:
                    // Trendsetter Score
                    System.out.println("Enter posts as space-separated integers (e.g. 1 2 1 3 2 1):");
                    String[] postsTokens = scanner.nextLine().trim().split("\\s+");
                    List<Integer> postsList = new ArrayList<>();
                    for (String t : postsTokens) if (!t.isEmpty()) postsList.add(Integer.parseInt(t));
                    System.out.print("Enter window size k: ");
                    int k = Integer.parseInt(scanner.nextLine().trim());
                    int trendScore = solution.trendsetterScore(postsList, k);
                    System.out.println("Trendsetter Score: " + trendScore);
                    break;
                case 2:
                    // Encoded String Subsets
                    System.out.print("Enter superstring: ");
                    String superstring = scanner.nextLine();
                    System.out.print("Enter substring: ");
                    String substring = scanner.nextLine();
                    boolean permutationExists = solution.encodedStringSubsets(superstring, substring);
                    System.out.println("Permutation exists: " + permutationExists);
                    break;
                case 3:
                    // E-Commerce Funnel Analysis
                    System.out.println("Enter actions (comma separated within quotes) one per line.");
                    System.out.println("First enter number of actions:");
                    int nActions = Integer.parseInt(scanner.nextLine().trim());
                    List<String> actions = new ArrayList<>();
                    System.out.println("Now enter each action as userID,pageID (without extra spaces):");
                    for (int i = 0; i < nActions; i++) {
                        actions.add(scanner.nextLine().trim());
                    }
                    String mostFrequentPath = solution.eCommerceFunnelMostFrequentPath(actions);
                    System.out.println("Most frequent 2-step path: " + mostFrequentPath);
                    break;
                case 4:
                    // Maximal Pair Matching
                    System.out.println("Enter nums as space-separated integers:");
                    String[] numsTokens = scanner.nextLine().trim().split("\\s+");
                    List<Integer> numsList = new ArrayList<>();
                    for (String t : numsTokens) if (!t.isEmpty()) numsList.add(Integer.parseInt(t));
                    System.out.print("Enter target sum k: ");
                    int targetK = Integer.parseInt(scanner.nextLine().trim());
                    int maxPairs = solution.maximalPairMatching(numsList, targetK);
                    System.out.println("Maximum pairs: " + maxPairs);
                    break;
                case 5:
                    // Subarray Color Balance
                    System.out.println("Enter nums as space-separated values (0,1,2):");
                    String[] colorTokens = scanner.nextLine().trim().split("\\s+");
                    List<Integer> colorList = new ArrayList<>();
                    for (String t : colorTokens) if (!t.isEmpty()) colorList.add(Integer.parseInt(t));
                    int longestBalancedLen = solution.subarrayColorBalance(colorList);
                    System.out.println("Longest balanced subarray length: " + longestBalancedLen);
                    break;
                case 6:
                    // Non-overlapping replace
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter find_str: ");
                    String findStr = scanner.nextLine();
                    System.out.print("Enter replace_str: ");
                    String replaceStr = scanner.nextLine();
                    String replaced = solution.nonOverlappingReplace(text, findStr, replaceStr);
                    System.out.println("Replaced text: " + replaced);
                    break;
                case 7:
                    // Log file compaction
                    System.out.print("Enter logs as space-separated tokens (e.g. INFO INFO WARN): ");
                    String logsLine = scanner.nextLine();
                    String compacted = solution.logFileCompaction(logsLine);
                    System.out.println("Compacted logs: " + compacted);
                    break;
                case 8:
                    // SKU Normalization
                    System.out.print("Enter sku string: ");
                    String sku = scanner.nextLine();
                    String normalized = solution.skuNormalizer(sku);
                    System.out.println("Normalized: " + normalized);
                    break;
                case 9:
                    // Chat Redaction
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();
                    System.out.print("Enter number of banned words: ");
                    int bannedCount = Integer.parseInt(scanner.nextLine().trim());
                    List<String> bannedWords = new ArrayList<>();
                    System.out.println("Enter banned words one per line:");
                    for (int i = 0; i < bannedCount; i++) bannedWords.add(scanner.nextLine());
                    String redacted = solution.chatMessageRedaction(message, bannedWords);
                    System.out.println("Redacted message: " + redacted);
                    break;
                case 10:
                    // Resume Keyword Versioning
                    System.out.print("Enter number of words in resumeV1: ");
                    int v1count = Integer.parseInt(scanner.nextLine().trim());
                    List<String> resumeV1 = new ArrayList<>();
                    System.out.println("Enter resumeV1 words one per line:");
                    for (int i = 0; i < v1count; i++) resumeV1.add(scanner.nextLine());
                    System.out.print("Enter number of words in resumeV2: ");
                    int v2count = Integer.parseInt(scanner.nextLine().trim());
                    List<String> resumeV2 = new ArrayList<>();
                    System.out.println("Enter resumeV2 words one per line:");
                    for (int i = 0; i < v2count; i++) resumeV2.add(scanner.nextLine());
                    int similarityScore = solution.resumeKeywordSimilarityScore(resumeV1, resumeV2);
                    System.out.println("Similarity score: " + similarityScore);
                    break;
                default:
                    System.out.println("Invalid choice. Pick 1-10.");
            }
        }

        scanner.close();
    }
}
