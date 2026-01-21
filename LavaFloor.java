
/**
 * Filename - LavaFloor.java
 * Description - Find longest stable path
 * Author - Nancy Jain
 * Date - 21/01/2026
 */

public class LavaFloor{
    public static int path(int[] heights , int k){
        if(heights == null || heights.length <2) return 0;
        int count = 0 ;
        int n = heights.length;
        int maxpath = 0;
        for(int i = 1 ; i < n ; i++){
            if((heights[i] - heights[i-1]) <= k ) {
                count++;
                if(count>maxpath){
                maxpath = count;}
            }
            else count = 0;
        }
        return maxpath > 0 ? maxpath + 1 :  0;
    }
}