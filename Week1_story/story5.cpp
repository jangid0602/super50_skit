/**
 * @filename    - Story5.cpp
 * @description - Smart Pair Finder
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
using namespace std;

bool SmartPairFinder(vector<int>& nums, int k) {
    for (int i = 0; i < nums.size() - 1; i++)
        for (int j = i + 1; j < nums.size(); j++)
            if (nums[i] + nums[j] == k) return true;
    return false;
}

int main() {
    int n, k;
    cout << "Enter array size: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> nums[i];
    cout << "Enter target sum: ";
    cin >> k;
    cout << (SmartPairFinder(nums, k) ? "Pair exists" : "No such pair") << endl;
}
