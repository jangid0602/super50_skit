public class q6 {
    public static int path(int[] arr,int k){

        int i=0;
        int count=1;
        while(i<arr.length-1){
            if(Math.abs(arr[i+1]-arr[i])<=k){
                count++;
                i++;
            }
            else{
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {5,15,25};
        int x = 5;
        int ans = path(arr,x);
        System.out.println(ans);
    }
}
