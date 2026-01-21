public class FloorIsLava {
    static int solve(int k,int[] heights){
        int n = heights.length;
        int []arr = new int[n-1];

        for(int i=0;i<n-1;i++){
            arr[i] = heights[i+1]-heights[i];
        }
        int ans = 1;
        int maxi = 1;
        for(int i = 0;i<n-1;i++){
            if(arr[i]<=k){
                ans++;
            }else{
                ans = 1;
            }
            maxi = Math.max(maxi,ans);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] heights = {1,2,3,10,2,1,5,6,7};
        System.out.println(solve(k,heights));
    }
}
