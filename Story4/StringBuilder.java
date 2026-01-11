import java.util.*;

/**
 * @filename - StringBuilder.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {

    String compress(String s, int index, int count) {

        // base case: last character
        if (index == s.length() - 1) {
            return count + String.valueOf(s.charAt(index));
        }

        // if current character equals next
        if (s.charAt(index) == s.charAt(index + 1)) {
            return compress(s, index + 1, count + 1);
        }

        // if character changes
        return count + String.valueOf(s.charAt(index)) + compress(s, index + 1, 1);
    }
}

public class StringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input = sc.nextLine();
        Solution s = new Solution();
        if (input.length() == 0) {
            System.out.println("");
        } else {
            System.out.println("Compressed string:");
            System.out.println(s.compress(input, 0, 1));
        }
    }
}
