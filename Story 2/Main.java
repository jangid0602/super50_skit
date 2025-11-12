/**
 * <p>This is the main class which provides a menu to the user to select and solve a problem.</p>
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scannerObj = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n==============================");
                System.out.println("Choose the Problem to Solve:");
                System.out.println("==============================");
                System.out.println("1.  The Trendsetter Score");
                System.out.println("2.  Encoded String Subsets");
                System.out.println("3.  E-Commerce Funnel Analysis");
                System.out.println("4.  Maximal Pair Matching");
                System.out.println("5.  Subarray Color Balance");
                System.out.println("6.  Text Editor Non-Overlapping Replace");
                System.out.println("7.  Log File Compaction");
                System.out.println("8.  E-commerce SKU Normalization");
                System.out.println("9.  Chat Message Redaction");
                System.out.println("10. Resume Keyword Versioning");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");

                if (!scannerObj.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scannerObj.next();
                    continue;
                }

                int option = scannerObj.nextInt();
                problemSolver solverObj = null;

                switch (option) {
                    case 1 -> solverObj = new TrendsetterScore();             // Uses arrayHandler
                    case 2 -> solverObj = new EncodedStringSubsets();         // Uses arrayHandler
                    case 3 -> solverObj = new ECommerceFunnelAnalysis();      // Uses arrayHandler
                    case 4 -> solverObj = new MaximalPairMatching();          // Uses arrayHandler
                    case 5 -> solverObj = new SubarrayColorBalance();         // Uses arrayHandler
                    case 6 -> solverObj = new TextEditorNonOverlappingReplace(); // Uses arrayHandler
                    case 7 -> solverObj = new LogFileCompaction();            // Uses arrayHandler
                    case 8 -> solverObj = new EcommerceSKUNormalization();    // Uses arrayHandler
                    case 9 -> solverObj = new ChatMessageRedaction();         // Uses arrayHandler
                    case 10 -> solverObj = new ResumeKeywordVersioning();     // Uses arrayHandler
                    case 11 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Option! Please choose between 1 and 11.");
                        continue;
                    }
                }

                // 🔹 Automatically handle input regardless of handler type
                try {
                    solverObj.inputArray();  // Calls the correct method from arrayHandler, stringHandler, or inputHandler
                    solverObj.solver();      // Executes problem logic
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        }
    }
}
