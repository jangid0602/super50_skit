#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    //  The Efficient Traveler
    int farthestCity(vector<int>& nums, int initialEnergy) {
        long long energy = initialEnergy;
        for (int i = 0; i < nums.size(); i++) {
            energy -= nums[i];
            if (energy < 0) return i - 1;
        }
        return nums.size() - 1;
    }

    //  The Sum That Stands Out
    int findBalanceIndex(vector<int>& nums) {
        long long total = 0, prefix = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.size(); i++) {
            long long suffix = total - prefix - nums[i];
            if (prefix == suffix) return i;
            prefix += nums[i];
        }
        return -1;
    }

    // Flip the Switch
    int minFlips(vector<int>& nums) {
        int count0 = 0, count1 = 0;
        for (int x : nums) {
            if (x == 0) count0++;
            else count1++;
        }
        return min(count0, count1);
    }

    //  The Odd One Out
    int singleNumber(vector<int>& nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }

    //  Smart Pair Finder
    bool hasPairWithSum(vector<int>& nums, int k) {
        unordered_set<int> seen;
        for (int num : nums) {
            if (seen.count(k - num)) return true;
            seen.insert(num);
        }
        return false;
    }

    //  The Minimalist Painter
    int minimalPaintingTime(vector<int>& time) {
        int total = 0, maxTime = 0;
        for (int t : time) {
            total += t;
            maxTime = max(maxTime, t);
        }
        return total - maxTime;
    }
};

int main() {
    Solution sol;
    int choice;
    cout << "Choose Problem (1-6): ";
    cin >> choice;

    if (choice == 1) {
        int n, initialEnergy;
        cout << "Enter number of cities: ";
        cin >> n;
        vector<int> nums(n);
        cout << "Enter energy costs: ";
        for (int i = 0; i < n; i++) cin >> nums[i];
        cout << "Enter initial energy: ";
        cin >> initialEnergy;
        cout << "Farthest City: " << sol.farthestCity(nums, initialEnergy) << endl;
    }
    else if (choice == 2) {
        int n;
        cout << "Enter size of array: ";
        cin >> n;
        vector<int> nums(n);
        cout << "Enter elements: ";
        for (int i = 0; i < n; i++) cin >> nums[i];
        cout << "Balance Index: " << sol.findBalanceIndex(nums) << endl;
    }
    else if (choice == 3) {
        int n;
        cout << "Enter size of binary array: ";
        cin >> n;
        vector<int> nums(n);
        cout << "Enter elements (0/1): ";
        for (int i = 0; i < n; i++) cin >> nums[i];
        cout << "Minimum Flips: " << sol.minFlips(nums) << endl;
    }
    else if (choice == 4) {
        int n;
        cout << "Enter size of array: ";
        cin >> n;
        vector<int> nums(n);
        cout << "Enter elements: ";
        for (int i = 0; i < n; i++) cin >> nums[i];
        cout << "Odd One Out: " << sol.singleNumber(nums) << endl;
    }
    else if (choice == 5) {
        int n, k;
        cout << "Enter size of array: ";
        cin >> n;
        vector<int> nums(n);
        cout << "Enter elements: ";
        for (int i = 0; i < n; i++) cin >> nums[i];
        cout << "Enter target sum (k): ";
        cin >> k;
        cout << (sol.hasPairWithSum(nums, k) ? "Pair Exists" : "No Pair Found") << endl;
    }
    else if (choice == 6) {
        int n;
        cout << "Enter number of walls: ";
        cin >> n;
        vector<int> time(n);
        cout << "Enter painting times: ";
        for (int i = 0; i < n; i++) cin >> time[i];
        cout << "Minimal Painting Time: " << sol.minimalPaintingTime(time) << endl;
    }
    else {
        cout << "Invalid choice!" << endl;
    }

    return 0;
}
