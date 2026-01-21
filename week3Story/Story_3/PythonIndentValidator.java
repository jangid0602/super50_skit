/*
 *Filename - PythonIndentValidator.java
 *Description - Validates Python indentation rules.
 *Author - Nancy Jain
*/

import java.util.*;

public class PythonIndentValidator {

    public static boolean isValidIndentation(List<String> codeLines) {
        Stack<Integer> indentStack = new Stack<>();
        indentStack.push(0);
        boolean previousLineStart = false;

        for (String line : codeLines) {
            if (line.trim().isEmpty())
                continue;

            int spaceCount = 0;
            for (char ch : line.toCharArray()) {
                if (ch == ' ') 
                    spaceCount++;
                else 
                    break;
            }
            int currIndentation = spaceCount;
            if (currIndentation > indentStack.peek()) {
                if (!previousLineStart)
                    return false;

                indentStack.push(currIndentation);
            }
            else if (currIndentation < indentStack.peek()) {
                while (!indentStack.isEmpty() && indentStack.peek() > currIndentation) {
                    indentStack.pop();
                }     
                if (indentStack.isEmpty() || indentStack.peek() != currIndentation)
                    return false;
            }           // Detect a new block only if last non-space character is ':'
            String trimmed = line.trim();
            previousLineStart = !trimmed.isEmpty() && trimmed.charAt(trimmed.length() - 1) == ':';
        }

        return true;
    }

    public static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.print("Invalid input! Enter an integer: ");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.print("Enter number of lines: ");
            int totalLines = readInt(sc);
            sc.nextLine();

            List<String> codeLines = new ArrayList<>();

            System.out.println("\nEnter Python code lines:");
            for (int i = 0; i < totalLines; i++) {
                codeLines.add(sc.nextLine());
            }
            boolean isValid = isValidIndentation(codeLines);
            if (isValid)
                System.out.println("\nIndentation is VALID.");
            else
                System.out.println("\nIndentation is INVALID.");

            System.out.println("Do you want to continue (yes-1 no-0):");
            int ask = readInt(sc);
            if(ask == 0) running = false;

        } while (running);
    }
}
