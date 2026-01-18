/**
 * @Filename- WordMirror.java
 * @Description- In this we check that if a string is palindrome or not
 * @Author- Arman Agrawal
 */

public class WordMirror {

    public static boolean isPalindrome(String word, int left, int right) {
        if (left >= right) return true;
        if (word.charAt(left) != word.charAt(right)) return false;
        return isPalindrome(word, left + 1, right - 1);
    }
}
