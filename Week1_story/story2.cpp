/**
 * @filename    - Story2.cpp
 * @description - The Sum That Stands Out
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
using namespace std;

int SumThatStandsOut(vector<int>& nums) {
    int total = 0;
    for (int v : nums) total += v;
    int prefix = 0;
    for (int i = 0; i < nums.size(); i++) {
        int suffix = total - prefix - nums[i];
        if (prefix == suffix) return i;
        prefix += nums[i];
    }
    return -1;
}

int main() {
    int n;
    cout << "Enter array size: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> nums[i];
    cout << "Index where prefix equals suffix: " << SumThatStandsOut(nums) << endl;
}
