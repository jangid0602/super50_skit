import java.util.Scanner;
import java.util.Stack;

/**
 * @Filename-BrowserHistoryNavigator.java
 * @Description-Implements browser navigation using two stacks
 * @Author-Aditya Virmani
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

            // Taking integer input with the help of InputHelper class
            choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Enter page value:");
                    String value = scanner.next();
                    browser.visit(value);
                    break;

                case 2:
                    String backPage = browser.back();
                    System.out.println(backPage == null ? "No page to go back to" : "Current page: " + backPage);
                    break;

                case 3:
                    String forwardPage = browser.forward();
                    System.out
                            .println(forwardPage == null ? "No page to go forward to" : "Current page: " + forwardPage);
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
