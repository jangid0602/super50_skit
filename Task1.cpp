// @Filename - Task1.cpp
// @Description - The Efficient Traveler 
// @Author - Ayushi Shukla
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int FarthestCity(vector<int>& nums, int initialEnergy){
        for(int i=0;i<nums.size();i++){
            initialEnergy=initialEnergy-nums[i];
            if(initialEnergy<0){
                return i;
            }
            }
            return nums.size()-1;
        }
    };

int main(){
    int size;
    cout<<"Enter size of array (in integers) : ";
    cin>>size;
    vector<int>nums(size);
    cout<<"enter array elements (in integer) : "<<endl;
    for(int i=0;i<size;i++){
        cin>>nums[i];
    }
    int initialEnergy;
    cout<<"Enter the initial energy(in integers): ";
    cin>>initialEnergy;
    Solution object;
    int answer=object.FarthestCity(nums,initialEnergy);
    cout<<answer<<endl;

}