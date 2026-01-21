
import java.util.ArrayList;
import java.util.List;

public class Missing_page_number {
    public List<String> get_missing_pages(List<Integer> nums, int N) {
        int[] numbers = new int[N + 1];
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            numbers[nums.get(i)]++;
        }
        int left = 1, right = 1;
        List<String> answer = new ArrayList<>();

        while (right <= N) {
            if (numbers[right] == 0) {
                right++;
            } else {
                if (right == left) {
                    right++;
                    left++;
                    continue;
                }
                if (right != left || right - 1 != left) {
                    String temp = String.valueOf(left) + "-" + String.valueOf(right - 1);
                    answer.add(temp);
                } else {
                    answer.add(String.valueOf(left));
                }
                while (right <= N && numbers[right] == 1) {
                    right++;
                }
                left = right;
                right++;
            }
        }
        if (right - 1 != left) {
            String temp = String.valueOf(left) + "-" + String.valueOf(right - 1);
            answer.add(temp);
        } else {
            answer.add(String.valueOf(left));
        }

        return answer;
    }
}
