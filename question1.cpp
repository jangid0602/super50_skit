#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int SmartPairFinder(vector<int>& arr, int size, int target) {
        unordered_map<int, int> prefixCount;
        int prefixSum = 0, count = 0;

        for (int i = 0; i < size; i++) {
            prefixSum += arr[i];//current prefix sum
            if (prefixSum == target) {
                count++;
            }
            if (prefixCount.find(prefixSum - target) != prefixCount.end()) {//check if there is a prefix sum that when subtracted from current prefix sum gives target
                count += prefixCount[prefixSum - target];//add the count of subarrays found 
            }
            prefixCount[prefixSum]++;
        }

        return count;
    }
};

int main() {
    int size;
    cout << "Enter size of array (in integers): ";
    cin >> size;

    vector<int> nums(size);
    cout << "Enter array elements (in integers): " << endl;
    for (int i = 0; i < size; i++) {
        cin >> nums[i];
    }

    int target;
    cout << "Enter the target sum (in integers): ";
    cin >> target;

    Solution object;
    int answer = object.SmartPairFinder(nums, size, target);
    cout << "Number of subarrays with sum = " << target << " is: " << answer << endl;

    return 0;
}
