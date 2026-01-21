package ChallengePhase1;

public class FloorIsLava {
    public static int getLongestStablePath(int[] heights , int k){
        int length = heights.length;
        int previous = heights[0];
        int count = 0;
        for(int i=0 ; i<length ; i++){
            int difference = heights[i]-previous;
            if(difference<=k) count++;
            previous=heights[i];
        }
        return count;
    }
    public static void main(String[] args) {
        int [] heights = new int[]{5,15,25};
        System.out.println(getLongestStablePath(heights, 5));
    }
}
