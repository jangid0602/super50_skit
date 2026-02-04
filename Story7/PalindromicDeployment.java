import java.util.Scanner;
/*
discription: This program finds the minimum number of characters to insert so that the string becomes a palindrome.
author: Aman Jeet Singh
*/

public class PalindromicDeployment {

    static int longestPalindromicSubseq(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int span = 2; span <= len; span++) {
            for (int i = 0; i <= len - span; i++) {
                int j = i + span - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (span > 2 ? dp[i + 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    static int minInsertions(String s) {
        int lps = longestPalindromicSubseq(s);
        return s.length() - lps;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter string S: ");
        String s = scan.next();

        System.out.println();
        System.out.println("S: \"" + s + "\"");
        System.out.println("Minimum insertions for palindrome: " + minInsertions(s));
        scan.close();
    }
}
