/**
 * Filename- VaultCode.java
 * Description- You have a set of items with different prices. You want to find all 
combinations of items that sum up exactly to your total budget $B$. You 
can use each item multiple times.  
 * Author - Nancy Jain
 * Date - 09/01/2026
 */ 

package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BudgetCalculator {
    public static List<List<Integer>> budget(int[] candidates , int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        Calculate(result , new ArrayList<>() ,candidates , target , 0);
        return result;
    }

    private static void Calculate(List<List<Integer>> result, List<Integer> temp , int[] candidates , int target , int start){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start ; i < candidates.length ; i++){
            temp.add(candidates[i]);
            Calculate(result, temp, candidates, target - candidates[i] , i);
            temp.remove(temp.size()-1);
        }
    }
}
