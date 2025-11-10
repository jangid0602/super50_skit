import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Functions fn = new Functions();
        int choice = 0;

        while (true) {
            System.out.println("\n===== WEEK 2 PROBLEM MENU =====");
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
            System.out.print("Enter your choice (1-11): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1 and 11.");
                continue;
            }

            switch (choice) {
                case 1:
                    fn.trendsetterScore(sc);
                    break;
                case 2:
                    fn.encodedSubset(sc);
                    break;
                case 3:
                    fn.ecommerceFunnel(sc);
                    break;
                case 4:
                    fn.maxPairMatching(sc);
                    break;
                case 5:
                    fn.colorBalance(sc);
                    break;
                case 6:
                    fn.textReplace(sc);
                    break;
                case 7:
                    fn.logCompaction(sc);
                    break;
                case 8:
                    fn.skuNormalization(sc);
                    break;
                case 9:
                    fn.chatRedaction(sc);
                    break;
                case 10:
                    fn.resumeVersioning(sc);
                    break;
                case 11:
                    System.out.println("Exiting program... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}
