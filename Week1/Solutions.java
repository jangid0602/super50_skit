package Week1;

public class Solutions {
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        int[] nums = {4, 2, 6, 3, 5};
        int initialEnergy = 10;
        int result = sol.efficientJourney(nums, initialEnergy);
        System.out.println("Furthest index reachable: " + result);

        int [] nums2 = {2, 3, -1, 3, 4};
        int index = sol.prefixSumEqualsSuffixSum(nums2);
        System.out.println("Index where prefix sum equals suffix sum: " + index);
        
        int [] binArr = {0, 1, 0, 0, 1, 1, 0};
        int flips = sol.minFlipsToMakeAllOne(binArr);
        System.out.println("Minimum flips to make all equals: " + flips);

        int [] nums3 = {2, 3, 5, 4, 5, 3, 2};
        int oddOneOut = sol.OddOneOut(nums3);
        System.out.println("Odd one out: " + oddOneOut);
        
        int [] nums4 ={3, 5, 1, 7};
        int k=8;
        boolean isPair=isSmartPair(nums4,k);
        System.out.println("Is this a Pair??: "+ isPair);


        int [] time={4, 2, 3, 7};
        int minTotTime=minPainter(time);
        System.out.println("The minimum total time after skipping one wall: "+ minTotTime);
    
    }


    static  int efficientJourney(int[] nums, int initialEnergy) {
        if(initialEnergy<nums[0]){
            return -1;
        }
        int energy=initialEnergy;
        for(int i=0;i<nums.length-1;i++){
           energy=energy-nums[i];
            if(energy<0){
                return i;
            }
        }
        return nums.length-1;
    }

    int prefixSumEqualsSuffixSum(int [] nums){
        int [] prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int [] suffixSum=new int[nums.length];
        suffixSum[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(prefixSum[i]==suffixSum[i]){
                return i;
            }
        }
        return -1;
    }

    int minFlipsToMakeAllOne(int [] binArr){
        int zeroes=0;
        int ones=0;
        for(int i=0;i<binArr.length;i++){
            if(binArr[i ]==0) zeroes++;
            else ones++;
        }
        return Math.min(zeroes,ones);
    }

    int OddOneOut(int [] nums){
        int xorr=0;
        for(int i=0;i<nums.length;i++){
            xorr=xorr^nums[i];
        }
        return xorr;
    }

    static boolean isSmartPair(int [] nums,int k){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==k) return true;
            }
        }
        return false;
    }

    static int minPainter(int [] nums){
        int maxElement=-1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxElement=Math.max(maxElement,nums[i]);
        }
        return sum-maxElement;
    }

}
