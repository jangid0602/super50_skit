/* 
 * @filename - Main.java
 * @description - Solutions for story3.5
 * @author - Khushi Gehlot
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MySolution sol = new MySolution();

        System.out.println("Choose a problem (1–8):");
        System.out.println("1. Cosmic Courier Challenge");
        System.out.println("2. Digital Library System");
        System.out.println("3. Factory Floor Robot");
        System.out.println("4. Spy’s Cipher");
        System.out.println("5. Concert Seat Manager");
        System.out.println("6. Weather Station Data Aggregator");
        System.out.println("7. Midpoint Finder");
        System.out.println("8. Browser History Navigator");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                int[] routes = {10, 5, 8, 12, 6};
                System.out.println(sol.minDeadline(routes));
                break;

            case 2:
                sol.libraryDemo();
                break;

            case 3:
                int[] weights = {15, 6, 10, 7};
                System.out.println(sol.robotLabels(weights));
                break;

            case 4:
                System.out.println(sol.findExtraChar("abcd", "abcde"));
                break;

            case 5:
                String[][] requests = {
                        {"C1", "101"},
                        {"C2", "105"},
                        {"C3", "101"}
                };
                System.out.println(sol.duplicateSeat(requests));
                break;

            case 6:
                int[] temps = {15, 22, 15, 30, 28, 31};
                System.out.println(sol.recordDays(temps));
                break;

            case 7:
                MySolution.Node head = new MySolution.Node(1);
                head.next = new MySolution.Node(2);
                head.next.next = new MySolution.Node(3);
                head.next.next.next = new MySolution.Node(4);
                head.next.next.next.next = new MySolution.Node(5);
                System.out.println(sol.middleNode(head));
                break;

            case 8:
                sol.browserDemo();
                break;

            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
