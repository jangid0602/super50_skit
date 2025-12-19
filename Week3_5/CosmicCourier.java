package Week3_5;
import java.util.*;

public class CosmicCourier {
    // Returns minimal possible project deadline after optionally removing one route.
    public static int minDeadline(int[] times) {
        if (times == null || times.length == 0) return 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int t : times) {
            if (t > max1) {
                max2 = max1;
                max1 = t;
            } else if (t > max2) {
                max2 = t;
            }
        }
        if (times.length == 1) return max1;
        int keepAll = max1;
        int removeOne = max2 == Integer.MIN_VALUE ? max1 : max2;
        return Math.min(keepAll, removeOne);
    }
}
