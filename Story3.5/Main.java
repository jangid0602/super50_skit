import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();
        Stack1 browser = new Stack1();
        Operations ops = new Operations();

        while (true) {
            try {
                System.out.println("\n========= MAIN MENU =========");
                System.out.println("1. Library Operations");
                System.out.println("2. Browser Navigation System");
                System.out.println("3. Exciting Array Operations");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        libraryMenu(library);
                        break;

                    case 2:
                        browserMenu(browser);
                        break;

                    case 3:
                        arrayMenu(ops);
                        break;

                    case 4:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Try again!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    /* =======================
       LIBRARY MENU
       ======================= */
    static void libraryMenu(Library library) {
        while (true) {
            try {
                System.out.println("\n----- Library Menu -----");
                System.out.println("1. Add Book");
                System.out.println("2. Search Book (Exact)");
                System.out.println("3. Search Book (Partial)");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        library.addBook(title);
                        System.out.println("Book added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter exact title: ");
                        String exact = sc.nextLine();
                        List<Book> exactResult = library.search(exact);
                        displayBooks(exactResult);
                        break;

                    case 3:
                        System.out.print("Enter keyword: ");
                        String partial = sc.nextLine();
                        List<Book> partialResult = library.search(partial, true);
                        displayBooks(partialResult);
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.print("Books found: ");
            for (Book b : books) {
                System.out.print(b.getTitle() + " ");
            }
            System.out.println();
        }
    }

    /* =======================
       BROWSER MENU
       ======================= */
    static void browserMenu(Stack1 browser) {
        while (true) {
            try {
                System.out.println("\n----- Browser Menu -----");
                System.out.println("1. Visit Page");
                System.out.println("2. Back");
                System.out.println("3. Forward");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter page URL: ");
                        String page = sc.nextLine();
                        browser.visit(page);
                        System.out.println("Visited: " + page);
                        break;

                    case 2:
                        String back = browser.back();
                        System.out.println(back == null ? "No back history." : "Current Page: " + back);
                        break;

                    case 3:
                        String forward = browser.forward();
                        System.out.println(forward == null ? "No forward history." : "Current Page: " + forward);
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    /* =======================
       ARRAY OPERATIONS MENU
       ======================= */
    static void arrayMenu(Operations ops) {
        while (true) {
            try {
                System.out.println("\n----- Array Operations Menu -----");
                System.out.println("1. Insert Element");
                System.out.println("2. Get Minimum Deadline");
                System.out.println("3. Assign Labels");
                System.out.println("4. Get Record Days");
                System.out.println("5. Get Spy Character");
                System.out.println("6. Get Duplicate Customer ID");
                System.out.println("7. Back to Main Menu");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter size of array: ");
                        int size = sc.nextInt();
                        ops.insert(size);
                        System.out.println("Inserted successfully.");
                        break;

                    case 2:
                        System.out.println("Minimum Deadline: " + ops.getMinimumDeadline());
                        break;

                    case 3:
                        String[] labels = ops.assignLabels();
                        System.out.println("Labels:");
                        for (String s : labels)
                            System.out.print(s + " ");
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Record Days: " + ops.getRecordDays());
                        break;

                    case 5:
                        System.out.println("Enter original string:-");
                        String original = sc.next();
                        System.out.println("Enter scrambled string:-");
                        String scrambled = sc.next();
                        System.out.println("Spy character: " + ops.getSpyCharacter(original, scrambled));
                        break;

                    case 6:
                        System.out.print("Enter number of records: ");
                        int n = sc.nextInt();
                        int[][] seat = new int[n][2];

                        System.out.println("Enter CustomerID and SeatNumber:");
                        for (int i = 0; i < n; i++) {
                            System.out.println("Enter ID of " + (i + 1) + "th customer:-");
                            seat[i][0] = sc.nextInt();
                            System.out.println("Enter seat of " + (i + 1) + "th customer:-");
                            seat[i][1] = sc.nextInt();
                        }
                        int result = ops.getCustomerId(seat);

                        if (result == -1) {
                            System.out.println("No duplicate seat found.");
                        } else {
                            System.out.println("Customer with duplicate seat: " + result);
                        }
                        break;

                    case 7:
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
