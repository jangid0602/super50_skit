public class EncryptedPalindromeSolution {
    private static String decryptString(String encrypted) {
        StringBuilder decrypted = new StringBuilder(encrypted);
        int len = decrypted.length();
        for (int i = 0; i < len; i++) {
            char ch = decrypted.charAt(i);
            if (ch == 'a') {
                decrypted.setCharAt(i, 'e');
            } else if (ch == 'e') {
                decrypted.setCharAt(i, 'i');
            } else if (ch == 'i') {
                decrypted.setCharAt(i, 'o');
            } else if (ch == 'o') {
                decrypted.setCharAt(i, 'u');
            } else if (ch == 'u') {
                decrypted.setCharAt(i, 'a');
            }
        }
        return decrypted.toString();
    }

    private static boolean checkPalindrome(String string) {
        if (string == null || string.length() <= 1) return true;
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkEncryptedPalindrome(String s) {
        return checkPalindrome(decryptString(s));
    }

    public static void main(String[] args) {
        String s = "vutuv";
        System.out.println(checkPalindrome(s));
    }
}
