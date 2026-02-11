// MyNumber.java
import java.util.*;

public class MyNumber {

    // 1. Trendsetter Score
    public static int TrendsetterScore(List<Integer> posts, int windowSize) {
        Map<Integer, Integer> freq = new HashMap<>();
        int score = 0;
        int left = 0;
        for(int right = 0; right < posts.size(); right++) {
            freq.put(posts.get(right), freq.getOrDefault(posts.get(right), 0) + 1);
            if(right - left + 1 > windowSize) {
                freq.put(posts.get(left), freq.get(posts.get(left)) - 1);
                if(freq.get(posts.get(left)) == 0) freq.remove(posts.get(left));
                left++;
            }
            int maxFreq = 0;
            for(int val : freq.values())
                maxFreq = Math.max(maxFreq, val);

            int countMax = 0;
            for(int val : freq.values())
                if(val == maxFreq) countMax++;
            if(countMax == 1) score++;
        }
        return score;
    }

    // 4. Maximal Pair Matching
    public static int maxPairs(int[] nums, int target){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = target - num;

            if (freq.getOrDefault(complement, 0) > 0) {
                // Form a pair
                count++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    // 5. Subarray Color Balance (red=1, blue=2, neutrals ignored)
        public static int longestBalanced(int[] arr){
        int n = arr.length;
        int count0 = 0, count1 = 0, count2 = 0;
        Map<String, Integer> map = new HashMap<>();
        
        map.put("0#0", -1); // base condition when diff are zero

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else if(arr[i] == 2) count2++;
            else continue; 
        }
        int minCount = Math.min(count0, Math.min(count1, count2));
        return 3 * minCount;
    }
}
