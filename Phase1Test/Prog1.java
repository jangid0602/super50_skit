// 1. The Floor is Lava

public class Prog1 {

    public static void main(String[] args) {
        int[] heights = {5, 15, 25};

        int left = 0;
        int right = 1;
        int path = 0;

        int k = 5;

        int length = heights.length;

        while (left < right && right < length) {

            if (heights[right] - heights[right - 1] <= k) {
                path++;
            }

            while (right - left + 1 > k) {
                left++;
            }

            right++;

        }

        System.out.println(path + 1);
    }
}
