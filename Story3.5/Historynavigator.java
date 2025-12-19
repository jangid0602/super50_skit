import java.util.Scanner;
import java.util.Stack;

/**
 * @Filename-DigitalLibrary.java
 * @Description-Design a browser history system
 * @Author-Anushka Kumawat
 **/

class BrowserHistory {

    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String currentPage = null;

    void visit(String page) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = page;
        forwardStack.clear();
    }

    String back() {
        if (backStack.isEmpty()) {
            return "NULL";
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    String forward() {
        if (forwardStack.isEmpty()) {
            return "NULL";
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    String getCurrentPage() {
        return currentPage;
    }
}

public class Historynavigator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BrowserHistory bh = new BrowserHistory();

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Visit a page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter page name: ");
                    String page = sc.nextLine();
                    bh.visit(page);
                    System.out.println("Visited: " + page);
                    break;

                case 2:
                    System.out.println("Current Page: " + bh.back());
                    break;

                case 3:
                    System.out.println("Current Page: " + bh.forward());
                    break;

                case 4:
                    System.out.println("Current Page: " + bh.getCurrentPage());
                    break;

                case 5:
                    System.out.println("Exiting Browser...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
