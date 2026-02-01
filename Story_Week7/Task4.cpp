/**
 * @filename - Task4.cpp
 * @description - Placement Marathon 
 * @author - Ayushi Shukla
 */
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int longestSubsequence(vector<int>& arr, int k) {
    unordered_map<int,int> dp;
    int ans = 0;

    for(int x : arr) {
        int prev1 = dp.count(x - k) ? dp[x - k] : 0;
        int prev2 = dp.count(x + k) ? dp[x + k] : 0;

        dp[x] = 1 + max(prev1, prev2);
        ans = max(ans, dp[x]);
    }

    return ans;
}

int main() {
    int N;
    cout << "Enter size: ";
    cin >> N;

    vector<int> arr(N);
    cout << "Enter elements: ";
    for(int i = 0; i < N; i++) cin >> arr[i];

    int k;
    cout << "Enter k: ";
    cin >> k;

    cout << longestSubsequence(arr, k);
    return 0;
}