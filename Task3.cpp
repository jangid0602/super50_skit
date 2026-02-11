// @Filename - Task1.cpp
// @Description -  Flip the Switch 
// @Author - Ayushi Shukla
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Solution{
    public:
    int FlipTheSwitch(vector<int>& nums, int size){
        int count0=0, count1=0;
        for(int i=0;i<size;i++){
            if(nums[i]==0){
                count0++;
            }
            else{
                count1++; 
            }
    }
    return min(count0,count1);
    }
};
int main(){
      int size;
    cout << "Enter size of array (in integers): ";
    cin >> size;

    vector<int> nums(size);
    cout << "Enter binary array elements (0 or 1): ";
    for (int i = 0; i < size; i++)
        cin >> nums[i];

    Solution sol;
    cout << "Minimum number of flips required: " << sol.FlipTheSwitch(nums,size) << endl;

    return 0;
}