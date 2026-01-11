/**
 * filename- RecursionOnStrings.java
 * description- This will perform most of the Recursion on Strings. 
 * author- Agrani Gupta
 */
package Story5;

// 4
public class RecursionOnStrings {
    boolean isPalindrome(String string) {
        return checkPalindrome(string, 0, string.length() - 1);
    }

    boolean checkPalindrome(String string, int start, int end) {

        if (start >= end) {
            return true;
        }
        if (string.charAt(start) != string.charAt(end)) {
            return false;
        }
        return checkPalindrome(string, start + 1, end - 1);

    }
}