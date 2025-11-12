/**
 * @filename   : story5.cpp
 * @description: Subarray Color Matching (equal 0s,1s,2s)
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
using namespace std;

int longestBalanced(vector<int>& nums) {
    unordered_map<string, int> seen;
    seen["0#0"] = -1;

    int c0 = 0, c1 = 0, c2 = 0;
    int best = 0;

    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == 0) c0++;
        else if (nums[i] == 1) c1++;
        else c2++;

        int d1 = c1 - c0;
        int d2 = c2 - c1;

        string key = to_string(d1) + "#" + to_string(d2);
        if (seen.count(key)) best = max(best, i - seen[key]);
        else seen[key] = i;
    }

    return best;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter 0,1,2 values: ";
    for (int i = 0; i < n; i++) cin >> nums[i];

    cout << "Longest Balanced Length: " << longestBalanced(nums) << endl;
    return 0;
}
