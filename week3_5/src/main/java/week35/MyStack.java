public class MyStack {
    private ListNode<String> top;

    public MyStack() {
        top = null;
    }

    void push(String value) {
        if (top == null) top = new ListNode<>(value);
        else top = new ListNode<>(value, top);
    }

    String pop() {
        if (top == null) return null;
        String val = top.value;
        top = top.next;
        return val;
    }

    String peek() {
        return top == null ? null : top.value;
    }
}
