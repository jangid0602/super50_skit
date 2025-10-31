import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
    int size;
    int nums[];

    MyArray(){
        size = 0;
        nums = new int[size];
    }
    MyArray(int size){
        this.size = size;
        nums = new int[size];
    }

    public int theEfficientTraveller(int initialEnergy){
        int ansIndex = -1;
        int length = nums.length;
        int i = 0;
        if(initialEnergy < 0)return -1;
        while(i < length){
            if(initialEnergy > 0 && initialEnergy >= nums[i]){
                initialEnergy -= nums[i];
                i++;
            }
            else break;
        }
        ansIndex = i;
        return ansIndex;
    }

    public int getTheOddOneOut(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(Integer.valueOf(nums[i]));
                continue;
            }
            list.add(nums[i]);
        }
        if(list.size() > 1) return -1;
        return list.get(0);
    }

    public boolean getThePair(int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getMinimumTime(){
        int minimumTime = 0;
        int max = 0;
        int sumOfAll = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
            sumOfAll += nums[i];
        }
        return sumOfAll - max;
    }

    public int getTheSumThatStandsOut(){
        int length = nums.length;
        int totalSum = 0;
        int prefixSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        for(int i = 0; i < length; i++){
            int suffixSum = totalSum - prefixSum - nums[i];
            if(prefixSum == suffixSum)return i;
            prefixSum += nums[i];
        }
        return -1;
    }

    public int flipTheSwitch(){
        int countOfZero = 0;
        int countOfOne = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)countOfOne++;
            if(nums[i] == 0)countOfZero++;
        }
        if(countOfOne > countOfZero)return countOfZero;
        else return countOfOne;
    }




}
