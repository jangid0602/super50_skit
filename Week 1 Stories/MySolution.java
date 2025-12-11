/*      
 * @filename - MySolution.java
 * @description - This file contains all the solutions for the first six problems
 *                from the "Week 1 Stories" assignment.
 * @author - Khushi Gehlot
 */

import java.util.HashSet;

public class MySolution {

    public int GetFarthestCityIndex(int[] EnergyCost , int InitialEnergy)
    {
        for(int i=0; i<EnergyCost.length; i++)
        {
            if(InitialEnergy < EnergyCost[i])
            {
                return i;
            }
            else
            {
                InitialEnergy -= EnergyCost[i];
            }
            if(InitialEnergy <= 0)
            {
                return i+1;
            }
        }
    
        return EnergyCost.length - 1;
    }

    public int findBalancedIndex(int[] array, int SizeOfArray) 
    {
        int PreffixSum = 0; 
        int SuffixSum = 0;
        int TotalSum = 0;
        for(int i = 0; i< SizeOfArray; i++)
        {
            TotalSum += array[i];
        }
        SuffixSum = TotalSum;

        for(int i = 0; i< SizeOfArray; i++)
        {
            SuffixSum -= array[i];
            if(PreffixSum == SuffixSum )
            {
                return i;
            }
            PreffixSum += array[i];
        }
        return -1;
    }

    public int getMinNoFlips(int[] switches, int SizeOfArray) 
    {
        int CountZeros = 0; 
        for(int i = 0; i< SizeOfArray; i++)
        {
            if(switches[i] == 0)
            {
                CountZeros++;
            }
        }
        return Math.min(CountZeros, SizeOfArray - CountZeros);
        
    }
      public int findOddOneOut(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return nums[i];
            }
        }
        return -1; // if no such element exists
    }

    // 5. Smart Pair Finder (Brute Force)
    // Check if any two elements add up to k.
    public boolean hasPairWithSum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 6. The Minimalist Painter
    public int getMinimalistPainterTime(int[] time) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int t : time) {
            total += t;
            if (t > max) max = t;
        }
        return total - max; // skip the wall that takes the longest time
    }

    
}
