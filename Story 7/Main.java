import java.util.Scanner;
import story.Story;
/**
 * Week 7 Assignment
 * Author: Badal
 * Description: Menu driven Java program implementing all 10 story-based problems
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= DP STORY MENU =========");
            System.out.println("1. Startup Revenue Maxima");
            System.out.println("2. Mentorship Matching");
            System.out.println("3. Tech Stack Swap (Edit Distance)");
            System.out.println("4. Placement Marathon");
            System.out.println("5. Optimal Server Latency");
            System.out.println("6. Ad Placement Show");
            System.out.println("7. Binary Tree Audit");
            System.out.println("8. Prime Digit Sum Count");
            System.out.println("9. Circular Office Security");
            System.out.println("10. Palindromic Deployment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> Story.startupRevenue(sc);
                case 2 -> Story.mentorshipMatching(sc);
                case 3 -> Story.techStackSwap(sc);
                case 4 -> Story.placementMarathon(sc);
                case 5 -> Story.serverLatency(sc);
                case 6 -> Story.adPlacement(sc);
                case 7 -> Story.binaryTreeAudit(sc);
                case 8 -> Story.primeDigitSum(sc);
                case 9 -> Story.circularOffice(sc);
                case 10 -> Story.palindromicDeployment(sc);
                case 0 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
