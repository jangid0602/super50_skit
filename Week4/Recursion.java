
import java.util.ArrayList;
import java.util.List;

public class Recursion {
    int stairArchitect(int n){
        if(n==0||n==1){
            return 1;
        }
        return stairArchitect(n-1)+stairArchitect(n-2);
    }

    boolean isPalindrome(String str, int left, int right){
        if(left>=right){
            return true;
        }
        if(str.charAt(left)!=str.charAt(right)){
            return false;
        }
        return isPalindrome(str,left+1,right-1);
    }

    List<String> generateSubsets(String str, int index, List<String> subsets, String current){
        if(index==str.length()){
            subsets.add(current);
            return subsets;
        }
        // Include the current character
        generateSubsets(str, index+1, subsets, current + str.charAt(index));
        // Exclude the current character
        generateSubsets(str, index+1, subsets, current);
        return subsets;         

    }

    void generateCodes(int[] digits, boolean[] used, List<Integer> result, String current) {
        // Base Case: code length is 3
        if (current.length() == 3) {
            result.add(Integer.parseInt(current));
            return;
        }

        // Try each digit
        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generateCodes(digits, used, result, current + digits[i]);
                used[i] = false; // backtrack
            }
        }
    }

    String compressString(String str){
        if (str.length() == 0) {
            return "";
        }

        char first = str.charAt(0);
        int count = 1;
        int i = 1;
        while (i < str.length() && str.charAt(i) == first) {
            count++;
            i++;
        }
        return count + "" + first + compressString(str.substring(i));

    }

    void combinationSum(int [] amounts,int target,List<List<Integer>> result,List<Integer> current,int start){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<amounts.length;i++){
            current.add(amounts[i]);
            combinationSum(amounts,target-amounts[i],result,current,i);
            current.remove(current.size()-1);
        }
    }
}