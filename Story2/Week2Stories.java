import java.util.*;
import java.util.regex.*;

public class Week2Stories {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= WEEK 2 STORIES MENU =========");
            System.out.println("1. The Trendsetter Score");
            System.out.println("2. Encoded String Subsets");
            System.out.println("3. E-Commerce Funnel Analysis");
            System.out.println("4. Maximal Pair Matching");
            System.out.println("5. Subarray Color Balance");
            System.out.println("6. Text Editor Non-Overlapping Replace");
            System.out.println("7. Log File Compaction");
            System.out.println("8. E-commerce SKU Normalization");
            System.out.println("9. Chat Message Redaction");
            System.out.println("10. Resume Keyword Versioning");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> trendsetterScore();
                case 2 -> encodedStringSubsets();
                case 3 -> ecommerceFunnelAnalysis();
                case 4 -> maximalPairMatching();
                case 5 -> subarrayColorBalance();
                case 6 -> textEditorReplace();
                case 7 -> logFileCompaction();
                case 8 -> skuNormalization();
                case 9 -> chatMessageRedaction();
                case 10 -> resumeKeywordVersioning();
                case 0 -> {
                    if (confirmExit()) {
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    }
                }
                default -> System.out.println(" Invalid choice. Please try again.");
            }
        }
    }

    //  Utility to safely read integer input
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid number! Please enter again: ");
            }
        }
    }

    // ✅ Confirm exit
    private static boolean confirmExit() {
        System.out.print("Are you sure you want to exit? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

   
    // 1️⃣ The Trendsetter Score
    private static void trendsetterScore() {
        System.out.print("Enter number of posts: ");
        int n = readInt();
        int[] posts = new int[n];
        System.out.print("Enter post IDs separated by space: ");
        String[] parts = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) posts[i] = Integer.parseInt(parts[i]);

        System.out.print("Enter window size k: ");
        int k = readInt();

        int score = 0;
        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) freq.put(posts[j], freq.getOrDefault(posts[j], 0) + 1);
            int maxFreq = Collections.max(freq.values());
            long count = freq.values().stream().filter(v -> v == maxFreq).count();
            if (count == 1) score++;
        }
        System.out.println("Trendsetter Score: " + score);
    }


    // Encoded String Subsets
    private static void encodedStringSubsets() {
        System.out.print("Enter superstring: ");
        String superstring = scanner.nextLine();
        System.out.print("Enter substring: ");
        String substring = scanner.nextLine();

        boolean exists = checkPermutationExists(superstring, substring);
        System.out.println("Output: " + exists);
    }

    private static boolean checkPermutationExists(String s, String sub) {
        if (sub.length() > s.length()) return false;
        int[] subCount = new int[26], windowCount = new int[26];
        for (char c : sub.toCharArray()) subCount[c - 'a']++;
        for (int i = 0; i < sub.length(); i++) windowCount[s.charAt(i) - 'a']++;
        if (Arrays.equals(subCount, windowCount)) return true;
        for (int i = sub.length(); i < s.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;
            windowCount[s.charAt(i - sub.length()) - 'a']--;
            if (Arrays.equals(subCount, windowCount)) return true;
        }
        return false;
    }

    //  E-Commerce Funnel Analysis
    private static void ecommerceFunnelAnalysis() {
        System.out.print("Enter number of actions: ");
        int n = readInt();
        System.out.println("Enter actions in format 'userID,pageID':");
        String[] actions = new String[n];
        for (int i = 0; i < n; i++) actions[i] = scanner.nextLine().trim();

        HashMap<String, List<String>> userPages = new HashMap<>();
        for (String action : actions) {
            String[] parts = action.split(",");
            userPages.computeIfAbsent(parts[0], k -> new ArrayList<>()).add(parts[1]);
        }

        HashMap<String, Integer> pathCount = new HashMap<>();
        for (List<String> pages : userPages.values()) {
            for (int i = 0; i < pages.size() - 1; i++) {
                String path = pages.get(i) + "," + pages.get(i + 1);
                pathCount.put(path, pathCount.getOrDefault(path, 0) + 1);
            }
        }

        String bestPath = "";
        int max = 0;
        for (var e : pathCount.entrySet()) {
            if (e.getValue() > max || (e.getValue() == max && e.getKey().compareTo(bestPath) < 0)) {
                max = e.getValue();
                bestPath = e.getKey();
            }
        }

        System.out.println("Most frequent path: " + bestPath);
    }

    //  Maximal Pair Matching
    private static void maximalPairMatching() {
        System.out.print("Enter number of elements: ");
        int n = readInt();
        System.out.print("Enter elements separated by space: ");
        String[] parts = scanner.nextLine().trim().split("\\s+");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);

        System.out.print("Enter target sum k: ");
        int k = readInt();

        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = k - num;
            if (freq.getOrDefault(complement, 0) > 0) {
                count++;
                freq.put(complement, freq.get(complement) - 1);
            } else freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("Maximum pairs: " + count);
    }

    //  Subarray Color Balance
    private static void subarrayColorBalance() {
        System.out.print("Enter number of elements: ");
        int n = readInt();
        System.out.print("Enter elements (0=neutral,1=red,2=blue): ");
        String[] parts = scanner.nextLine().trim().split("\\s+");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);

        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int diff = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) diff++;
            else if (nums[i] == 2) diff--;
            if (indexMap.containsKey(diff)) maxLen = Math.max(maxLen, i - indexMap.get(diff));
            else indexMap.put(diff, i);
        }

        System.out.println("Longest balanced subarray length: " + maxLen);
    }

   
    //  Text Editor Non-Overlapping Replace
    private static void textEditorReplace() {
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter find string: ");
        String find = scanner.nextLine();
        System.out.print("Enter replace string: ");
        String replace = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i + find.length() <= text.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else result.append(text.charAt(i++));
        }

        System.out.println("Result: " + result);
    }

    // ============================================================
    //  Log File Compaction
    private static void logFileCompaction() {
        System.out.print("Enter log string (space separated): ");
        String[] logs = scanner.nextLine().trim().split("\\s+");

        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= logs.length; i++) {
            if (i < logs.length && logs[i].equals(logs[i - 1])) count++;
            else {
                result.append(logs[i - 1]).append("(").append(count).append(") ");
                count = 1;
            }
        }
        System.out.println("Compacted log: " + result.toString().trim());
    }

    // E-commerce SKU Normalization
    private static void skuNormalization() {
        System.out.print("Enter SKU string: ");
        String sku = scanner.nextLine().trim().toUpperCase();
        String[] parts = sku.split("-");

        if (parts.length != 3) {
            System.out.println("INVALID");
            return;
        }

        String category = parts[0], id = parts[1], size = parts[2];
        if (!category.matches("[A-Z]{3,4}") || !id.matches("\\d{4,6}") || !size.matches("S|M|L|XL"))
            System.out.println("INVALID");
        else
            System.out.println("Normalized SKU: " + category + "-" + id + "-" + size);
    }

  
    //  Chat Message Redaction
    private static void chatMessageRedaction() {
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        System.out.print("Enter number of banned words: ");
        int n = readInt();
        String[] banned = new String[n];
        System.out.println("Enter banned words:");
        for (int i = 0; i < n; i++) banned[i] = scanner.nextLine();

        for (String word : banned) {
            message = message.replaceAll("\\b" + Pattern.quote(word) + "\\b", "*".repeat(word.length()));
        }
        System.out.println("Redacted Message: " + message);
    }

 
    //  Resume Keyword Versioning
    private static void resumeKeywordVersioning() {
        System.out.print("Enter number of keywords in Resume V1: ");
        int n1 = readInt();
        System.out.println("Enter keywords for Resume V1:");
        String[] v1 = new String[n1];
        for (int i = 0; i < n1; i++) v1[i] = scanner.nextLine();

        System.out.print("Enter number of keywords in Resume V2: ");
        int n2 = readInt();
        System.out.println("Enter keywords for Resume V2:");
        String[] v2 = new String[n2];
        for (int i = 0; i < n2; i++) v2[i] = scanner.nextLine();

        HashMap<String, Integer> freq1 = new HashMap<>(), freq2 = new HashMap<>();
        for (String s : v1) freq1.put(s, freq1.getOrDefault(s, 0) + 1);
        for (String s : v2) freq2.put(s, freq2.getOrDefault(s, 0) + 1);

        int score = 0;
        for (String key : freq1.keySet()) {
            if (freq2.containsKey(key)) score += Math.min(freq1.get(key), freq2.get(key));
        }

        System.out.println("Similarity Score: " + score);
    }
}
