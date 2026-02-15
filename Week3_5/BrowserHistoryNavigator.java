package Week3_5;

public class BrowserHistoryNavigator {
    private String[] backStack = new String[8];
    private int backTop = 0; // points to next free slot
    private String[] forwardStack = new String[8];
    private int forwardTop = 0;
    private String current = null;

    public void visit(String page) {
        if (current != null) pushBack(current);
        current = page;
        clearForward();
    }

    public String back() {
        if (backTop == 0) return current;
        pushForward(current);
        current = popBack();
        return current;
    }

    public String forward() {
        if (forwardTop == 0) return current;
        pushBack(current);
        current = popForward();
        return current;
    }

    public String getCurrent() {
        return current;
    }

    private void pushBack(String page) {
        ensureBackCapacity(backTop + 1);
        backStack[backTop++] = page;
    }

    private String popBack() {
        if (backTop == 0) return null;
        String val = backStack[--backTop];
        backStack[backTop] = null;
        return val;
    }

    private void pushForward(String page) {
        ensureForwardCapacity(forwardTop + 1);
        forwardStack[forwardTop++] = page;
    }

    private String popForward() {
        if (forwardTop == 0) return null;
        String val = forwardStack[--forwardTop];
        forwardStack[forwardTop] = null;
        return val;
    }

    private void clearForward() {
        for (int i = 0; i < forwardTop; i++) forwardStack[i] = null;
        forwardTop = 0;
    }

    private void ensureBackCapacity(int desired) {
        if (desired <= backStack.length) return;
        String[] newArr = new String[backStack.length * 2];
        System.arraycopy(backStack, 0, newArr, 0, backTop);
        backStack = newArr;
    }

    private void ensureForwardCapacity(int desired) {
        if (desired <= forwardStack.length) return;
        String[] newArr = new String[forwardStack.length * 2];
        System.arraycopy(forwardStack, 0, newArr, 0, forwardTop);
        forwardStack = newArr;
    }
}
