/**
 * Filename- CosmicCourier.java
 * Deescription- determine the minimum possible deadline after optionally removing one route
 * Author - Nancy Jain
 */
public class CosmicCourier {
    public static int minDeadline(int[] arr){
        int maxVal = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int val : arr){
            if(val > maxVal){
                secondMax = maxVal;
                maxVal = val;
            }else if (val > secondMax){
                secondMax = val;
            }
        }
        return secondMax == Integer.MIN_VALUE ? maxVal : secondMax;
    }
}
