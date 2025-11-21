import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyArray {

    private ArrayList<Integer> nums; // store numbers
    private int value; // target

    private String s;
    private int k;

    public MyArray(ArrayList<Integer> nums, int value) {
        this.nums = nums;
        this.value = value;
    }

    public MyArray(String s, int k) {
        this.s = s;
        this.k = k;
    }

    public int timeTravelArray() {
        int target = this.value;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // prefix sum 0 appears once

        int sum = 0;
        long count = 0; // total numbers of subarray

        for (int x : nums) {
            sum += x;
            // if there is a prefixsum - previoussum = target then count++
            count += freq.getOrDefault(sum - target, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return (int) count;
    }

    public ArrayList<Integer> shiftIntArray() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num + value);
        }
        return result;
    }

    public String shiftingCipher() {
        if (s == null)
            return "";
        int shift = ((k % 26) + 26) % 26; // normalize shift to 0-25
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                char out = (char) ('A' + (ch - 'A' + shift) % 26);
                sb.append(out);
            } else if (ch >= 'a' && ch <= 'z') {
                char out = (char) ('a' + (ch - 'a' + shift) % 26);
                sb.append(out);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
