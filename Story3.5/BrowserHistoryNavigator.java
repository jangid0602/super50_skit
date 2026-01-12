import java.util.Scanner;
import java.util.Stack;

/**
 * @Filename- BrowserHistoryNavigator.java
 * @Description-This class simulates a browser's history navigation functionality
 *                   using two stacks to manage back and forward navigation. It allows
 *                   users to visit new pages, navigate backward through history, and
 *                   navigate forward through previously visited pages. The implementation
 *                   uses a back stack to store previously visited pages and a forward
 *                   stack to store pages that can be navigated forward to.
 * @Author- Aman Jeet Singh
 */
public class BrowserHistoryNavigator {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserHistoryNavigator() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = null;
    }

    public void visit(String page) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = page;
        forwardStack.clear(); // clear forward history
    }

    public String back() {
        if (backStack.isEmpty()) {
            return null;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    public String forward() {
        if (forwardStack.isEmpty()) {
            return null;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    /**
     * Safely reads a non-empty string from the scanner, prompting user until valid input is provided.
     */
    private static String readString(Scanner scanner) {
        String input = scanner.next().trim();
        while (input.isEmpty()) {
            System.out.println("Invalid input! Please enter a non-empty string.");
            input = scanner.next().trim();
        }
        return input;
    }

    public static void main(String[] args) {
        BrowserHistoryNavigator browser = new BrowserHistoryNavigator();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEnter:");
            System.out.println("1. Visit a new page");
            System.out.println("2. Go back");
            System.out.println("3. Go forward");
            System.out.println("4. Get current page");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter page value: ");
                    String value = readString(scanner);
                    browser.visit(value);
                    break;

                case 2:
                    String backPage = browser.back();
                    System.out.println(backPage == null ? "No page to go back to" : "Current page: " + backPage);
                    break;

                case 3:
                    String forwardPage = browser.forward();
                    System.out.println(forwardPage == null ? "No page to go forward to" : "Current page: " + forwardPage);
                    break;

                case 4:
                    System.out.println(browser.getCurrentPage() == null ? "No page visited yet" 
                            : "Current page is: " + browser.getCurrentPage());
                    break;

                case 0:
                    System.out.println("Exiting browser...");
                    break;

                default:
                    System.out.println("Enter a valid option");
            }
        } while (choice != 0);

        scanner.close();
    }
}