import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @filename - Operations.java
 * @description - This is the Operations performed
 * @author - Arman Agrawal
 */


class Operations {

    public static boolean encodedStringSubsets(String s, String sub) {
        Map<Character, Integer> subcount = new HashMap<>();

        for (char x : sub.toCharArray()) {
            subcount.put(x, 1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        int k = sub.length();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (r - left + 1 > k) {
                char leftchar = s.charAt(left);
                windowMap.put(leftchar, windowMap.get(leftchar) - 1);

                if (windowMap.get(leftchar) == 0) {
                    windowMap.remove(leftchar);
                }
                left++;
            }

            if (windowMap.equals(subcount)) {
                return true;
            }
        }
        return false;
    }

    public static int trendsetterScore(int[] posts, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int n = posts.length;

        for (int i = 0; i < n; i++) {
            freq.put(posts[i], freq.getOrDefault(posts[i], 0) + 1);

            if (i >= k) {
                int out = posts[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0)
                    freq.remove(out);
            }

            if (i >= k - 1) {
                int maxi = 0, countmax = 0;

                for (int val : freq.values()) {
                    if (val > maxi) {
                        maxi = val;
                        countmax = 1;
                    } else if (val == maxi) {
                        countmax++;
                    }
                }
                if (countmax == 1)
                    count++;
            }
        }
        return count;
    }

public static int maxPairs(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    int pairs = 0;

    for (int num : new HashSet<>(freq.keySet())) {
        int complement = k - num;

        if (!freq.containsKey(num)) continue;

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


    public static int longestBalanced(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int balance = 0;
        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                balance += 1;
            else if (nums[i] == 2)
                balance -= 1;

            if (mp.containsKey(balance))
                maxi = Math.max(maxi, i - mp.get(balance));
            else
                mp.put(balance, i);
        }

        return maxi;

    }

    public static String[] mySplit(String str, char sp) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == sp) {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(ch);
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        return words.toArray(new String[0]);
    }

    public static String compactLogs(String logs) {
        String[] parts = mySplit(logs, ' ');
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

        return result.toString();
    }

    public static String redactMessage(String message, String[] bannedWords) {
        Set<String> banned = new HashSet<>();
        for (String word : bannedWords) {
            banned.add(word.toLowerCase());
        }

        String result = "";
        String currentWord = "";
        String ban = "";

        for (int i = 0; i <= message.length(); i++) {
            char ch = (i < message.length()) ? message.charAt(i) : ' ';

            if (ch == ' ') {
                char[] w = currentWord.toCharArray();
                for (String b : bannedWords) {
                    char[] banne = b.toCharArray();

                    for (int j = 0; j <= w.length - banne.length; j++) {
                        boolean match = true;
                        for (int k = 0; k < banne.length; k++) {
                            if (currentWord.charAt(j + k) != banne[k]) {
                                match = false;
                                break;
                            }
                        }
                        if (match) {
                            for (int k = 0; k < banne.length; k++) {
                                w[j + k] = '*';
                            }
                        }
                    }
                }
                currentWord = new String(w);
                result += currentWord + " ";
                ban = "";
                currentWord = "";
            } else {
                currentWord += ch;
                ban += '*';
            }
        }
        return result;
    }

    public static String normalizeSKU(String str) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch - 'a' + 'A');
                }
                string = string + ch;
            }
        }

        String pattern = "^[A-Z]{3,4}-[0,9]{4,6}-{S|M|L|XL}";

        if (string.matches(pattern)) {
            return string;
        } else {
            return "INVALID";
        }

    }

    public static int calculateSimilarity(String[] resume1, String[] resume2) {
        HashMap<String, Integer> mp1 = new HashMap<>();
        HashMap<String, Integer> mp2 = new HashMap<>();

        for (String st : resume1) {
            st.toLowerCase();
            mp1.put(st, mp1.getOrDefault(st, 0) + 1);
        }

        for (String st : resume2) {
            st.toLowerCase();
            mp2.put(st, mp2.getOrDefault(st, 0) + 1);
        }
        int score = 0;

        for (String key : mp1.keySet()) {
            if (mp2.containsKey(key)) {
                int a = mp1.get(key);
                int b = mp2.get(key);
                if (a < b) {
                    score += a;
                } else {
                    score += b;
                }
            }
        }
        return score;
    }

    public String replace(String value, String target, String replacement) {
        if (value == null)
            return null;
        if (target == null || target.isEmpty())
            return value;
        if (replacement == null)
            replacement = "";

        String result = "";
        int index = 0;
        int valueLength = value.length();
        int targetLength = target.length();

        while (index < valueLength) {
            boolean match = false;

            if (index + targetLength <= valueLength) {
                match = true;
                for (int j = 0; j < targetLength; j++) {
                    if (value.charAt(index + j) != target.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            }

            if (match) {
                result += replacement;
                index += targetLength;
            } else {
                result += value.charAt(index);
                index++;
            }
        }

        value = result;
        return value;
    }

    public static String mostFrequent2StepPath(String[] actions) {
        Map<String, List<String>> userToPages = new HashMap<>();

        for (String action : actions) {
            String[] parts = action.split(",");
            String user = parts[0];
            String page = parts[1];

            userToPages.putIfAbsent(user, new ArrayList<>());
            userToPages.get(user).add(page);
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