import java.util.Scanner;

class StringOperations {
    private String text;

    public StringOperations(String text) {
        this.text = text;
    }

    // 1. Append (Using StringBuilder for efficiency)
    public void append(String newString) {
        // A human Java developer would use the standard String concatenation or a StringBuilder.
        // The manual char array copy from the original code was complex and flawed.
        this.text = new StringBuilder(this.text).append(newString).toString();
        System.out.println("Updated String: " + this.text);
    }

    // 2. Count Words (Counts non-space sequences)
    public int countWords() {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // Check for non-whitespace character starting a new word
            if (c != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (c == ' ') {
                inWord = false;
            }
        }
        System.out.println("Word Count: " + count);
        return count;
    }

    // 3. Replace old substring with new substring (Manual implementation)
    public void replace(String oldStr, String newStr) {
        // A manual implementation requires a loop to check for occurrences and rebuild the string.
        if (oldStr == null || oldStr.isEmpty()) {
            System.out.println("Old string cannot be empty.");
            return;
        }

        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        int current = this.text.indexOf(oldStr, lastIndex);

        while (current != -1) {
            // Append the part before the match
            result.append(this.text, lastIndex, current);
            // Append the replacement
            result.append(newStr);
            // Move the search past the replaced section
            lastIndex = current + oldStr.length();
            // Search for the next occurrence
            current = this.text.indexOf(oldStr, lastIndex);
        }

        // Append the remaining part of the original string
        result.append(this.text, lastIndex, this.text.length());

        this.text = result.toString();
        System.out.println("Updated String: " + this.text);
    }

    // 4. Palindrome Check
    public boolean isPalindrome() {
        // Cleaned up the logic to handle spaces and case in a straightforward manner
        String cleanText = this.text.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] arr = cleanText.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                System.out.println("No, the string is not a palindrome.");
                return false;
            }
            left++;
            right--;
        }

        System.out.println("Yes, the string is a palindrome.");
        return true;
    }

    // 5. Splice (manual substring)
    public void splice(int start, int end) {
        if (start < 0 || end > this.text.length() || start >= end) {
            System.out.println("Invalid range!");
            return;
        }
        
        // Manual implementation by looping over chars
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(this.text.charAt(i));
        }
        System.out.println("Spliced String: " + result.toString());
    }

    // 6. Split (manual split)
    public void split(char delimiter) {
        char[] arr = this.text.toCharArray();
        StringBuilder temp = new StringBuilder();
        System.out.println("--- Split Results ---");
        
        for (char c : arr) {
            if (c == delimiter) {
                if (temp.length() > 0) {
                    System.out.println(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(c);
            }
        }
        
        // Print the last token if it's not empty
        if (temp.length() > 0) {
            System.out.println(temp.toString());
        }
        System.out.println("---------------------");
    }

    // 7. Max Repeating character
    public void maxRepeatingChar() {
        if (this.text.isEmpty()) {
            System.out.println("String is empty.");
            return;
        }
        
        // Assuming ASCII characters (0-255)
        int[] freq = new int[256];
        for (char c : this.text.toCharArray()) {
            freq[c]++;
        }

        int max = -1;
        char maxChar = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = (char) i;
            }
        }
        System.out.println("Max Repeating Character: '" + maxChar + "' (Repeated " + max + " times)");
    }

    // 8. Sort (manual bubble sort)
    public void sort() {
        char[] arr = this.text.toCharArray();
        int n = arr.length;
        // Bubble sort implementation
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        this.text = new String(arr);
        System.out.println("Sorted String: " + this.text);
    }

    // 9. Shift (manual left rotation)
    public void shift(int n) {
        char[] arr = this.text.toCharArray();
        int len = arr.length;
        if (len == 0) return;
        
        // Normalize n to prevent unnecessary full rotations
        n = n % len;
        
        // Implement rotation using a temporary array (for simplicity and clarity)
        char[] shifted = new char[len];
        
        // Part 1: Move the end of the string to the start
        // e.g., "ABCD" shifted by 1 -> "DABC". Start copy from index 3 (D)
        for (int i = 0; i < n; i++) {
            shifted[i] = arr[len - n + i];
        }
        
        // Part 2: Move the start of the string to the remainder
        // e.g., "ABCD" shifted by 1 -> "DABC". Copy A, B, C
        for (int i = 0; i < len - n; i++) {
            shifted[n + i] = arr[i];
        }
        
        this.text = new String(shifted);
        System.out.println("Shifted String: " + this.text);
    }

    // 10. Reverse
    public void reverse() {
        char[] arr = this.text.toCharArray();
        int left = 0, right = arr.length - 1;
        
        // Standard two-pointer swap for reversal
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        this.text = new String(arr);
        System.out.println("Reversed String: " + this.text);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an initial string: ");
        String initial = sc.nextLine();
        StringOperations s = new StringOperations(initial);

        while (true) {
            System.out.println("\n--- Available Operations ---");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace Substring");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Splice (Substring)");
            System.out.println("6. Split by Delimiter");
            System.out.println("7. Max Repeating Character");
            System.out.println("8. Sort Characters");
            System.out.println("9. Shift (Rotate)");
            System.out.println("10. Reverse");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            // Input handling to prevent program crash if non-int is entered
            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // consume invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String newStr = sc.nextLine();
                    s.append(newStr);
                    break;
                case 2:
                    s.countWords();
                    break;
                case 3:
                    System.out.print("Enter substring to replace: ");
                    String oldStr = sc.nextLine();
                    System.out.print("Enter new substring: ");
                    String newSub = sc.nextLine();
                    s.replace(oldStr, newSub);
                    break;
                case 4:
                    s.isPalindrome();
                    break;
                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();
                    sc.nextLine(); // consume newline
                    s.splice(start, end);
                    break;
                case 6:
                    System.out.print("Enter delimiter character (e.g., ',' or ' '): ");
                    String delimiterInput = sc.nextLine();
                    char delimiter = delimiterInput.isEmpty() ? ' ' : delimiterInput.charAt(0);
                    s.split(delimiter);
                    break;
                case 7:
                    s.maxRepeatingChar();
                    break;
                case 8:
                    s.sort();
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // consume newline
                    s.shift(n);
                    break;
                case 10:
                    s.reverse();
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}