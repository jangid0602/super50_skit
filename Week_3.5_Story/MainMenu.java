/*
@filename - MainMenu.java
@description - Custom menu
@author - Kavya Gupta
*/

import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cosmic Courier Challenge");
            System.out.println("2. Digital Library System");
            System.out.println("3. Factory Floor Robot");
            System.out.println("4. Spy’s Cipher");
            System.out.println("5. Concert Seat Manager");
            System.out.println("6. Weather Station Data Aggregator");
            System.out.println("7. Midpoint Finder");
            System.out.println("8. Browser History Navigator");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // 1. Cosmic Courier
                case 1:
                    System.out.print("Enter number of routes: ");
                    int n = sc.nextInt();
                    int[] routes = new int[n];
                    System.out.println("Enter route times:");
                    for (int i = 0; i < n; i++) {
                        routes[i] = sc.nextInt();
                    }
                    System.out.println("Minimum Deadline: " +
                            MyWeek3Point5.minDeadline(routes));
                    break;

                // 2. Digital Library
                case 2:
                    MyLibrary.Library lib = new MyLibrary().new Library();

                    System.out.print("Enter number of books: ");
                    int b = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < b; i++) {
                        System.out.print("Enter book title: ");
                        lib.addBook(sc.nextLine());
                    }

                    System.out.print("Search title: ");
                    String title = sc.nextLine();

                    System.out.print("Partial search? (true/false): ");
                    boolean partial = sc.nextBoolean();

                    System.out.println(lib.search(title, partial));
                    break;

                // 3. Factory Robot
                case 3:
                    System.out.print("Enter number of items: ");
                    int m = sc.nextInt();
                    int[] weights = new int[m];
                    System.out.println("Enter weights:");
                    for (int i = 0; i < m; i++) {
                        weights[i] = sc.nextInt();
                    }
                    System.out.println(MyWeek3Point5.labelItems(weights));
                    break;

                // 4. Spy’s Cipher
                case 4:
                    System.out.print("Enter original string: ");
                    String original = sc.nextLine();
                    System.out.print("Enter scrambled string: ");
                    String scrambled = sc.nextLine();
                    System.out.println("Extra character: " +
                            MyWeek3Point5.findExtraCharacter(original, scrambled));
                    break;

                // 5. Concert Seat Manager
                case 5:
                    System.out.print("Enter number of requests: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    String[][] requests = new String[r][2];
                    for (int i = 0; i < r; i++) {
                        System.out.print("Customer ID: ");
                        requests[i][0] = sc.nextLine();
                        System.out.print("Seat Number: ");
                        requests[i][1] = sc.nextLine();
                    }

                    System.out.println("Result: " +
                            MyWeek3Point5.findFirstDuplicateSeat(requests));
                    break;

                // 6. Weather Station
                case 6:
                    System.out.print("Enter number of days: ");
                    int d = sc.nextInt();
                    sc.nextLine();

                    String[] temps = new String[d];
                    System.out.println("Enter temperatures:");
                    for (int i = 0; i < d; i++) {
                        temps[i] = sc.nextLine();
                    }

                    System.out.println("Record Days: " +
                            MyWeek3Point5.countRecordDays(temps));
                    break;

                // 7. Midpoint Finder
                case 7:
                    System.out.print("Enter number of nodes: ");
                    int len = sc.nextInt();

                    Node<Integer> head = null, tail = null;
                    System.out.println("Enter node values:");
                    for (int i = 0; i < len; i++) {
                        Node<Integer> newNode = new Node<>(sc.nextInt());
                        if (head == null) {
                            head = tail = newNode;
                        } else {
                            tail.next = newNode;
                            tail = newNode;
                        }
                    }

                    System.out.println("Middle Node: " +
                            MyWeek3Point5.findMiddle(head));
                    break;

                // 8. Browser History
                case 8:
                    System.out.print("Enter homepage: ");
                    BrowserHistory bh = new BrowserHistory(sc.nextLine());

                    int op;
                    do {
                        System.out.println("1.Visit  2.Back  3.Forward  0.Exit");
                        op = sc.nextInt();
                        sc.nextLine();

                        if (op == 1) {
                            System.out.print("Enter URL: ");
                            bh.visit(sc.nextLine());
                        } else if (op == 2) {
                            System.out.println("Current: " + bh.back());
                        } else if (op == 3) {
                            System.out.println("Current: " + bh.forward());
                        }
                    } while (op != 0);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
