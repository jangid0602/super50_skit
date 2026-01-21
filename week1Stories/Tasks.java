/**
* @Filename - Tasks.java
* @Description - this will contain list of task in first stories
* @Author - Nancy Jain
*/

public class Tasks {
    private int[] nums;
Tasks(int []array , int size){
    if(array == null || size != array.length || size<=0){
        throw new IllegalArgumentException("Invalid array or size.");
    }
    nums = array.clone();
}
public int getEfficientTraveler(int initialEnergy){
    int energy = initialEnergy;
    if(nums.length == 0) return -1;
    for(int i=0;i<nums.length;i++){
        if(energy-nums[i]<0){
            return i;
        }
        energy = energy - nums[i];
    }
    return nums.length-1;
}


public int getSumThatStandsOut(){
    long totalSum = 0;
    for(int num : nums){
        totalSum += num ;
    }
    long prefixSum=0;
    for(int i=0;i<nums.length;i++){
        long suffixSum=totalSum-prefixSum - nums[i];
        if(prefixSum == suffixSum) {
            return i;
        }
        prefixSum += nums[i];
    }
        return -1;
}


public int getFlippedSwitch(int []nums){
    int count_1=0 , count_0=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==1) count_1++;
        if(nums[i]==0) count_0++;
    }
    return Math.min(count_1,count_0);
}
public int getOddOneOut(){
//   XOR method - if more than one element is present then it gives wrong answer
    int maximum = Integer.MIN_VALUE;
    for(int num:nums){
        maximum = Math.max(maximum,num);
    }
    int []countArray = new int[maximum+1];
    for(int i=0;i<nums.length;i++){
        countArray[nums[i]]++;
    }
    for(int num : countArray){
        if(num ==1) return num;
    }
    return -1;
}
public boolean getSmartPair(int target){
    int []arr = nums.clone();
    java.util.Arrays.sort(arr);
    int left = 0 ,right = arr.length-1;
    while(left<right){
        int sum = arr[left]+ arr[right];
        if(sum<target) left++;
        else if(sum == target) return true; 
        else right--;
    }
    return false;
}
public int getMinimalistPainter(){
    if(nums.length == 0) return 0;
    int maximum=Integer.MIN_VALUE , totalSum=0;
    for(int num:nums){
        totalSum += num;
        maximum = Math.max(maximum, num);
    }
    int minTotalTime = totalSum - maximum;
    return minTotalTime;
}
}
