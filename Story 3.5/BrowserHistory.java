import java.util.Scanner;
import java.util.Stack;

/**
 * @Filename-BrowserHistory.java
 * @Description- Implements browser navigation using two stacks
 * @Author- Arman Agrawal
 */


public class BrowserHistory {
    private Stack<String> backHistoryStack;
    private Stack<String> forwardHistoryStack;
    private String currentPage;


    public BrowserHistory(){
        backHistoryStack = new Stack<>();
        forwardHistoryStack = new Stack<>();
        currentPage = null;
    }

    public void visit(String page){
        if(currentPage!=null){
            backHistoryStack.push(currentPage);
        }
        currentPage = page;
        forwardHistoryStack.clear();
    }

    public String back(){
        if(backHistoryStack.isEmpty()){
            return currentPage;
        }
        forwardHistoryStack.push(currentPage);
        currentPage = backHistoryStack.pop();
        return currentPage;
    }

    public String forward(){
        if(forwardHistoryStack.isEmpty()){
            return null;
        }
        backHistoryStack.push(currentPage);
        currentPage = forwardHistoryStack.pop();
        return currentPage;
    }

    public String getCurrentPage(){
        return currentPage;
    }


public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    BrowserHistory browser = new BrowserHistory();

    while (true) {
        System.out.println("\n===== Browser Menu =====");
        System.out.println("1. Visit Page");
        System.out.println("2. Back");
        System.out.println("3. Forward");
        System.out.println("4. Current Page");
        System.out.println("0. Exit");

        System.out.print("Enter choice: ");
        int choice;

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Enter a number.");
            scanner.next();
            continue;
        }

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter page URL/name: ");
                String page = scanner.nextLine();
                browser.visit(page);
                System.out.println("Visited: " + page);
                break;

            case 2:
                String backPage = browser.back();
                if (backPage == null) {
                    System.out.println("No page to go back.");
                } else {
                    System.out.println("Current page after back: " + backPage);
                }
                break;

            case 3:
                String forwardPage = browser.forward();
                if (forwardPage == null) {
                    System.out.println("No page to go forward.");
                } else {
                    System.out.println("Current page after forward: " + forwardPage);
                }
                break;

            case 4:
                String current = browser.getCurrentPage();
                if (current == null) {
                    System.out.println("No page visited yet.");
                } else {
                    System.out.println("Current page: " + current);
                }
                break;

            case 0:
                System.out.println("Exiting browser...");
                scanner.close();
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }
    

}
}