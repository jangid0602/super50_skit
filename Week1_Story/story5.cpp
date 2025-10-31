/**
 * @filename - Story5.cpp
 * @description - Smart Pair Finder
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool smartPairFinder(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) return true;
        else if (sum < target) left++;
        else right--;
    }
    return false;
}


// Mainn function
int main(){
vector<int> nums;
// Input
cout << "Enter number of elements: ";
int size;
cin>>size;

cout << "Enter elements: ";
for (int i = 0; i < size; i++)
{
    int value;
    cin>>value;
    nums.push_back(value);
}
cout << "Enter target sum: ";
int target;
cin>>target;

// Functon call and output
if (smartPairFinder(nums, target))
    cout << "Pair found with the given target sum.\n";
else
    cout << "No pair found.\n";
}