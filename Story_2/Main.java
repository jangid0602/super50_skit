import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Solution solver = new Solution();
        String inputChoice;
        int choice;

        do {
            // Displaying main menu
            System.out.println("\n1.) The Trendsetter Score");
            System.out.println("2.) Encoded String subsets");
            System.out.println("3.) E-Commerce Funnel Analysis");
            System.out.println("4.) Maximum Pair Matching");
            System.out.println("5.) Subarray Color Balance");
            System.out.println("6.) Text Editor Non-Overlapping Replace");
            System.out.println("7.) Log File Compaction");
            System.out.println("8.) E-Commerce SKU Normalization");
            System.out.println("9.) Chat Message Redaction");
            System.out.println("10.) Resume Keywords Versioning");
            System.out.println("0.) Exit");
            System.out.print("Enter your choice: ");

            inputChoice = scanner.nextLine();

            // Validate input to ensure only numeric entries are accepted
            if (inputChoice.matches("\\d+")) {
                choice = Integer.parseInt(inputChoice);
            } else {
                choice = -1; // mark invalid input
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    solver.setArray(inputArray);

                    System.out.print("Enter the Window Size: ");
                    int windowSize = scanner.nextInt();

                    if (windowSize <= 0) {
                        System.out.println("Not a valid Initial Energy");
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Number Of TrendSetter Windows : "
                            + solver.getTrendsetterWindows(windowSize));
                    break;

                case 2:
                    System.out.print("Enter the Super String : ");
                    String superString = scanner.nextLine();

                    System.out.print("Enter the substring : ");
                    String subString = scanner.nextLine();

                    if (superString.length() == 0 || subString.length() == 0) {
                        System.out.println("Invalid Input !");
                        break;
                    }

                    System.out.println(solver.checkPermutationSubstring(superString, subString));
                    break;

                case 3:
                    // Do It Later
                    break;

                case 4:
                    // Find the single (non-repeating) element in array
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    // Ensure array size is valid and odd (for XOR logic)
                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray4 = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray4[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    System.out.println("Enter Target Value: ");
                    int target = scanner.nextInt();
                    scanner.nextLine();

                    solver.setArray(inputArray4);
                    System.out.println("The Number of Matching Pair : " + solver.countMaximumPairs(target));
                    break;

                case 5:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray5 = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray5[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    System.out.println("Result: " + solver.longestBalancedSubarray());
                    break;

                case 6:
                    System.out.print("Enter the text : ");
                    String text = scanner.nextLine();

                    System.out.print("Enter the String to be Replaced : ");
                    String findString = scanner.nextLine();

                    System.out.print("Enter the String to with Replace : ");
                    String replace = scanner.nextLine();

                    System.out.println("String After Find and Replace : "
                            + solver.nonOverlappingReplace(text, findString, replace));
                    break;

                case 7:
                    System.out.println("Enter the String: ");
                    String logs = scanner.nextLine();

                    System.out.println("Result : " + solver.compactLogs(logs));
                    break;

                case 8:
                    System.out.println("Enter the String : ");
                    String sku = scanner.nextLine();

                    System.out.println("String After SKU Normalization : " + solver.normalizeSKU(sku));
                    break;

                case 9:
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();

                    System.out.println("Enter the Number of banned words : ");
                    int banWords = scanner.nextInt();
                    scanner.nextLine();

                    String[] bannedWords = new String[banWords];
                    System.out.println("Enter the banned Words : ");
                    for (int i = 0; i < banWords; i++) {
                        bannedWords[i] = scanner.nextLine();
                    }

                    System.out.println("The new Message : " + solver.redactMessage(message, bannedWords));
                    break;

                case 10:
                    System.out.println("Enter the Number of Skills in Resume 1 : ");
                    int size1 = scanner.nextInt();
                    scanner.nextLine();

                    String[] resume1 = new String[size1];

                    System.out.println("Enter the Skills : ");
                    for (int i = 0; i < size1; i++) {
                        resume1[i] = scanner.nextLine();
                    }

                    System.out.println("Enter the Number of Skills in Resume 2 : ");
                    int size2 = scanner.nextInt();
                    scanner.nextLine();

                    String[] resume2 = new String[size2];

                    System.out.println("Enter the Skills : ");
                    for (int i = 0; i < size1; i++) {
                        resume1[i] = scanner.nextLine();
                    }

                    System.out.println("Similarity Score : " + solver.calculateSimilarityScore(resume1, resume2));
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    // Catch-all for invalid numeric input
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        scanner.close();

    }
}
