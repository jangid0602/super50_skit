import java.util.Scanner;

/**
 * @filename - WordMirror.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}

public class WordMirror {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (s.isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
