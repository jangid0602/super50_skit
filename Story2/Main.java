import java.util.*;

/**
 * @filename : Main.java
 * @description : Entry point for executing various operations defined in Operations.java.
 *                Provides an interactive, user-friendly menu with input validation.
 * @author : Aman Jeet Singh
 */

public class Main {

    /**
     * Safely reads an integer from user input.
     * Keeps prompting until a valid integer is entered.
     */
    public static int readInt(Scanner scanner, String prompt) {
        int number = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // consume newline
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a valid integer.\n");
                scanner.nextLine(); // clear invalid input
            }
        } while (!validInput);

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operations operations = new Operations();
        int choice;

        System.out.println("""
        ============================================
        Welcome to the Operations Utility Program!
        This tool allows you to perform various tasks
        such as analyzing strings, working with arrays,
        compacting logs, and more.
        --------------------------------------------
        Follow on-screen instructions carefully.
        ============================================
        """);

        do {
            System.out.println("""
            ============ MAIN MENU ============
            1. Encoded String Subset
            2. Trendsetter Score (Sliding Window)
            3. Max Pairs (Sum equals K)
            4. Longest Balanced Subarray (1s vs 2s)
            5. Compact Logs (word repetition)
            6. Redact Message (hide banned words)
            7. Normalize SKU
            8. Calculate Resume Similarity
            9. Replace Substring (non-overlapping)
            10. Most Frequent Two-Step Path
            0. Exit
            =====================================
            """);

            choice = readInt(scanner, "Enter your choice (0–10): ");
            System.out.println(); // line spacing

            switch (choice) {

                case 1 -> {
                    System.out.println("→ Encoded String Subset Checker");
                    System.out.print("Enter main string: ");
                    String mainString = scanner.nextLine();
                    System.out.print("Enter subset string: ");
                    String subString = scanner.nextLine();
                    System.out.println("Result: " + operations.encodedStringSubsets(mainString, subString));
                }

                case 2 -> {
                    System.out.println("→ Trendsetter Score (Unique Frequency Check)");
                    int numPosts = readInt(scanner, "Enter number of posts: ");
                    int[] postArray = new int[numPosts];

                    for (int i = 0; i < numPosts; i++) {
                        postArray[i] = readInt(scanner, "Enter post ID " + (i + 1) + ": ");
                    }

                    int windowSize = readInt(scanner, "Enter window size (k): ");
                    System.out.println("Trendsetter Score: " + operations.trendsetterScore(postArray, windowSize));
                }

                case 3 -> {
                    System.out.println("→ Find Maximum Pairs with Target Sum");
                    int arrayLength = readInt(scanner, "Enter array length: ");
                    int[] numbers = new int[arrayLength];

                    for (int i = 0; i < arrayLength; i++) {
                        numbers[i] = readInt(scanner, "Enter number " + (i + 1) + ": ");
                    }

                    int targetSum = readInt(scanner, "Enter target sum (k): ");
                    System.out.println("Maximum Pairs: " + operations.maxPairs(numbers, targetSum));
                }

                case 4 -> {
                    System.out.println("→ Longest Balanced Subarray Finder");
                    int totalElements = readInt(scanner, "Enter number of elements: ");
                    int[] elements = new int[totalElements];

                    System.out.println("Use 1 for RED and 2 for BLUE (0 for neutral).");
                    for (int i = 0; i < totalElements; i++) {
                        elements[i] = readInt(scanner, "Enter element " + (i + 1) + ": ");
                    }

                    System.out.println("Longest Balanced Subarray Length: " + operations.longestBalanced(elements));
                }

                case 5 -> {
                    System.out.println("→ Compact Logs (Count Consecutive Duplicates)");
                    System.out.print("Enter log string (space-separated): ");
                    String logString = scanner.nextLine();
                    System.out.println("Compacted Log Output: " + operations.compactLogs(logString));
                }

                case 6 -> {
                    System.out.println("→ Redact Banned Words in a Message");
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();

                    int numBanned = readInt(scanner, "Enter number of banned words: ");
                    String[] bannedWords = new String[numBanned];

                    for (int i = 0; i < numBanned; i++) {
                        System.out.print("Enter banned word " + (i + 1) + ": ");
                        bannedWords[i] = scanner.nextLine();
                    }

                    System.out.println("Redacted Message: " + operations.redactMessage(message, bannedWords));
                }

                case 7 -> {
                    System.out.println("→ Normalize SKU (Format: ABC-1234-M)");
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();
                    System.out.println("Normalized SKU: " + operations.normalizeSKU(sku));
                }

                case 8 -> {
                    System.out.println("→ Resume Similarity Calculator");
                    int resume1Size = readInt(scanner, "Enter number of words in Resume 1: ");
                    String[] resume1 = new String[resume1Size];

                    for (int i = 0; i < resume1Size; i++) {
                        System.out.print("Enter word " + (i + 1) + ": ");
                        resume1[i] = scanner.nextLine();
                    }

                    int resume2Size = readInt(scanner, "Enter number of words in Resume 2: ");
                    String[] resume2 = new String[resume2Size];

                    for (int i = 0; i < resume2Size; i++) {
                        System.out.print("Enter word " + (i + 1) + ": ");
                        resume2[i] = scanner.nextLine();
                    }

                    System.out.println("Similarity Score: " + operations.calculateSimilarity(resume1, resume2));
                }

                case 9 -> {
                    System.out.println("→ Replace Substring (Non-overlapping)");
                    System.out.print("Enter original text: ");
                    String originalText = scanner.nextLine();
                    System.out.print("Enter substring to find: ");
                    String target = scanner.nextLine();
                    System.out.print("Enter replacement string: ");
                    String replacement = scanner.nextLine();
                    System.out.println("Updated Text: " + operations.replace(originalText, target, replacement));
                }

                case 10 -> {
                    System.out.println("→ Most Frequent Two-Step Path");
                    int numActions = readInt(scanner, "Enter number of user actions: ");
                    String[] actions = new String[numActions];

                    for (int i = 0; i < numActions; i++) {
                        System.out.print("Enter action " + (i + 1) + " (format: userID,pageID): ");
                        actions[i] = scanner.nextLine();
                    }

                    System.out.println("Most Frequent Two-Step Path: " + Operations.mostFrequent2StepPath(actions));
                }

                case 0 -> System.out.println("Exiting program... Goodbye!");

                default -> System.out.println("Invalid choice! Please select an option between 0–10.\n");
            }

            System.out.println("\n----------------------------------------\n");

        } while (choice != 0);

        scanner.close();
    }
}
