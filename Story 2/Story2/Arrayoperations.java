package Oneup.Story2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arrayoperations{
    List<Integer> array; 
    public Arrayoperations(List<Integer> array){
        this.array=array;
    }
     public int gettrendsetterScore(int windowSize) {
        Map<Integer, Integer> freq = new HashMap<>();
        int score = 0;
        int left = 0;
        for(int right = 0; right < array.size(); right++) {
            freq.put(array.get(right), freq.getOrDefault(array.get(right), 0) + 1);
            if(right - left + 1 > windowSize) {
                freq.put(array.get(left), freq.get(array.get(left)) - 1);
                if(freq.get(array.get(left)) == 0) freq.remove(array.get(left));
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
    public  int getmaxpairs(int target){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : array) {
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
        public  int getlongestbalanced(){
        int n = array.size();
        int count0 = 0, count1 = 0, count2 = 0;
        Map<String, Integer> map = new HashMap<>();
        
        map.put("0#0", -1); // base condition when diff are zero

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if(array.get(i) == 0) count0++;
            else if(array.get(i) == 1) count1++;
            else if(array.get(i) == 2) count2++;
            else continue; 
        }
        int minCount = Math.min(count0, Math.min(count1, count2));
        return 3 * minCount;
    }

}