import java.util.Stack;

public class IndentationValidator {

    public static boolean isValidIndentation(String[] lines) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (String line : lines) {

            int spaces = countSpaces(line);
            int top = stack.peek();

            if (spaces == 0) {
                // Zero indentation: reset stack to only contain 0
                while (stack.size() > 1)
                    stack.pop();
                continue;
            }

            if (spaces > top) {
                // Indentation increased: add new level
                stack.push(spaces);
            }
            else if (spaces == top) {
                // Same level is valid
                continue;
            }
            else {
                // Decrease: pop until we find matching level
                while (!stack.isEmpty() && stack.peek() > spaces)
                    stack.pop();

                if (stack.isEmpty() || stack.peek() != spaces)
                    return false;
            }
        }
        return true;
    }

    private static int countSpaces(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') count++;
            else break;
        }
        return count;
    }
}
