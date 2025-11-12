/**
 * @filename   : story4.cpp
 * @description: Maximal Pair Matching
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int countPairs(vector<int>& nums, int target) {
    unordered_map<int, int> freq;
    int pairs = 0;

    for (int val : nums) {
        int need = target - val;
        if (freq[need] > 0) {
            pairs++;
            freq[need]--;
        } else {
            freq[val]++;
        }
    }

    return pairs;
}

int main() {
    int n, t;
    cout << "Enter size and target sum: ";
    cin >> n >> t;

    vector<int> nums(n);
    cout << "Enter numbers: ";
    for (int i = 0; i < n; i++) cin >> nums[i];

    cout << "Max Pairs: " << countPairs(nums, t) << endl;
    return 0;
}
