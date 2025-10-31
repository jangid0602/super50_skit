/**
 * @filename - Story4.cpp
 * @description - The Sum That Stands Out 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    // Function to find the index where prefix sum equals suffix sum
    int findEquilibriumIndex(vector<int>& nums) {
        int n = nums.size();
        int prefixSum = 0;     // to store running prefix sum
        int totalSum = 0;      // to store total sum of all elements
        // Step 1: Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        // Step 2: Traverse the array to find equilibrium index
        for (int index = 0; index < n; index++) {
            int suffixSum = totalSum - nums[index] - prefixSum; // sum of elements after current index

            // Check if prefix sum equals suffix sum
            if (prefixSum == suffixSum) {
                return index; // equilibrium index found
            }
            // Update prefix sum by adding current element
            prefixSum += nums[index];
        }
        // If no equilibrium index found, return -1
        return -1;
    }
};

int main() {
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    vector<int> nums(size); // vector to store input elements
    cout << "Enter array elements: ";
    for (int i = 0; i < size; i++) {
        cin >> nums[i];
    }

    Solution obj;
    int result = obj.findEquilibriumIndex(nums);

    cout << "Equilibrium Index: " << result;
    return 0;
}
