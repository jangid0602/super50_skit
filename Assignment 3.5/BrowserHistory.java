/*
 @filename - BrowserHistory.java
 @description - The Browser History Navigator
 @author - Kalp Mundra
 */

import java.util.Stack;

public class BrowserHistory {

    // Stack to store previously visited pages
    private Stack<String> backStack;

    // Stack to store forward navigation pages
    private Stack<String> forwardStack;

    // Currently active page
    private String current;

    // Initialize browser with homepage
    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        current = homepage;
    }

    // Visit a new URL and clear forward history
    public void visit(String url) {
        backStack.push(current);
        current = url;
        forwardStack.clear();
    }

    // Navigate to the previous page if possible
    public String back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
        }
        return current;
    }

    // Navigate to the next page if possible
    public String forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
        }
        return current;
    }

    // Get the currently active page
    public String getCurrentPage() {
        return current;
    }
}
