/**
 * @filename - story5.cpp
 * @description - Subarray color matching (0, 1, 2 all affect balance)
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

// Function to find longest subarray with equal 0s, 1s, and 2s
int longestBalancedColorSubarray(vector<int>& nums) {
    // Each key in map is a pair difference (diff1, diff2) encoded as a string
    unordered_map<string, int> seen;
    seen["0#0"] = -1; // Base case: diff1=0, diff2=0 at index -1

    int count0 = 0, count1 = 0, count2 = 0;
    int maxLen = 0;

    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == 0) count0++;
        else if (nums[i] == 1) count1++;
        else if (nums[i] == 2) count2++;

        // Differences to normalize 3 counts
        int diff10 = count1 - count0;
        int diff21 = count2 - count1;

        string key = to_string(diff10) + "#" + to_string(diff21);

        if (seen.find(key) != seen.end()) {
            int prevIndex = seen[key];
            maxLen = max(maxLen, i - prevIndex);
        } else {
            seen[key] = i;
        }
    }

    return maxLen;
}

int main() {
    int size;
    cout << "Enter number of elements: ";
    cin >> size;

    vector<int> nums(size);
    cout << "Enter elements (0, 1, or 2): " << endl;
    for (int i = 0; i < size; i++) {
        cin >> nums[i];
    }

    cout << "Answer: " << longestBalancedColorSubarray(nums) << endl;
    return 0;
}
