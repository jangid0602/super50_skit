/*
 @filename - Main.java
 @description - Main Menu function
 @author - Kalp Mundra
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String choiceInput;
        int choice = -1;

        myFunction object = new myFunction();

        do {
            // Display menu
            System.out.println("\n------ MENU -----");
            System.out.println("1. Cosmic Courier Challenge");
            System.out.println("2. Digital Library System");
            System.out.println("3. Factory Floor Robot");
            System.out.println("4. Spy's Cipher");
            System.out.println("5. Concert Seat Manager");
            System.out.println("6. Weather Station Data Aggregator");
            System.out.println("7. Midpoint Finder");
            System.out.println("8. Browser History Navigator");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choiceInput = sc.nextLine();

            // Validate numeric menu input
            if (choiceInput.matches("\\d+")) {
                choice = Integer.parseInt(choiceInput);
            } else {
                choice = -1;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter number of routes: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (n < 1) {
                        System.out.println("Not a valid input !");
                        break;
                    }

                    int[] routes = new int[n];
                    System.out.println("Enter route times:");
                    for (int i = 0; i < n; i++) {
                        routes[i] = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.println("Minimum Possible deadline : " +
                            object.getMinimumDeadline(routes));
                    break;

                case 2:
                    myLibrary.Library lib = new myLibrary().new Library();

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
                    sc.nextLine();

                    System.out.println(lib.search(title, partial));
                    break;

                case 3:
                    System.out.print("Enter number of items: ");
                    int item = sc.nextInt();
                    sc.nextLine();

                    if (item < 1) {
                        System.out.println("Not a valid input !");
                        break;
                    }

                    int[] items = new int[item];
                    System.out.println("Enter item values:");
                    for (int i = 0; i < item; i++) {
                        items[i] = sc.nextInt();
                        sc.nextLine();
                    }

                    object.inspectItem(items);
                    break;

                case 4:
                    System.out.print("Enter original string: ");
                    String original = sc.nextLine();

                    System.out.print("Enter scrambled string: ");
                    String scrambled = sc.nextLine();

                    System.out.println("Extra character: " +
                            object.findExtraCharacter(original, scrambled));
                    break;

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
                            object.findDuplicate(requests));
                    break;

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
                            object.countDays(temps));
                    break;

                case 7:
                    System.out.print("Enter number of nodes: ");
                    int len = sc.nextInt();
                    sc.nextLine();

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
                    sc.nextLine();

                    System.out.println("Middle Node: " +
                            object.findMid(head));
                    break;

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
