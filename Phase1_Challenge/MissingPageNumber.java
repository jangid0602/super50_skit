import java.util.ArrayList;

public class MissingPageNumber {
    static ArrayList<String> arr(int arr[],int N){
        ArrayList<String> res = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i==0 && arr[i]-1!=0){
                if(arr[i]-1>=2){
                    String s = "1-"+String.valueOf(arr[i]-1);
                    res.add(s);
                }else{
                    res.add(arr[i]-1+"");
                }
            }else if(i!=0 && i<n && arr[i]-arr[i-1]!=1){
                String s = String.valueOf(arr[i-1]+1);
                s = s+"-"+String.valueOf(arr[i]-1);
                res.add(s);
            }
        }
        if(arr[n-1]!=N){
            String s =String.valueOf(arr[n-1]+1);
            
            if(N-arr[n-1]>=2){
                 s += "-"+N;
                
            }
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,9};
        int N = 10;
        ArrayList<String> ans = arr(arr,N);
        for(String s : ans){
            System.out.println(s);
        };
    }
}
