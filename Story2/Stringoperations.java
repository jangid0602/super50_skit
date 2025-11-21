package Oneup.Story2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

public class Stringoperations {
    private String data;

    // Default constructor
    public Stringoperations() {
        this.data = "";
    }

    // Parameterized constructor
    public Stringoperations(String string) {
        this.data = string;
    }

    // Convert object to string
    @Override
    public String toString() {
        return this.data;

    }

    // 2. Encoded String Subset
    public boolean getencodedSubset(String sub) {
        int[] need = new int[26];
        for (char c : sub.toCharArray())
            need[c - 'a']++;

        int[] window = new int[26];
        int left = 0;

        for (int right = 0; right < data.length(); right++) {
            window[data.charAt(right) - 'a']++;
            if (right - left + 1 > sub.length()) {
                window[data.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == sub.length()) {
                if (Arrays.equals(window, need))
                    return true;
            }
        }
        return false;
    }

    // 3. E-Commerce Funnel (Most frequent 2 step path)
    public String gettwoStepPath(String string) {

        // Extract pages in given order
        List<String> pages = new ArrayList<>();

        String[] rows = data.split(";"); // split into each "1,Home"
        for (String row : rows) {
            String[] act = row.split(","); // act[0] = id, act[1] = page
            if (act.length > 1) {
                pages.add(act[1]); // add page
            }
        }

        // Count transitions
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < pages.size() - 1; i++) {
            String pair = pages.get(i) + "," + pages.get(i + 1);
            freq.put(pair, freq.getOrDefault(pair, 0) + 1);
        }

        // Find most frequent (tie → lexicographically smallest)
        String best = "";
        int max = 0;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String pair = e.getKey();
            int count = e.getValue();
            if (count > max || (count == max && pair.compareTo(best) < 0)) {
                max = count;
                best = pair;
            }
        }

        return best;
    }

    public String replaceNonOverlap(String find, String rep) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < data.length()) {
            if (i + find.length() <= data.length() && data.substring(i, i + find.length()).equals(find)) {
                result.append(rep);
                i += find.length();
            } else {
                result.append(data.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // 7. Log File Compaction
    public String getcompactLog() {
        if (data.isEmpty())
            return "Log is Empty!";
        String[] arr = data.split(" ");
        String result = "";
        String prev = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(prev))
                count++;
            else {
                result += prev + "(" + count + ") ";
                prev = arr[i];
                count = 1;
            }
        }
        result += prev + "(" + count + ")";
        return result;
    }

    // 8. SKU Normalization
    public String normalizeSKU() {
        data = data.toUpperCase();
        String[] p = data.split("-");
        if (p.length != 3)
            return "INVALID";

        if (!p[0].matches("[A-Z]{3,4}"))
            return "INVALID";
        if (!p[1].matches("\\d{4,6}"))
            return "INVALID";
        if (!(p[2].equals("S") || p[2].equals("M") || p[2].equals("L") || p[2].equals("XL")))
            return "INVALID";

        return p[0] + "-" + p[1] + "-" + p[2];
    }

    // 9. Chat Message Redaction
    public String getmsgredact(List<String> banned) {
        for (String b : banned) {
            data = data.replaceAll(b, "*".repeat(b.length()));
        }
        return data;
    }

    // 10. Resume Keyword Versioning
    public static int resumeScore(List<String> r1, List<String> r2) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        int score = 0;

        for (String s : r1) {
            m1.put(s, m1.getOrDefault(s, 0) + 1);
        }

        for (String s : r2) {
            m2.put(s, m2.getOrDefault(s, 0) + 1);
        }

        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                score += Math.min(m1.get(key), m2.get(key));
            }
        }

        return score;
    }

}
