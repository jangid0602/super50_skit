// @filename - Method.java
// @description - Contains implementation of all array, string, and hashmap-related functions such as trendsetterScore, frequency count, rotation, and other logic used by Main.java for the assignment problems.
// @author - Divyansh Tak


import java.util.*;

public class Methods {

    //The Trendsetter Score
   
    static int trendsetterScore(int posts[], int k) {
        int n = posts.length;
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Add current post to map
            map.put(posts[i], map.getOrDefault(posts[i], 0) + 1);

            // Check once window is formed
            if (i >= k - 1) {

                // Find max frequency and how many have that frequency
                int maxFreq = 0, count = 0;
                for (int val : map.values()) {
                    if (val > maxFreq) {
                        maxFreq = val;
                        count = 1;
                    } else if (val == maxFreq) {
                        count++;
                    }
                }

                // trendsetter
                if (count == 1)
                    score++;

                // Remove element going out of window
                int left = posts[i - k + 1];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0)
                    map.remove(left);
            }
        }

        return score;
    }

    //Encoded String Subsets
    static boolean encodedStringSubset(String s, String t) {
        if (t.length() > s.length())
            return false;
        int freqT[] = new int[26];
        int freqS[] = new int[26];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freqT[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqS[c - 'a']++;

            if (i >= t.length()) {
                char left = s.charAt(i - t.length());
                freqS[left - 'a']--;
            }

            boolean same = true;
            for (int j = 0; j < 26; j++) {
                if (freqS[j] != freqT[j]) {
                    same = false;
                    break;
                }
            }
            if (same)
                return true;
        }
        return false;
    }

    //E-Commerce Funnel Analysis
    static String funnelAnalysis(String actions[]) {
        HashMap<String, ArrayList<String>> user = new HashMap<>();

        for (int i = 0; i < actions.length; i++) {
            String str = actions[i];
            String part[] = str.split(",");
            String id = part[0];
            String page = part[1];

            if (!user.containsKey(id)) {
                user.put(id, new ArrayList<String>());
            }
            user.get(id).add(page);
        }

        HashMap<String, Integer> pathCount = new HashMap<>();

        for (String id : user.keySet()) {
            ArrayList<String> list = user.get(id);
            for (int i = 0; i < list.size() - 1; i++) {
                String path = list.get(i) + "," + list.get(i + 1);
                pathCount.put(path, pathCount.getOrDefault(path, 0) + 1);
            }
        }

        String best = "";
        int max = 0;
        for (String key : pathCount.keySet()) {
            int val = pathCount.get(key);
            if (val > max || (val == max && key.compareTo(best) < 0)) {
                max = val;
                best = key;
            }
        }
        return best;
    }

    //Maximal Pair Matching
    static int maximalPairMatching(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int need = k - nums[i];
            if (map.containsKey(need) && map.get(need) > 0) {
                pairs++;
                map.put(need, map.get(need) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return pairs;
    }

    //Subarray Color Balance
    static int subarrayColorBalance(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int bal = 0;
        int maxlen = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                bal++;
            else if (nums[i] == 2)
                bal--;

            if (map.containsKey(bal)) {
                int len = i - map.get(bal);
                if (len > maxlen)
                    maxlen = len;
            } else {
                map.put(bal, i);
            }
        }
        return maxlen;
    }

    //Text Editor Non-Overlapping Replace
    static String textEditorReplace(String text, String find, String rep) {
        String ans = "";
        for (int i = 0; i < text.length();) {
            if (i + find.length() <= text.length() && text.substring(i, i + find.length()).equals(find)) {
                ans += rep;
                i += find.length();
            } else {
                ans += text.charAt(i);
                i++;
            }
        }
        return ans;
    }

    //Log File Compaction
    static String logFileCompaction(String logs) {
        String arr[] = logs.split(" ");
        String ans = "";
        int cnt = 1;

        for (int i = 1; i <= arr.length; i++) {
            if (i < arr.length && arr[i].equals(arr[i - 1])) {
                cnt++;
            } else {
                ans += arr[i - 1] + "(" + cnt + ")";
                if (i < arr.length)
                    ans += " ";
                cnt = 1;
            }
        }
        return ans;
    }

    //SKU Normalizer
    static String skuNormalizer(String sku) {
        String s = sku.toUpperCase();
        String part[] = s.split("-");
        if (part.length != 3)
            return "INVALID";

        if (part[0].length() < 3 || part[0].length() > 4)
            return "INVALID";

        if (!part[1].matches("[0-9]{4,6}"))
            return "INVALID";

        if (!(part[2].equals("S") || part[2].equals("M") || part[2].equals("L") || part[2].equals("XL")))
            return "INVALID";

        return part[0] + "-" + part[1] + "-" + part[2];
    }

    //Chat Redaction
    static String chatRedaction(String msg, String banned[]) {
        for (int i = 0; i < banned.length; i++) {
            String word = banned[i];
            String stars = "";
            for (int j = 0; j < word.length(); j++) {
                stars += "*";
            }
            msg = msg.replaceAll("\\b" + word + "\\b", stars);
        }
        return msg;
    }

    //Resume Keyword Versioning
    static int resumeSimilarity(String v1[], String v2[]) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < v1.length; i++) {
            String s = v1[i];
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < v2.length; i++) {
            String s = v2[i];
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        int score = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int val = Math.min(map1.get(key), map2.get(key));
                score += val;
            }
        }
        return score;
    }
}
