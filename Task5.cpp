// @Filename - Task1.cpp
// @Description -  Smart Pair Finder 
// @Author - Ayushi Shukla
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Solution{
    public:
    int SmartPairFinder(vector<int>& nums, int size, int TargetSum){
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]+nums[j]==TargetSum){
                    return true;
                }
            }
        }
        return false;
    }
};
int main(){
    int size;
    cout<<"Enter size of array (in integers) : ";
    cin>>size;
    vector<int>nums(size);
    cout<<"Enter the elements of array (in integers) : "<<endl;;
    for(int i=0;i<size;i++){
        cin>>nums[i];
    }
    int TargetSum;
    cout<<"Enter the target sum (in integers) : ";
    cin>>TargetSum;
    Solution object;
    if(object.SmartPairFinder(nums,size,TargetSum)){
        cout<<"pair exists"<<endl;
    }
    else{
        cout<<"no such pair exists"<<endl;
    }
}