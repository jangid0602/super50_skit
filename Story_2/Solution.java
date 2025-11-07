import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    private int[] array;

    Solution() {
        // do nothing
    }

    Solution(int[] array) {
        this.array = array;
    }

    void setArray(int[] array) {
        this.array = array;
    }

    int getTrendsetterWindows(int windowSize) {
        int size = array.length;
        int count = 0;
        for (int i = 0; i <= size - windowSize; i++) {
            HashMap<Integer, Integer> Frequency = new HashMap<>();
            for (int j = i; j < i + windowSize; j++) {
                int key = array[j];
                Frequency.put(key, Frequency.getOrDefault(key, 0) + 1);
            }
            if (Frequency.size() > 1) {
                if (new HashSet<>(Frequency.values()).size() > 1) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean checkPermutationSubstring(String superString, String subString) {
        int superStringSize = superString.length();
        int subStringSize = subString.length();
        HashMap<Character, Integer> frequencySubstring = new HashMap<>();

        for (char ch : subString.toCharArray()) {
            frequencySubstring.put(ch, frequencySubstring.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i <= superStringSize - subStringSize; i++) {
            HashMap<Character, Integer> frequency = new HashMap<>();
            for (int j = i; j < i + subStringSize; j++) {
                frequency.put(superString.charAt(j), frequency.getOrDefault(superString.charAt(j), 0) + 1);
            }
            if (frequency.equals(frequencySubstring)) {
                return true;
            }
        }
        return false;
    }

    int countMaximumPairs(int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int count = 0;

        for (int num : array) {
            int complement = k - num;

            if (frequency.getOrDefault(complement, 0) > 0) {
                // Pair found, decrease complement count
                frequency.put(complement, frequency.get(complement) - 1);
                count++;
            } else {
                // Store current number for future pairing
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    int longestBalancedSubarray() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // balance 0 at index -1
        int balance = 0;
        int maxLen = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                balance++; // red
            else if (array[i] == 2)
                balance--; // blue
            // neutral (0) → balance unchanged

            if (map.containsKey(balance)) {
                maxLen = Math.max(maxLen, i - map.get(balance));
            } else {
                map.put(balance, i);
            }
        }
        return maxLen;
    }

    String nonOverlappingReplace(String text, String findStr, String replaceStr) {
        if (findStr.isEmpty())
            return text; // avoid infinite loop
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i + findStr.length() <= text.length() && text.substring(i, i + findStr.length()).equals(findStr)) {
                result.append(replaceStr);
                i += findStr.length(); // move past the replaced section
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    String compactLogs(String logs) {
        if (logs == null || logs.isEmpty())
            return "";

        String[] parts = logs.split(" ");
        String result = "";

        String current = parts[0];
        int count = 1;

        for (int i = 1; i < parts.length; i++) {
            if (parts[i].equals(current)) {
                count++;
            } else {
                result += current + "(" + count + ") ";
                current = parts[i];
                count = 1;
            }
        }

        // Add the last one
        result += current + "(" + count + ")";

        return result.trim();
    }

    String normalizeSKU(String sku) {
        if (sku == null || sku.isEmpty())
            return "INVALID";

        sku = sku.toUpperCase();

        String[] parts = sku.split("-");
        if (parts.length != 3)
            return "INVALID";

        String category = parts[0];
        String id = parts[1];
        String size = parts[2];

        // Validate category: 3–4 letters only
        if (!category.matches("^[A-Z]{3,4}$"))
            return "INVALID";

        // Validate ID: 4–6 digits only
        if (!id.matches("^[0-9]{4,6}$"))
            return "INVALID";

        // Validate size: must be S, M, L, or XL
        if (!(size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")))
            return "INVALID";

        return category + "-" + id + "-" + size;
    }

    String redactMessage(String message, String[] bannedWords) {
        for (String banned : bannedWords) {
            String replacement = "*".repeat(banned.length());
            message = message.replaceAll("\\b" + banned + "\\b", replacement);
        }
        return message;
    }

    int calculateSimilarityScore(String[] resumeV1, String[] resumeV2) {
        HashMap<String, Integer> freqV1 = new HashMap<>();
        HashMap<String, Integer> freqV2 = new HashMap<>();

        // Count frequency in resumeV1
        for (String word : resumeV1) {
            freqV1.put(word, freqV1.getOrDefault(word, 0) + 1);
        }

        // Count frequency in resumeV2
        for (String word : resumeV2) {
            freqV2.put(word, freqV2.getOrDefault(word, 0) + 1);
        }

        int score = 0;
        // Compare and add min frequency for common words
        for (String word : freqV1.keySet()) {
            if (freqV2.containsKey(word)) {
                score += Math.min(freqV1.get(word), freqV2.get(word));
            }
        }

        return score;
    }
}
