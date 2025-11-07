import java.util.*;

public class Solution {

    // 1. The Trendsetter Score
    // Brute-force sliding windows: for each window compute frequency map and check if there is a unique maximum.
    public int trendsetterScore(List<Integer> posts, int windowSize) {
        if (windowSize <= 0 || windowSize > posts.size()) return 0;
        int scoreCount = 0;

        for (int start = 0; start + windowSize <= posts.size(); start++) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int i = start; i < start + windowSize; i++) {
                int postId = posts.get(i);
                frequencyMap.put(postId, frequencyMap.getOrDefault(postId, 0) + 1);
            }

            int maxFrequency = 0;
            int maxCountOfPostsWithMaxFreq = 0;
            for (int freq : frequencyMap.values()) {
                if (freq > maxFrequency) {
                    maxFrequency = freq;
                    maxCountOfPostsWithMaxFreq = 1;
                } else if (freq == maxFrequency) {
                    maxCountOfPostsWithMaxFreq++;
                }
            }

            // If there is exactly one post with maximum frequency and maxFrequency > 0, it's a trendsetter
            if (maxFrequency > 0 && maxCountOfPostsWithMaxFreq == 1) {
                scoreCount++;
            }
        }

        return scoreCount;
    }

    // 2. Encoded String Subsets - check if any permutation of substring exists as contiguous segment in superstring.
    // Brute-force: compare frequency arrays for each substring of length m.
    public boolean encodedStringSubsets(String superstring, String substring) {
        int n = superstring.length();
        int m = substring.length();
        if (m == 0) return true;
        if (m > n) return false;

        int[] targetFreq = new int[26];
        for (char c : substring.toCharArray()) {
            if (c >= 'a' && c <= 'z') targetFreq[c - 'a']++;
            else if (c >= 'A' && c <= 'Z') targetFreq[Character.toLowerCase(c) - 'a']++;
            else {
                // For simplicity consider any non-letter as part of charset; we'll compare raw bytes
                // But problem's examples assume lowercase letters; keep it simple here.
                return false;
            }
        }

        for (int start = 0; start + m <= n; start++) {
            int[] windowFreq = new int[26];
            boolean windowValid = true;
            for (int i = start; i < start + m; i++) {
                char c = superstring.charAt(i);
                if (c >= 'a' && c <= 'z') windowFreq[c - 'a']++;
                else if (c >= 'A' && c <= 'Z') windowFreq[Character.toLowerCase(c) - 'a']++;
                else { windowValid = false; break; }
            }
            if (!windowValid) continue;
            boolean same = true;
            for (int j = 0; j < 26; j++) {
                if (windowFreq[j] != targetFreq[j]) { same = false; break; }
            }
            if (same) return true;
        }

        return false;
    }

    // 3. E-Commerce Funnel Analysis - find most frequent 2-step path for any user.
    // Brute-force: group pages per user preserving order; for each user's consecutive pairs, count frequency.
    public String eCommerceFunnelMostFrequentPath(List<String> actions) {
        // Parse actions "userID,pageID"
        Map<String, List<String>> pagesByUser = new HashMap<>();
        for (String action : actions) {
            String trimmed = action.trim();
            if (trimmed.isEmpty()) continue;
            String[] parts = trimmed.split(",", 2);
            if (parts.length != 2) continue;
            String userId = parts[0];
            String pageId = parts[1];
            pagesByUser.putIfAbsent(userId, new ArrayList<>());
            pagesByUser.get(userId).add(pageId);
        }

        Map<String, Integer> pathFrequency = new HashMap<>();
        for (List<String> pages : pagesByUser.values()) {
            for (int i = 0; i + 1 < pages.size(); i++) {
                String path = pages.get(i) + "," + pages.get(i + 1);
                pathFrequency.put(path, pathFrequency.getOrDefault(path, 0) + 1);
            }
        }

        if (pathFrequency.isEmpty()) return "";

        int maxFrequency = 0;
        // find lexicographically smallest among the ones with max frequency
        String bestPath = null;
        for (Map.Entry<String, Integer> entry : pathFrequency.entrySet()) {
            String path = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFrequency) {
                maxFrequency = freq;
                bestPath = path;
            } else if (freq == maxFrequency) {
                if (bestPath == null || path.compareTo(bestPath) < 0) {
                    bestPath = path;
                }
            }
        }

        return bestPath == null ? "" : bestPath;
    }

    // 4. Maximal Pair Matching - maximum number of pairs with sum k (each element used at most once).
    // Brute-force using counts.
    public int maximalPairMatching(List<Integer> nums, int targetSum) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        int totalPairs = 0;

        for (Integer value : new ArrayList<>(counts.keySet())) {
            int complement = targetSum - value;
            if (!counts.containsKey(value) || counts.get(value) == 0) continue;

            if (value == complement) {
                // pairs from same number
                int pairsFromSame = counts.get(value) / 2;
                totalPairs += pairsFromSame;
                counts.put(value, counts.get(value) - pairsFromSame * 2);
            } else {
                if (!counts.containsKey(complement) || counts.get(complement) == 0) continue;
                int availablePairs = Math.min(counts.get(value), counts.get(complement));
                totalPairs += availablePairs;
                counts.put(value, counts.get(value) - availablePairs);
                counts.put(complement, counts.get(complement) - availablePairs);
            }
        }

        return totalPairs;
    }

    // 5. Subarray Color Balance - longest subarray where count(1) == count(2). zeros allowed but don't affect counts.
    // Brute-force: check all subarrays.
    public int subarrayColorBalance(List<Integer> nums) {
        int n = nums.size();
        int longestLength = 0;

        for (int start = 0; start < n; start++) {
            int countOnes = 0;
            int countTwos = 0;
            for (int end = start; end < n; end++) {
                int val = nums.get(end);
                if (val == 1) countOnes++;
                else if (val == 2) countTwos++;
                // zeros (0) are ignored
                if (countOnes == countTwos) {
                    int currentLen = end - start + 1;
                    if (currentLen > longestLength) longestLength = currentLen;
                }
            }
        }

        return longestLength;
    }

    // 6. Text Editor Non-Overlapping Replace
    // Replace all non-overlapping occurrences of findStr with replaceStr. After replacement, search continues after replaced region.
    public String nonOverlappingReplace(String text, String findStr, String replaceStr) {
        if (findStr == null || findStr.length() == 0) return text; // nothing to find
        StringBuilder resultBuilder = new StringBuilder();
        int index = 0;
        while (index < text.length()) {
            // check if findStr matches at current position
            if (index + findStr.length() <= text.length()
                    && text.substring(index, index + findStr.length()).equals(findStr)) {
                // append replaceStr and jump ahead by findStr.length (non-overlapping)
                resultBuilder.append(replaceStr);
                index += findStr.length();
            } else {
                resultBuilder.append(text.charAt(index));
                index++;
            }
        }
        return resultBuilder.toString();
    }

    // 7. Log File Compaction (run-length encoding) of space-separated log levels.
    public String logFileCompaction(String logsLine) {
        // Split preserving tokens
        String[] tokens = logsLine.trim().split("\\s+");
        if (tokens.length == 0 || (tokens.length == 1 && tokens[0].isEmpty())) return "";

        StringBuilder compacted = new StringBuilder();
        String currentToken = tokens[0];
        int runCount = 1;

        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals(currentToken)) {
                runCount++;
            } else {
                // flush current run
                if (compacted.length() > 0) compacted.append(" ");
                compacted.append(currentToken).append("(").append(runCount).append(")");
                // start new run
                currentToken = token;
                runCount = 1;
            }
        }
        // flush last run
        if (compacted.length() > 0) compacted.append(" ");
        compacted.append(currentToken).append("(").append(runCount).append(")");

        return compacted.toString();
    }

    // 8. E-commerce SKU Normalization
    // Valid format: CATEGORY-ID-SIZE where CATEGORY 3-4 letters, ID 4-6 digits, SIZE in {S,M,L,XL}
    public String skuNormalizer(String sku) {
        if (sku == null) return "INVALID";
        String trimmedUpper = sku.trim().toUpperCase();
        String[] parts = trimmedUpper.split("-");
        if (parts.length != 3) return "INVALID";

        String category = parts[0];
        String id = parts[1];
        String size = parts[2];

        // Validate category letters length 3-4 and only letters
        if (category.length() < 3 || category.length() > 4) return "INVALID";
        for (char c : category.toCharArray()) {
            if (!Character.isLetter(c)) return "INVALID";
        }

        // Validate id digits length 4-6
        if (id.length() < 4 || id.length() > 6) return "INVALID";
        for (char c : id.toCharArray()) {
            if (!Character.isDigit(c)) return "INVALID";
        }

        // Validate size
        Set<String> validSizes = new HashSet<>(Arrays.asList("S", "M", "L", "XL"));
        if (!validSizes.contains(size)) return "INVALID";

        // If all good, return normalized (already uppercased)
        return category + "-" + id + "-" + size;
    }

    // 9. Chat Message Redaction
    // Replace all occurrences (including inside other words) of any banned word with asterisks of same length.
    // Apply banned words sequentially.
    public String chatMessageRedaction(String message, List<String> bannedWords) {
        if (message == null || message.isEmpty() || bannedWords == null || bannedWords.isEmpty())
            return message;

        String currentMessage = message;
        for (String banned : bannedWords) {
            if (banned == null || banned.length() == 0) continue;
            StringBuilder nextMessageBuilder = new StringBuilder();
            int pointer = 0;
            while (pointer < currentMessage.length()) {
                if (pointer + banned.length() <= currentMessage.length()
                        && currentMessage.substring(pointer, pointer + banned.length()).equals(banned)) {
                    // Replace with asterisks
                    for (int a = 0; a < banned.length(); a++) nextMessageBuilder.append('*');
                    pointer += banned.length(); // non-overlapping within same banned word pass
                } else {
                    nextMessageBuilder.append(currentMessage.charAt(pointer));
                    pointer++;
                }
            }
            currentMessage = nextMessageBuilder.toString();
        }
        return currentMessage;
    }

    // 10. Resume Keyword Versioning - similarity score using min frequency counts.
    public int resumeKeywordSimilarityScore(List<String> resumeV1, List<String> resumeV2) {
        Map<String, Integer> freqV1 = new HashMap<>();
        Map<String, Integer> freqV2 = new HashMap<>();

        for (String word : resumeV1) {
            if (word == null) continue;
            String key = word;
            freqV1.put(key, freqV1.getOrDefault(key, 0) + 1);
        }
        for (String word : resumeV2) {
            if (word == null) continue;
            String key = word;
            freqV2.put(key, freqV2.getOrDefault(key, 0) + 1);
        }

        int score = 0;
        for (Map.Entry<String, Integer> entry : freqV1.entrySet()) {
            String keyword = entry.getKey();
            int countInV1 = entry.getValue();
            int countInV2 = freqV2.getOrDefault(keyword, 0);
            score += Math.min(countInV1, countInV2);
        }

        return score;
    }
}
