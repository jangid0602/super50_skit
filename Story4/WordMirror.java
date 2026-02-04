import java.util.Scanner;

/**
 * Recursively checks whether a given string is a palindrome.
 * 
 * @author Aman Jeet Singh
 */
public class WordMirror {

    /**
     * Checks if a string is a palindrome by comparing characters from both ends.
     * 
     * @param inputString The string to check
     * @param startIndex The starting index
     * @param endIndex The ending index
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String inputString, int startIndex, int endIndex) {
        // Base case: pointers have met or crossed, all characters matched
        if (startIndex >= endIndex) {
            return true;
        }

        // If characters at current positions don't match, not a palindrome
        if (inputString.charAt(startIndex) != inputString.charAt(endIndex)) {
            return false;
        }

        // Recursive case: move both pointers inward and check next pair
        return isPalindrome(inputString, startIndex + 1, endIndex - 1);
    }

    /**
     * Main method to interact with user and check if input string is a palindrome.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String userInputString = "";

        // Input validation loop: ensures non-empty string input
        while (true) {
            try {
                System.out.print("Enter a word: ");
                userInputString = inputScanner.nextLine();

                if (userInputString.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input!");
            }
        }

        boolean isPalindromeResult = isPalindrome(userInputString, 0, userInputString.length() - 1);
        System.out.println("Output: " + isPalindromeResult);

        inputScanner.close();
    }
}
