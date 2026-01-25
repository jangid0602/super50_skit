/**
 * <p>This class solves The Word Mirror problem to check whether the string is pallindrome or not using recursion) </p>
 *
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public class TheWordMirror {
    static boolean checkPalindrome(String inputString) {
        if (inputString.length() <= 1)
            return true;
        if (inputString.charAt(0) != inputString.charAt(inputString.length() - 1))
            return false;
        return checkPalindrome(inputString.substring(1, inputString.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scannerobj = new Scanner(System.in);
        System.out.println("Enter the string to check whether it is palindrome or not  ");
        String inputString = scannerobj.next();
        System.out.println(checkPalindrome(inputString));

    }
}
