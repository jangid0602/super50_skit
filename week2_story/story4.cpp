/**
 * @filename - story4.cpp
 * @description - Maximal Pair Matching
 * @author - Fatimi Bee 
 */


#include <iostream>
#include<vector>
#include<unordered_map>
using namespace std;

int maxNumberOfPairs(vector<int>& nums, int targetSum) {
    unordered_map<int, int> elementCount;
    int pairCount = 0;

    for (int value : nums) {
        int requiredValue = targetSum - value;

        if (elementCount[requiredValue] > 0) {
            pairCount++;
            elementCount[requiredValue]--;
        } else {
            elementCount[value]++;
        }
    }

    return pairCount;
}
int main(){
    int size, targetSum;
    cout<<"Enter number of elmments :";
    cin>>size;
    vector<int> nums(size);
    cout<<"Enter elements :";
    for(int i=0;i<size;i++){
        cin>>nums[i];
    }
    cout<<"Enter target sum :";
    cin>>targetSum;
    cout<<"Answer : "<<maxNumberOfPairs(nums, targetSum)<<endl;
}
