package Week3_5;

public class SpyCipher {
    // Returns the extra character present in scrambled compared to original.
    public static char findExtraChar(String original, String scrambled) {
        int[] freq = new int[256];
        for (char c : scrambled.toCharArray()) freq[c]++;
        for (char c : original.toCharArray()) freq[c]--;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) return (char) i;
        }
        return '\0';
    }
}
