public class BrowserHistoryNavigator {
    MyStack backStack, forwardStack;

    public BrowserHistoryNavigator() {
        forwardStack = new MyStack();
        backStack = new MyStack();
    }

    public String getCurrentPage() {
        return backStack.peek();
    }

    public void visit(String page) {
        backStack.push(page);
        forwardStack = new MyStack();
    }

    public void back() {
        forwardStack.push(backStack.pop());
    }

    public void forward() {
        backStack.push(forwardStack.pop());
    }

}
