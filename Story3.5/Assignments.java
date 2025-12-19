import java.util.*;

public class Assignments {
    public void cosmicCourierChallenge() {
        int[] routes = {10, 5, 8, 12, 6};

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int time : routes) {
            if (time > max) {
                secondMax = max;
                max = time;
            } else if (time > secondMax) {
                secondMax = time;
            }
        }

        System.out.println("Minimum possible deadline: " + secondMax);
    }

    public void digitalLibrarySystem() {
        Library library = new Library();

        library.addBook(new Book("War"));
        library.addBook(new Book("Data"));
        library.addBook(new Book("Database"));

        System.out.println("Exact search (War): " + library.search("War", true));
        System.out.println("Partial search (Data): " + library.search("Data", false));

        library.removeBook("War");
        System.out.println("After removal search (War): " + library.search("War", false));
    }

    public void factoryFloorRobot() {
        int[] weights = {15, 6, 10, 7};

        List<String> labels = new ArrayList<>();
        for (int weight : weights) {
            labels.add(getLabel(weight));
        }

        System.out.println(labels);
    }

    private String getLabel(int weight) {
        if (weight % 15 == 0) return "Hazardous";
        if (weight % 3 == 0) return "Heavy";
        if (weight % 5 == 0) return "Fragile";
        return String.valueOf(weight);
    }

    public void spiesCipher() {
        String original = "abcd";
        String scrambled = "abcde";

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : scrambled.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : original.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.get(ch) - 1);
        }

        for (char ch : frequencyMap.keySet()) {
            if (frequencyMap.get(ch) > 0) {
                System.out.println("Extra character: " + ch);
                return;
            }
        }
    }

    public void concertSeatManager() {
        String[][] requests = {
                {"C1", "101"},
                {"C2", "105"},
                {"C3", "101"}
        };

        Set<String> allocatedSeats = new HashSet<>();

        for (String[] request : requests) {
            String customerId = request[0];
            String seatNumber = request[1];

            if (allocatedSeats.contains(seatNumber)) {
                System.out.println("Duplicate seat requested by: " + customerId);
                return;
            }
            allocatedSeats.add(seatNumber);
        }

        System.out.println("-1");
    }

    public void weatherStationAggregator() {
        int[] temperatures = {15, 22, 15, 30, 28, 31};

        int recordDays = 0;
        int highestTemperature = Integer.MIN_VALUE;

        for (int temp : temperatures) {
            if (temp > highestTemperature) {
                recordDays++;
                highestTemperature = temp;
            }
        }

        System.out.println("Number of record-breaking days: " + recordDays);
    }

    public void midpointFinder() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        System.out.println("Middle node value: " + slowPointer.data);
    }

    public void browserHistoryNavigator() {
        BrowserHistory browser = new BrowserHistory();

        browser.visit("A");
        browser.visit("B");
        browser.back();
        browser.visit("C");
        browser.forward();
    }
}

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book(\"" + title + "\")";
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void removeBook(String title) {
        books.removeIf(book -> book.title.equals(title));
    }

    List<Book> search(String query, boolean exactMatch) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (exactMatch && book.title.equals(query)) {
                result.add(book);
            } else if (!exactMatch && book.title.contains(query)) {
                result.add(book);
            }
        }
        return result;
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

class BrowserHistory {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage;

    void visit(String page) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = page;
        forwardStack.clear();
        System.out.println("Visited: " + page);
    }

    void back() {
        if (backStack.isEmpty()) {
            System.out.println("No page to go back");
            return;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Back to: " + currentPage);
    }

    void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No page to go forward");
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("Forward to: " + currentPage);
    }
}

