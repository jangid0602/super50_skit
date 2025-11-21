public class AverageStack {

    private int[] stack;
    private int topIndex;
    private long runningSum;

    public AverageStack() {
        stack = new int[100000];
        topIndex = -1;
        runningSum = 0;
    }

    public void push(int value) {
        topIndex++;
        stack[topIndex] = value;
        runningSum += value;
    }

    public int pop() {
        if (topIndex < 0) throw new RuntimeException("Stack empty");

        int removed = stack[topIndex];
        topIndex--;
        runningSum -= removed;
        return removed;
    }

    public int top() {
        if (topIndex < 0) throw new RuntimeException("Stack empty");
        return stack[topIndex];
    }

    public double getAverage() {
        if (topIndex < 0) return 0.0;
        return (double) runningSum / (topIndex + 1);
    }
}
