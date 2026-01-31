// MyString.java
import java.util.*;

public class MyString {

    // 2. Encoded String Subset
    public static boolean encodedSubset(String s, String sub){
        int[] need = new int[26];
        for(char c: sub.toCharArray()) need[c-'a']++;

        int[] window = new int[26];
        int left = 0;

        for(int right=0; right<s.length(); right++){
            window[s.charAt(right)-'a']++;
            if(right-left+1 > sub.length()){
                window[s.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1 == sub.length()){
                if(Arrays.equals(window,need)) return true;
            }
        }
        return false;
    }

    // 3. E-Commerce Funnel (Most frequent 2 step path)
    public static String twoStepPath(List<String[]> actions) {

    // Extract pages in given order
    List<String> pages = new ArrayList<>();
    for(String[] act : actions){
        pages.add(act[1]); // act[1] = page
    }

    // Count transitions
    Map<String, Integer> freq = new HashMap<>();
    for(int i = 0; i < pages.size() - 1; i++){
        String pair = pages.get(i) + "," + pages.get(i+1);
        freq.put(pair, freq.getOrDefault(pair, 0) + 1);
    }

    // Find most frequent (tie → lexicographically smallest)
    String best = "";
    int max = 0;
    for(Map.Entry<String, Integer> e : freq.entrySet()){
        String pair = e.getKey();
        int count = e.getValue();
        if(count > max || (count == max && pair.compareTo(best) < 0)){
            max = count;
            best = pair;
        }
    }

    return best;
}


    // 6. Text Replace Non Overlapping
    public static String replaceNonOverlap(String text, String find, String rep){
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < text.length()){
            if(i + find.length() <= text.length() && text.substring(i, i+find.length()).equals(find)){
                result.append(rep);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // 7. Log File Compaction
    public static String compactLog(String logs){
        if(logs.isEmpty()) return "Log is Empty!";
        String[] arr = logs.split(" ");
        String result = "";
        String prev = arr[0];
        int count = 1;

        for(int i=1;i<arr.length;i++){
            if(arr[i].equals(prev)) count++;
            else{
                result += prev + "(" + count + ") ";
                prev = arr[i];
                count = 1;
            }
        }
        result += prev + "(" + count + ")";
        return result;
    }

    // 8. SKU Normalization
    public static String normalizeSKU(String sku){
        sku = sku.toUpperCase();
        String[] p = sku.split("-");
        if(p.length != 3) return "INVALID";

        if(!p[0].matches("[A-Z]{3,4}")) return "INVALID";
        if(!p[1].matches("\\d{4,6}")) return "INVALID";
        if(!(p[2].equals("S") || p[2].equals("M") || p[2].equals("L") || p[2].equals("XL"))) return "INVALID";

        return p[0]+"-"+p[1]+"-"+p[2];
    }

    // 9. Chat Message Redaction
    public static String redact(String msg, List<String> banned){
        for(String b : banned){
            msg = msg.replaceAll(b, "*".repeat(b.length()));
        }
        return msg;
    }

    // 10. Resume Keyword Versioning
    public static int resumeScore(List<String> r1, List<String> r2){
        Map<String,Integer> m1 = new HashMap<>();
        Map<String,Integer> m2 = new HashMap<>();
        int score = 0;

        for(String s: r1) m1.put(s, m1.getOrDefault(s,0)+1);
        for(String s: r2) m2.put(s, m2.getOrDefault(s,0)+1);

        for(String key: m1.keySet()){
            if(m2.containsKey(key)){
                score += Math.min(m1.get(key), m2.get(key));
            }
        }
        return score;
    }
}
