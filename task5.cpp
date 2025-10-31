/**
 * @filename - Story4.cpp
 * @description - Smart Pair Finder 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findPairWithTargetSum(vector<int>& arr, int target) {
        // Sort the array to apply the two-pointer technique
        sort(arr.begin(), arr.end());
        
        int n = arr.size();
        int left = 0;          // Pointer at the beginning
        int right = n - 1;     // Pointer at the end

        // Move pointers until they meet
        while (left < right) {
            int currentSum = arr[left] + arr[right]; // Calculate sum of current pair
            
            if (currentSum == target) {              // If sum equals target
                cout << "true";                      // Pair found
                return 0;
            } 
            else if (currentSum > target) {          // If sum is too large, move right pointer left
                right--;
            } 
            else {                                   // If sum is too small, move left pointer right
                left++;
            }
        }

        // No such pair found
        cout << "false";
        return 0;
    }
};

int main() {
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    vector<int> arr(size);
    cout << "Enter elements of array: ";
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    int target;
    cout << "Enter target: ";
    cin >> target;

    Solution obj;
    return obj.findPairWithTargetSum(arr, target);
}
