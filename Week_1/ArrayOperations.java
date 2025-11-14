package Oneup.Assignment4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOperations {
     private List<Integer> arr; 
        public ArrayOperations() {                            // default constructer
         this.arr = new ArrayList<>();
        
    }

    // Parameterized constructor
    public ArrayOperations(List<Integer> arr) {   // takes array for all functions
        this.arr = arr;
        
    }
     public int getfarthestcity(int target){     //takes function required values
    int i=0;
    if(target==0) return -1;
    for(i=0;i<arr.size();i++){
        target=target-arr.get(i);
        if(target<0){                // energy lost return final destination
            break;
        }
    }
     return i-1;

   }


   //function for finding pair of index where sum of values equal to given sum
    public Boolean pairfinder(int sum){
        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                if(arr.get(i)+arr.get(j)==sum) return true; 
            }
        }
        return false;
    }





   public int getequalsum(){
    int i=0;
    int left=arr.get(0);         //for prifix sum
    int right=0;       //for suffix sum

    for(i=1;i<arr.size();i++){      // for total sum of array
        right=right+arr.get(i);
    }
     if(i==0){ 
         if(right==0) return i;

        }
        if(i==arr.size()){
            if(left==0) return arr.size()-1;
        }
    for(i=1;i<arr.size()-1;i++){
        right=right-arr.get(i);
         if(left==right) return i;
          left=left+arr.get(i);
    }

    return -1;


   }
   public int getminimumflips(){
    int zeros=0;
    int ones=0;
    List<Integer> freqarray;   // array for counting frequency
    for(int i=0;i<arr.size();i++){
        if(arr.get(i)==0) zeros++;
        else ones++;
    }
    if(zeros>ones) return ones;
    return zeros;

   }
   public int getoddoneout(){
    int temp=arr.get(0);
    for(int i=0;i<arr.size();i++){
         for(int j=0;j<arr.size()-i-1;j++){
            if(arr.get(j)<arr.get(j+1)){
                temp=arr.get(j);
               arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
            }

            
         }

          

    }
    for(int i=0;i<arr.size();i += 2){

        if(arr.get(i)!=arr.get(+1)) return arr.get(i);

          }
    return -1;
   }
   public int getminimumtime(){
    int sum=0;
    int max=arr.get(0);
    for(int i=0;i<arr.size();i++){
        sum+=arr.get(i);
        if(max<arr.get(i)) max=arr.get(i);


    } return sum-max;
   }
}
