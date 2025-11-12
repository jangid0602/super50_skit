import java.util.*;

/**
 * @filename : Operations.java
 * @description : This class implements various string, hashmap, and array operations
 *                such as encoded subset detection, trendsetter score, log compression,
 *                message redaction, SKU normalization, resume similarity, and more.
 * @author : Aman Jeet Singh
 */
class Operations {

    /**
     * Checks if any permutation of 'sub' exists as a substring in 's'.
     */
    public static boolean encodedStringSubsets(String s, String sub) {
        Map<Character, Integer> subCount = new HashMap<>();
        for (char ch : sub.toCharArray()) {
            subCount.put(ch, subCount.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int k = sub.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            if (windowMap.equals(subCount)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Calculates how many sliding windows of size k have a unique most frequent post.
     */
    public static int trendsetterScore(int[] posts, int k) {
        if (k > posts.length || k <= 0) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int i = 0; i < posts.length; i++) {
            freq.put(posts[i], freq.getOrDefault(posts[i], 0) + 1);

            if (i >= k) {
                int out = posts[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0)
                    freq.remove(out);
            }

            if (i >= k - 1) {
                int maxFreq = 0, maxCount = 0;
                for (int val : freq.values()) {
                    if (val > maxFreq) {
                        maxFreq = val;
                        maxCount = 1;
                    } else if (val == maxFreq) {
                        maxCount++;
                    }
                }
                if (maxCount == 1)
                    count++;
            }
        }

        return count;
    }

    /**
     * Finds the maximum number of pairs in the array whose sum equals k.
     */
    public static int maxPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        for (int num : new HashSet<>(freq.keySet())) {
            if (!freq.containsKey(num)) continue;
            int complement = k - num;

            if (num == complement) {
                pairs += freq.get(num) / 2;
                freq.remove(num);
            } else if (freq.containsKey(complement)) {
                int count = Math.min(freq.get(num), freq.get(complement));
                pairs += count;
                freq.remove(num);
                freq.remove(complement);
            }
        }
        return pairs;
    }

    /**
     * Finds the longest subarray where count(1) == count(2).
     */
    public static int longestBalanced(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        int balance = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) balance++;
            else if (nums[i] == 2) balance--;

            if (seen.containsKey(balance)) {
                maxLength = Math.max(maxLength, i - seen.get(balance));
            } else {
                seen.put(balance, i);
            }
        }

        return maxLength;
    }

    /**
     * Custom split function (avoids using String.split()).
     */
    public static String[] mySplit(String str, char delimiter) {
        List<String> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == delimiter) {
                if (current.length() > 0) {
                    words.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(ch);
            }
        }

        if (current.length() > 0) {
            words.add(current.toString());
        }

        return words.toArray(new String[0]);
    }

    /**
     * Compacts consecutive duplicate logs into "word(count)" format.
     */
    public static String compactLogs(String logs) {
        if (logs == null || logs.isEmpty()) return "";

        String[] parts = mySplit(logs.trim(), ' ');
        StringBuilder result = new StringBuilder();

        String current = parts[0];
        int count = 1;

        for (int i = 1; i < parts.length; i++) {
            if (parts[i].equals(current)) {
                count++;
            } else {
                result.append(current).append("(").append(count).append(") ");
                current = parts[i];
                count = 1;
            }
        }
        result.append(current).append("(").append(count).append(")");

        return result.toString().trim();
    }

    /**
     * Replaces banned words with asterisks in a message.
     */
    public static String redactMessage(String message, String[] bannedWords) {
        if (message == null || message.isEmpty()) return message;
        if (bannedWords == null || bannedWords.length == 0) return message;

        Set<String> banned = new HashSet<>();
        for (String word : bannedWords) banned.add(word.toLowerCase());

        String[] words = message.split(" ");
        for (int i = 0; i < words.length; i++) {
            String lower = words[i].toLowerCase();
            if (banned.contains(lower)) {
                words[i] = "*".repeat(words[i].length());
            }
        }

        return String.join(" ", words);
    }

    /**
     * Validates and normalizes SKU format (CATEGORY-ID-SIZE).
     */
    public static String normalizeSKU(String str) {
        if (str == null || str.trim().isEmpty()) return "INVALID";

        str = str.trim().toUpperCase().replaceAll(" ", "");
        String regex = "^[A-Z]{3,4}-\\d{4,6}-(S|M|L|XL)$";

        return str.matches(regex) ? str : "INVALID";
    }

    /**
     * Calculates similarity score between two resumes based on common words.
     */
    public static int calculateSimilarity(String[] resume1, String[] resume2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : resume1)
            map1.put(word.toLowerCase(), map1.getOrDefault(word.toLowerCase(), 0) + 1);

        for (String word : resume2)
            map2.put(word.toLowerCase(), map2.getOrDefault(word.toLowerCase(), 0) + 1);

        int score = 0;
        for (String word : map1.keySet()) {
            if (map2.containsKey(word)) {
                score += Math.min(map1.get(word), map2.get(word));
            }
        }

        return score;
    }

    /**
     * Replaces all occurrences of target in value with replacement (non-overlapping).
     */
    public String replace(String value, String target, String replacement) {
        if (value == null || target == null || target.isEmpty()) return value;
        if (replacement == null) replacement = "";

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < value.length()) {
            if (i + target.length() <= value.length() && value.substring(i, i + target.length()).equals(target)) {
                result.append(replacement);
                i += target.length();
            } else {
                result.append(value.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    /**
     * Finds the most frequent 2-step page path across users.
     */
    public static String mostFrequent2StepPath(String[] actions) {
        if (actions == null || actions.length == 0) return "";

        Map<String, List<String>> userToPages = new HashMap<>();
        for (String action : actions) {
            String[] parts = action.trim().split(",");
            if (parts.length != 2) continue;
            String user = parts[0].trim();
            String page = parts[1].trim();
            userToPages.computeIfAbsent(user, k -> new ArrayList<>()).add(page);
        }

        Map<String, Integer> pathCount = new HashMap<>();
        for (List<String> pages : userToPages.values()) {
            for (int i = 0; i < pages.size() - 1; i++) {
                String path = pages.get(i) + "," + pages.get(i + 1);
                pathCount.put(path, pathCount.getOrDefault(path, 0) + 1);
            }
        }

        String mostFrequentPath = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : pathCount.entrySet()) {
            String path = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && path.compareTo(mostFrequentPath) < 0)) {
                maxCount = count;
                mostFrequentPath = path;
            }
        }

        return mostFrequentPath;
    }
}
