
package Story3;

import java.util.*;

public class AverageStack {
    List<Integer> stack = new ArrayList<>();

    AverageStack() {
    }

    void push(int value) {
        stack.add(value);
    }

    int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    float getAverage() {
        if (stack.isEmpty()) {
            return 0; // or throw exception
        }
        float sum = 0;
        for (int num : stack) {
            sum += num;
        }
        return sum / stack.size();
    }
}
