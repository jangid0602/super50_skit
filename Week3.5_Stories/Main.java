import java.util.*;

public class Main {

    /* 1. Cosmic Courier Challenge ================ */

    static void cosmicCourier(Scanner sc) {
        System.out.println("\n--- Cosmic Courier Challenge ---");
        System.out.print("Enter number of routes: ");

        int n = sc.nextInt();
        int[] routes = new int[n];

        System.out.println("Enter route travel times:");
        for (int i = 0; i < n; i++) {
            routes[i] = sc.nextInt();
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int x : routes) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        System.out.print("Minimum possible deadline: ");
        if (n > 1)
            System.out.println(max2);
        else
            System.out.println(max1);
    }

    /* 2. Digital Library System ================ */
    
    static class Book {
        String title;

        Book(String t) {
            title = t;
        }
    }

    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        void addBook(String name) {
            books.add(new Book(name));
        }

        void searchBook(String key, boolean exact) {
            boolean found = false;

            for (Book b : books) {
                if (exact && b.title.equals(key)) {
                    System.out.print(b.title + " ");
                    found = true;
                } else if (!exact && b.title.contains(key)) {
                    System.out.print(b.title + " ");
                    found = true;
                }
            }

            if (!found)
                System.out.print("No book found");

            System.out.println();
        }
    }

    static void digitalLibrary(Scanner sc) {
        System.out.println("\n--- Digital Library System ---");
        System.out.println("Sample books added: War, Data, Database");

        Library lib = new Library();
        lib.addBook("War");
        lib.addBook("Data");
        lib.addBook("Database");

        System.out.print("Enter search keyword: ");
        String key = sc.next();

        System.out.print("Enter search type (1 = Exact, 0 = Partial): ");
        int type = sc.nextInt();

        System.out.print("Search Result: ");
        lib.searchBook(key, type == 1);
    }

    /* 3. Factory Floor Robot ================ */
    
    static void factoryFloorRobot(Scanner sc) {
        System.out.println("\n--- Factory Floor Robot ---");
        System.out.print("Enter number of items: ");

        int n = sc.nextInt();
        System.out.println("Enter item weights:");

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();

            if (w % 15 == 0)
                System.out.print("Hazardous ");
            else if (w % 3 == 0)
                System.out.print("Heavy ");
            else if (w % 5 == 0)
                System.out.print("Fragile ");
            else
                System.out.print(w + " ");
        }
        System.out.println();
    }

    /* 4. The Spy’s Cipher ================ */
    
    static void spiesCipher(Scanner sc) {
        System.out.println("\n--- The Spy's Cipher ---");
        System.out.print("Enter original string: ");
        String original = sc.next();

        System.out.print("Enter scrambled string: ");
        String scrambled = sc.next();

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : scrambled.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char c : original.toCharArray())
            freq.put(c, freq.get(c) - 1);

        System.out.print("Extra character found: ");
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println(e.getKey());
                return;
            }
        }
    }

    /* 5. Concert Seat Manager ================ */
    
    static void concertSeatManager(Scanner sc) {
        System.out.println("\n--- Concert Seat Manager ---");
        System.out.print("Enter number of requests: ");

        int n = sc.nextInt();
        HashSet<Integer> seats = new HashSet<>();

        System.out.println("Enter customer ID and seat number:");
        for (int i = 0; i < n; i++) {
            String customer = sc.next();
            int seat = sc.nextInt();

            if (seats.contains(seat)) {
                System.out.println("First duplicate seat requested by: " + customer);
                return;
            }
            seats.add(seat);
        }

        System.out.println("-1 (No duplicate seat request)");
    }

    /* 6. Weather Station Aggregator ================ */
    
    static void weatherStation(Scanner sc) {
        System.out.println("\n--- Weather Station Data Aggregator ---");
        System.out.print("Enter number of days: ");

        int n = sc.nextInt();
        System.out.println("Enter temperatures:");

        int maxTemp = Integer.MIN_VALUE;
        int recordDays = 0;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > maxTemp) {
                recordDays++;
                maxTemp = temp;
            }
        }

        System.out.println("Number of record breaking days: " + recordDays);
    }

    /* 7. Midpoint Finder ================ */
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    static void midpointFinder(Scanner sc) {
        System.out.println("\n--- Midpoint Finder ---");
        System.out.print("Enter number of nodes: ");

        int n = sc.nextInt();
        System.out.println("Enter node values:");

        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node node = new Node(x);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element: " + slow.data);
    }

    /* 8. Browser History Navigator ================ */

    static void browserHistory(Scanner sc) {
        System.out.println("\n--- Browser History Navigator ---");
        System.out.print("Enter number of actions: ");

        int q = sc.nextInt();
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        String current = "NULL";

        System.out.println("Use commands: visit <page>, back, forward");
        while (q-- > 0) {
            String action = sc.next();

            if (action.equals("visit")) {
                String page = sc.next();
                if (!current.equals("NULL"))
                    backStack.push(current);
                current = page;
                forwardStack.clear();
            } else if (action.equals("back")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                }
            } else if (action.equals("forward")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                }
            }
        }

        System.out.println("Current page: " + current);
    }

    /* ===============================
       MAIN MENU WITH EXIT
       =============================== */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========================================");
            System.out.println(" Week 3.5 - Menu Driven Program");
            System.out.println("========================================");
            System.out.println("1. Cosmic Courier Challenge");
            System.out.println("2. Digital Library System");
            System.out.println("3. Factory Floor Robot");
            System.out.println("4. The Spy's Cipher");
            System.out.println("5. Concert Seat Manager");
            System.out.println("6. Weather Station Data Aggregator");
            System.out.println("7. Midpoint Finder");
            System.out.println("8. Browser History Navigator");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: cosmicCourier(sc); break;
                case 2: digitalLibrary(sc); break;
                case 3: factoryFloorRobot(sc); break;
                case 4: spiesCipher(sc); break;
                case 5: concertSeatManager(sc); break;
                case 6: weatherStation(sc); break;
                case 7: midpointFinder(sc); break;
                case 8: browserHistory(sc); break;
                case 9:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
