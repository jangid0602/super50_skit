import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Utility to read integer array from space-separated input
    static int[] readIntArray() {
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== WEEK 3.5 MENU =====");
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

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number 0-8.");
                continue;
            }

            switch (choice) {

                case 1: { // Cosmic Courier
                    System.out.print("Enter route times (space separated): ");
                    try {
                        int[] arr = readIntArray();
                        System.out.println("Minimum Deadline = " + Methods.minDeadline(arr));
                    } catch (Exception e) {
                        System.out.println("Invalid input! Enter integers only.");
                    }
                    break;
                }

                case 2: { // Digital Library
                    Methods.Library lib = new Methods.Library();
                    while (true) {
                        System.out.println("\n--- Library Menu ---");
                        System.out.println("1. Add Book");
                        System.out.println("2. Remove Book");
                        System.out.println("3. Search Book (Exact)");
                        System.out.println("4. Search Book (Partial)");
                        System.out.println("5. Exit Library Menu");
                        System.out.print("Enter choice: ");
                        int libChoice;
                        try {
                            libChoice = Integer.parseInt(sc.nextLine().trim());
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            continue;
                        }

                        switch (libChoice) {
                            case 1:
                                System.out.print("Enter book title to add: ");
                                String addTitle = sc.nextLine();
                                lib.addBook(addTitle.toLowerCase());
                                System.out.println("Added: " + addTitle);
                                break;
                            case 2:
                                System.out.print("Enter book title to remove: ");
                                String removeTitle = sc.nextLine();
                                lib.removeBook(removeTitle.toLowerCase());
                                System.out.println("Removed: " + removeTitle);
                                break;
                            case 3:
                                System.out.print("Enter book title to search (exact): ");
                                String searchExact = sc.nextLine();
                                System.out.println(lib.search(searchExact.toLowerCase(), true));
                                break;
                            case 4:
                                System.out.print("Enter book title to search (partial): ");
                                String searchPartial = sc.nextLine();
                                System.out.println(lib.search(searchPartial.toLowerCase(), false));
                                break;
                            case 5:
                                System.out.println("Exiting Library Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }

                        if (libChoice == 5) break;
                    }
                    break;
                }

                case 3: { // Factory Floor Robot
                    System.out.print("Enter item weights (space separated): ");
                    try {
                        int[] w = readIntArray();
                        System.out.println("Labels = " + Methods.robotLabels(w));
                    } catch (Exception e) {
                        System.out.println("Invalid input! Enter integers only.");
                    }
                    break;
                }

                case 4: { // Spy's Cipher
                    System.out.print("Enter original string: ");
                    String original = sc.nextLine();
                    System.out.print("Enter scrambled string: ");
                    String scrambled = sc.nextLine();
                    System.out.println("Extra character = " + Methods.findExtraChar(original, scrambled));
                    break;
                }

                case 5: { // Concert Seat
                    List<String[]> requests = new ArrayList<>();
                    System.out.print("Enter number of seat requests: ");
                    int n;
                    try {
                        n = Integer.parseInt(sc.nextLine().trim());
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter " + (i+1) + " customer ID and seat number (space separated): ");
                            String[] input = sc.nextLine().trim().split("\\s+");
                            if (input.length != 2) {
                                System.out.println("Invalid input!");
                                i--;
                                continue;
                            }
                            requests.add(input);
                        }
                        System.out.println("First duplicate seat = " + Methods.firstDuplicateSeat(requests));
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                }

                case 6: { // Weather Station
                    System.out.print("Enter daily temperatures (space separated): ");
                    try {
                        int[] t = readIntArray();
                        System.out.println("Record days = " + Methods.recordDays(t));
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                }

                case 7: { // Midpoint Finder
                    System.out.print("Enter number of nodes: ");
                    try {
                        int n = Integer.parseInt(sc.nextLine().trim());
                        if (n <= 0) {
                            System.out.println("List must have at least 1 node.");
                            break;
                        }
                        Methods.Node<Object> head = null, tail = null;
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter node value: ");
                            String val = sc.nextLine();
                            Methods.Node<Object> node;
                            try {
                                int num = Integer.parseInt(val);
                                node = new Methods.Node<>(num);
                            } catch (Exception ex) {
                                node = new Methods.Node<>(val);
                            }
                            if (head == null) head = node;
                            else tail.next = node;
                            tail = node;
                        }
                        System.out.println("Middle node value = " + Methods.findMiddle(head));
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                }

                case 8: { // Browser History
                    Methods.BrowserHistory bh = new Methods.BrowserHistory();
                    while (true) {
                        System.out.println("\n--- Browser History Menu ---");
                        System.out.println("1. Visit Page");
                        System.out.println("2. Back");
                        System.out.println("3. Forward");
                        System.out.println("4. Current Page");
                        System.out.println("5. Exit Browser Menu");
                        System.out.print("Enter choice: ");
                        int op;
                        try {
                            op = Integer.parseInt(sc.nextLine().trim());
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            continue;
                        }

                        switch (op) {
                            case 1:
                                System.out.print("Enter page to visit: ");
                                String page = sc.nextLine();
                                bh.visit(page);
                                System.out.println("Visited: " + page);
                                break;
                            case 2:
                                System.out.println("Back -> " + bh.back());
                                break;
                            case 3:
                                System.out.println("Forward -> " + bh.forward());
                                break;
                            case 4:
                                System.out.println("Current Page -> " + (bh.curr == null ? "NULL" : bh.curr));
                                break;
                            case 5:
                                System.out.println("Exiting Browser Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }

                        if (op == 5) break;
                    }
                    break;
                }

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
