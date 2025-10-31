// @Filename - Task1.cpp
// @Description - The Sum That Stands Out 
// @Author - Ayushi Shukla
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Solution
{
    public:
    int TheSumThatStandsOut(vector<int>& nums, int size){
        int TotalSum=0;
        for(int i=0;i<size;i++){
            TotalSum=TotalSum+nums[i];
        }
        int PrefixSum=0;
        for(int i=0;i<size;i++){
            int SuffixSum=TotalSum-PrefixSum-nums[i];
            if(SuffixSum==PrefixSum){
                return i;
            }
            PrefixSum+=nums[i];
        }
        return -1;
    }

};

int main()
{
    int size;
    cout << "Enter size of array (in integers) : ";
    cin >> size;
    vector<int> nums(size);
    cout << "enter array elements (in integer) : " << endl;
    for (int i = 0; i < size; i++)
    {
        cin >> nums[i];
    }
    Solution obj;
    cout<<"Index at which prefix Sum is equals to Suffix Sum : ";
    cout<<obj.TheSumThatStandsOut(nums,size)<<endl;
}