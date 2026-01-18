import java.util.Scanner;

/**
 * @Filename-WordMirror.java
 * @Description- This recusively checks whether the string is palindrome or not.
 * @Author-Aditya Virmani
 */
public class WordMirror {
    static boolean isPalindrome(String inputString, int start, int end) {

        if (start >= end)
            return true;

        if (inputString.charAt(start) != inputString.charAt(end))
            return false;

        return isPalindrome(inputString, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while (true) {
            try {
                System.out.print("Enter a word: ");
                input = userInput.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("Output: " + result);

        userInput.close();
    }
}
