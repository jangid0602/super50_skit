import java.util.*;

/**
 * @filename - Main.java
 * @description - This is the entry point of program
 * @author - Arman Agrawal
 */


public class Main {

    public static int readInt(Scanner scanner, String prompt) {
        int number = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (!validInput);

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operations operation = new Operations();
        int choice;

        do {
            System.out.println("""
            ========= MAIN MENU =========
            1. Encoded String Subset
            2. Trendsetter Score
            3. Max Pairs
            4. Longest Balanced
            5. Compact Logs
            6. Redact Message
            7. Normalize SKU
            8. Calculate Resume Similarity
            9. Replace Substring
            10. Most Frequent two step path
            0. Exit""");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter main string: ");
                    String mainString = scanner.nextLine();
                    System.out.print("Enter subset string: ");
                    String subString = scanner.nextLine();
                    System.out.println("Result: " + operation.encodedStringSubsets(mainString, subString));
                }

                case 2 -> {
                    int numPosts = readInt(scanner, "Enter number of posts: ");
                    int[] postArray = new int[numPosts];

                    for (int i = 0; i < numPosts; i++) {
                        postArray[i] = readInt(scanner, "Enter post ID " + (i + 1) + ": ");
                    }

                    int windowSize = readInt(scanner, "Enter window size (k): ");
                    System.out.println("Trendsetter Score: " + operation.trendsetterScore(postArray, windowSize));
                }

                case 3 -> {
                    int arrayLength = readInt(scanner, "Enter array length: ");
                    int[] numberArray = new int[arrayLength];

                    for (int i = 0; i < arrayLength; i++) {
                        numberArray[i] = readInt(scanner, "Enter number " + (i + 1) + ": ");
                    }

                    int targetSum = readInt(scanner, "Enter target sum (k): ");
                    System.out.println("Maximum Pairs: " + operation.maxPairs(numberArray, targetSum));
                }

                case 4 -> {
                    int totalElements = readInt(scanner, "Enter number of elements: ");
                    int[] elementArray = new int[totalElements];

                    for (int i = 0; i < totalElements; i++) {
                        elementArray[i] = readInt(scanner, "Enter element " + (i + 1) + " (1 or 2): ");
                    }

                    System.out.println("Longest Balanced Subarray: " +operation.longestBalanced(elementArray));
                }

                case 5 -> {
                    System.out.print("Enter log string: ");
                    String logString = scanner.nextLine();
                    System.out.println("Compact Logs: " + operation.compactLogs(logString));
                }

                case 6 -> {
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();

                    int numBannedWords = readInt(scanner, "Enter number of banned words: ");
                    String[] bannedWords = new String[numBannedWords];

                    for (int i = 0; i < numBannedWords; i++) {
                        System.out.print("Enter banned word " + (i + 1) + ": ");
                        bannedWords[i] = scanner.nextLine();
                    }

                    System.out.println("Redacted Message: " + operation.redactMessage(message, bannedWords));
                }

                case 7 -> {
                    System.out.print("Enter SKU: ");
                    String skuInput = scanner.nextLine();
                    System.out.println("Normalized SKU: " + operation.normalizeSKU(skuInput));
                }

                case 8 -> {
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

                    System.out.println("Similarity Score: " + operation.calculateSimilarity(resume1, resume2));
                }

                case 9 -> {
                    System.out.print("Enter string: ");
                    String originalText = scanner.nextLine();
                    System.out.print("Enter target substring: ");
                    String target = scanner.nextLine();
                    System.out.print("Enter replacement substring: ");
                    String replacement = scanner.nextLine();
                    System.out.println("Result: " + operation.replace(originalText, target, replacement));
                }
                case 10 -> {
                    System.out.print("Enter number of actions: ");
                    int numActions = readInt(scanner, "");
                    String[] actions = new String[numActions];

                    for (int i = 0; i < numActions; i++) {
                        System.out.print("Enter action " + (i + 1) + " (format: userID,pageID): ");
                        actions[i] = scanner.nextLine();
                    }

                    System.out.println("Most Frequent Two-Step Path: " + Operations.mostFrequent2StepPath(actions));
                }
                case 0 -> System.out.println("Exiting program... Goodbye!");

                default -> System.out.println("Invalid choice! Please enter a number between 0–9.");
            }

        } while (choice != 0);

        scanner.close();
    }

}
