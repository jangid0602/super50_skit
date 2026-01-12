
/**
 * @author : Agrani Gupta
 * description:To solve problems on concepts like sliding window and hashmaps
 **/

import java.util.*;

public class HashmapAndStringProblems {

    int trendScore(int posts[], int k) {
        if (k > posts.length)
            return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int score = 0;

        // initialize first window
        for (int i = 0; i < k; i++) {
            freq.put(posts[i], freq.getOrDefault(posts[i], 0) + 1);
        }

        // helper function to check if there’s a unique most frequent post
        if (hasTrendsetter(freq))
            score++;

        // slide the window
        for (int i = k; i < posts.length; i++) {
            int outgoing = posts[i - k];
            int incoming = posts[i];

            // remove outgoing element
            freq.put(outgoing, freq.get(outgoing) - 1);
            if (freq.get(outgoing) == 0)
                freq.remove(outgoing);

            // add incoming element
            freq.put(incoming, freq.getOrDefault(incoming, 0) + 1);

            if (hasTrendsetter(freq))
                score++;
        }

        return score;
    }

    private boolean hasTrendsetter(Map<Integer, Integer> freq) {
        int maxFreq = 0, countMax = 0;
        for (int f : freq.values()) {
            if (f > maxFreq) {
                maxFreq = f;
                countMax = 1;
            } else if (f == maxFreq) {
                countMax++;
            }
        }
        return countMax == 1; // only one element with highest frequency
    }

    private void calPermutation(char[] arr, int i, List<String> ans) {
        if (i == arr.length) {
            ans.add(new String(arr));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            calPermutation(arr, i + 1, ans);
            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean isSubstring(String superString, String subString) {
        List<String> ans = new ArrayList<>();
        calPermutation(subString.toCharArray(), 0, ans);

        for (String perm : ans) {
            if (superString.contains(perm)) {
                return true;
            }
        }
        return false;
    }

    public String mostFrequent2StepPath(String[] actions) {
        Map<String, List<String>> userPages = new HashMap<>();

        // Step 1: Group pages by user
        for (String action : actions) {
            String[] parts = action.split(",");
            String user = parts[0];
            String page = parts[1];
            userPages.computeIfAbsent(user, k -> new ArrayList<>()).add(page);
        }

        // Step 2: Count all 2-step paths
        Map<String, Integer> pathCount = new HashMap<>();

        for (List<String> pages : userPages.values()) {
            for (int i = 0; i < pages.size() - 1; i++) {
                String path = pages.get(i) + "->" + pages.get(i + 1);
                pathCount.put(path, pathCount.getOrDefault(path, 0) + 1);
            }
        }

        // Step 3: Find most frequent path (tie -> lexicographically smallest)
        String result = "";
        int maxFreq = 0;

        for (String path : pathCount.keySet()) {
            int freq = pathCount.get(path);
            if (freq > maxFreq || (freq == maxFreq && path.compareTo(result) < 0)) {
                maxFreq = freq;
                result = path;
            }
        }

        return result;
    }

    public int maxNumberOfPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            int complement = k - num;

            if (freq.getOrDefault(complement, 0) > 0) {
                // found a pair
                pairs++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                // store current number for future pairing
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return pairs;
    }

    public int longestColorBalancedSubarray(int[] nums) {
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int balance = 0, maxLen = 0;

        // initial balance 0 seen before array starts
        firstSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                balance += 1; // red
            else if (nums[i] == 2)
                balance -= 1; // blue
            // 0 → neutral, so no change

            if (firstSeen.containsKey(balance)) {
                maxLen = Math.max(maxLen, i - firstSeen.get(balance));
            } else {
                firstSeen.put(balance, i);
            }
        }

        return maxLen;
    }

    public String nonOverlappingReplace(String text, String find_str, String replace_str) {
        if (find_str.isEmpty())
            return text; // avoid infinite loop

        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = text.length();
        int m = find_str.length();

        while (i < n) {
            // check if substring starting at i matches find_str
            if (i + m <= n && text.substring(i, i + m).equals(find_str)) {
                result.append(replace_str);
                i += m; // move past the replaced segment (non-overlapping)
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public String compactLogs(String logs) {
        if (logs == null || logs.isEmpty())
            return "";

        String[] parts = logs.split(" ");
        StringBuilder result = new StringBuilder();

        String current = parts[0];
        int count = 1;

        for (int i = 1; i < parts.length; i++) {
            if (parts[i].equals(current)) {
                count++;
            } else {
                result.append(current).append(" ").append(count).append(" ");
                current = parts[i];
                count = 1;
            }
        }

        // append last run
        result.append(current).append(" ").append(count);

        return result.toString().trim();
    }

    public String normalizeSKU(String sku) {
        if (sku == null || sku.isEmpty())
            return "INVALID";

        // convert to uppercase
        sku = sku.toUpperCase();

        // split by '-'
        String[] parts = sku.split("-");
        if (parts.length != 3)
            return "INVALID";

        String category = parts[0];
        String id = parts[1];
        String size = parts[2];

        if (category.length() < 3 || category.length() > 4)
            return "INVALID";
        for (char c : category.toCharArray()) {
            if (c < 'A' || c > 'Z')
                return "INVALID";
        }

        if (id.length() < 4 || id.length() > 6)
            return "INVALID";
        for (char c : id.toCharArray()) {
            if (c < '0' || c > '9')
                return "INVALID";
        }

        if (!(size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")))
            return "INVALID";

        return category + "-" + id + "-" + size;
    }

    public String redactMessage(String message, List<String> bannedWords) {
        if (message == null || message.isEmpty())
            return message;
        if (bannedWords == null || bannedWords.isEmpty())
            return message;

        // Split message into words (keep spaces manually)
        String[] words = message.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (String banned : bannedWords) {
                if (words[i].equals(banned)) {
                    // replace with same length of asterisks
                    words[i] = "*".repeat(banned.length());
                    break; // no need to check other banned words
                }
            }
        }

        // Join words back into a message
        return String.join(" ", words);
    }

    public int resumeSimilarityScore(String[] resumeV1, String[] resumeV2) {
        Map<String, Integer> freq1 = new HashMap<>();
        Map<String, Integer> freq2 = new HashMap<>();

        // Count frequencies for resumeV1
        for (String word : resumeV1) {
            freq1.put(word, freq1.getOrDefault(word, 0) + 1);
        }

        // Count frequencies for resumeV2
        for (String word : resumeV2) {
            freq2.put(word, freq2.getOrDefault(word, 0) + 1);
        }

        int score = 0;

        // Compare and sum up the minimum frequencies
        for (String key : freq1.keySet()) {
            if (freq2.containsKey(key)) {
                score += Math.min(freq1.get(key), freq2.get(key));
            }
        }

        return score;
    }

}