/*
@filename - BrowserHistory.java
@description - The Browser History Navigator
@author - Kavya Gupta
*/

// 8. The Browser History Navigator

import java.util.Stack;

public class BrowserHistory {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String current;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        current = homepage;
    }

    public void visit(String url) {
        backStack.push(current);
        current = url;
        forwardStack.clear();
    }

    public String back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
        }
        return current;
    }

    public String forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
        }
        return current;
    }

    public String getCurrentPage() {
        return current;
    }
}
