/**
 * @filename    - Story3.cpp
 * @description - Flip the Switch
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
using namespace std;

int FlipTheSwitch(vector<int>& nums) {
    int zeros = 0, ones = 0;
    for (int v : nums) (v == 0 ? zeros : ones)++;
    return min(zeros, ones);
}

int main() {
    int n;
    cout << "Enter array size: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter binary elements (0/1): ";
    for (int i = 0; i < n; i++) cin >> nums[i];
    cout << "Minimum flips required: " << FlipTheSwitch(nums) << endl;
}
