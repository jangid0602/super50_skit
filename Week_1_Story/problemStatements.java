/**
 * @Filename - problemStatements.java
 * @Description - This will perform following problem statement: 1. Efficient Traveler
 *                                                               2. The Sum That Stands Out 
 *                                                               3. Flip the Switch
 *                                                               4. The Odd One Out
 *                                                               5. Smart Pair Finder
 *                                                               6. The Minimalist Painter
 * @Author - Anish Saini 
 */

import java.util.ArrayList;

public class problemStatements {
    int nums[];
    int arraySize ;
    problemStatements(int nums[]){
        this.nums = nums;
        this.arraySize = nums.length;
    }

    // Problem 1: Efficient Traveler
    public int efficientTraveler(int initialEnergy){
        for(int i = 0;i < arraySize;i++){
            initialEnergy -= nums[i];
            if(initialEnergy < 0){
                return i;
            }
        }
        return arraySize-1;
    }

    // Problem 2: The Sum That Stands Out
    public int prefixSumEqualToSuffixSum(){
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int prefixSum = 0;
        for(int i = 0;i < arraySize;i++){
            totalSum -= nums[i];
            if(prefixSum == totalSum){
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    // Problem 3: Flip the Switch
    public int minimumFlip(){
        int zeros = 0;
        int ones = 0;
        for(int num : nums){
            if(num == 0){
                zeros++;
            } else {
                ones++;
            }
        }
        
        if(zeros < ones){
            return zeros;
        } else {
            return ones;
        }
    }

    // Problem 4: The Odd One Out

    public int findOddOneOut() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.contains(num)) {
                list.remove(Integer.valueOf(num)); 
            } else {
                list.add(num); 
            }
        }

        
        if (list.size() == 1)
            return list.get(0);
        else
            return -1;
        }


    // Problem 5: Smart Pair Finder
    public boolean pairSumEqualToTarget(int target)
    {
        int arraySize=nums.length;
        for(int i = 0 ; i < arraySize - 1 ; i++)
        {
            for(int j = i + 1 ; j < arraySize ; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    // Problem 6: The Minimalist Painter
    public int minimalistPainter(){
        int totaltime = 0;
        int minimumtime;
        for(int num : nums )
            totaltime += num;
            minimumtime = totaltime;
        for(int num : nums)
        {
            if(totaltime - num < minimumtime){
                minimumtime = totaltime - num;
            }
        }
    return minimumtime;
    }
}
