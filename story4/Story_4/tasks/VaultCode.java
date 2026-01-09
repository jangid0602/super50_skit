/**
 * Filename- VaultCode.java
 * Description- A vault requires a 3-digit code using the numbers {1, 2, 3} without 
repetition. Use backtracking to find all possible unique codes that can 
be formed using these digits. 
 * Author - Nancy Jain
 * Date - 08/01/2026
 */ 

package tasks;

import java.util.ArrayList;
import java.util.List;

public class VaultCode {
    public static List<String> generateCodes(){
        int []digits = {1,2,3};
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[3];
        backtrack(digits, used, "", result);
        return result;
    }
    
    private static void backtrack(int[] digits, boolean[] used, String current, List<String> result) {
        if(current.length() == digits.length){
            result.add(current);
            return;
        }
        for(int i = 0; i < digits.length; i++){
            if(used[i]) continue;
            used[i] = true;
            backtrack(digits, used, current+digits[i], result);
            used[i]=false;
        }
    }
}
