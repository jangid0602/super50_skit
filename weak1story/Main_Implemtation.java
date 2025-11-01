package story1;

import java.util.ArrayList;
import java.util.List;

public class Main_Implemtation {
    
    int FarthestCity(int[] nums,int initialEnergy){
        
        for(int i=0;i<nums.length;i++){
          initialEnergy -=nums[i];
          if(initialEnergy < 0) {
            return i;
          }
          
        }
        return nums.length-1;
    }

    int FlipSwitch(int[] nums){
        int n = nums.length;
        int zerocount = 0;
        int onecount = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
               zerocount++;
            }else{
                onecount++;
            }
        }
        return Math.max(zerocount,onecount);
    }


    int findSingleElement(int[] singleElementArray){
        int n = singleElementArray.length;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(singleElementArray[i]  == singleElementArray[j]){
                    count++;
                }
            }
            if(count == 1) return singleElementArray[i];
        }
        return -1;
    }



     List<int[]> findSmartPair(int[] smartpairArray,int k){
        List<int[]> result = new ArrayList<>();

        int n = smartpairArray.length;
        int p ;
        for(int i=0;i<n;i++){
            p =k - smartpairArray[i];
            for(int j=i+1;j<n;j++){
               if(smartpairArray[j] == p){
                result.add(new int[]{smartpairArray[i],smartpairArray[j]});
               }
            }
        }
        return result;
    }

   int findMinPaintTime(int[] paintArray){
    int n = paintArray.length;
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for(int i=0;i<n;i++){
       if(paintArray[i] > max){
        max = paintArray[i];
       }
       ans+=paintArray[i];
    }
    return ans-max;
   }

  int findPrefixSuffix(int[] prefixSuffixArray){
    int n = prefixSuffixArray.length;
    int totalsum = 0;

    for(int i=0;i<n;i++){
        totalsum+=prefixSuffixArray[i];
    }
    int prefixsum = 0;

    for(int i=0;i<n;i++){
        int suffixsum = totalsum - prefixsum - prefixSuffixArray[i];
        if(prefixsum == suffixsum){
            return i;
        }
        prefixsum+=prefixSuffixArray[i];
    }
    return -1;
  }


}
