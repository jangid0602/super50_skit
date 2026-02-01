

/**
 * @Filename- PalindromicDeployment.java
 * @Description- This is to find the minimum number of characters to insert to
make the entire string a palindrome.
 * @Author- Arman Agrawal
 */




public class PalindromicDeployment {

    static int calculateMinimumInsertionsForPalindrome(
            String originalString,
            String reversedString,
            int length) {

        int[][] longestCommonSubsequence =
                new int[length + 1][length + 1];

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {

                if (originalString.charAt(i - 1)
                        == reversedString.charAt(j - 1)) {

                    longestCommonSubsequence[i][j] =
                            1 + longestCommonSubsequence[i - 1][j - 1];

                } else {
                    longestCommonSubsequence[i][j] =
                            Math.max(
                                longestCommonSubsequence[i - 1][j],
                                longestCommonSubsequence[i][j - 1]
                            );
                }
            }
        }

        int longestPalindromicSubsequence =
                longestCommonSubsequence[length][length];

        return length - longestPalindromicSubsequence;
    }

    public static void main(String[] args) {

        System.out.print("Enter string: ");
        String originalString = InputUtil.readString();

        String reversedString =
                new StringBuilder(originalString).reverse().toString();

        int length = originalString.length();

        int minimumInsertions =
                calculateMinimumInsertionsForPalindrome(
                        originalString,
                        reversedString,
                        length
                );

        System.out.println(
                "Minimum insertions to make palindrome: "
                + minimumInsertions
        );
    }
}
