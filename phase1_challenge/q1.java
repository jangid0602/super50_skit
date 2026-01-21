import javax.print.DocFlavor;
import java.util.*;
public class q1 {
//    Missing pages
    public static ArrayList<String> missingPages(int[] arr, int n){

        ArrayList<String> list = new ArrayList<>();
       int i = 0;
       int count = 1;
       if(arr[0]!=1){
           StringBuilder sb = new StringBuilder();
           if(arr[0]==2){
               sb.append(String.valueOf(1));
           }
           else{
               sb.append(String.valueOf(1)+"-"+String.valueOf(arr[0]-1));
           }
           i++;
           list.add(sb.toString());
       }

       while(i < arr.length){
           if(arr[i] == i+1 || arr[i]-arr[i-1]==1){
               i++;
           }
           else{
               StringBuilder sb = new StringBuilder();
               if(i>0 && arr[i]-arr[i-1]==2){
                   sb.append(String.valueOf(arr[i]-arr[i-1]));
               }
               else{
                   if(i>0)sb.append(String.valueOf(arr[i-1]+1)+"-"+String.valueOf(arr[i]-1));
               }
               i++;
               list.add(sb.toString());
           }
       }

       if(arr[arr.length-1]!=n){
           StringBuilder sb = new StringBuilder();
           if(arr[arr.length-1]==n-1){
               sb.append(String.valueOf(n));
           }
           else{
               sb.append(String.valueOf(arr[arr.length-1]+1)+"-"+String.valueOf(n));
           }
           list.add(sb.toString());
       }
       return list;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,9};
        int n = 10;
        ArrayList<String> res = missingPages(arr,n);
        System.out.println(res);
    }
}
