import java.util.HashMap;

public class TimeTraveller {
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, -2, -3, 1 };
        int target = 1;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            int remain = sum - target;
            if (map.containsKey(remain)) {
                count += map.get(remain);
            }
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, 1);
        }
        System.out.println("Number of subarray:" + count);
    }
}