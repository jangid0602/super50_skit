
import java.util.List;
import java.util.Collections;

public class LavaFloor {
    public int get_longest_stable_path(List<Integer> nums, int k) {
        int n = nums.size();
        if (n == 0 || n == 1) {
            return n;
        }
        int left = 0, right = 1;
        int maximumLength = 0;
        while (right < n) {
            if (nums.get(right) - nums.get(right - 1) <= k) {
                right++;
            } else {
                left = right;
                right++;
            }
            maximumLength = Math.max(maximumLength, right - left);
        }
        return maximumLength;
    }
}