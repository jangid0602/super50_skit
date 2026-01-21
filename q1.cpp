// The Floor is Lava
// Explanation: The goal is to find the longest "stable" path. You are traversing an array, and
// you can only move to the next index if the "jump" (difference in height) is manageable ( <=
// k). If the difference is too large, the streak breaks, and you start counting again from the
// current position.
// Test Cases:
// 1. Input: heights = [1, 2, 5, 8], k = 3 ? Output: 4 (Differences are 1, 3, 3; all $\le 3$)
// 2. Input: heights = [10, 20, 22, 23, 30], k = 2 ? Output: 3 (The subarray [20, 22, 23] is the longest)
// 3. Input: heights = [5, 15, 25], k = 5 ? Output: 1 (No two adjacent elements are within 5 units)


#include<iostream>
#include<vector>
#include <cstdlib>
using namespace std;

int longestStablePath(vector<int>& heights, int k) {
    int maxLength = 1;
    int currentLength = 1;

    for (size_t i = 1; i < heights.size(); ++i) {
        if (abs(heights[i] - heights[i - 1]) <= k) {
            currentLength++;
        } else {
            maxLength = max(maxLength, currentLength);
            currentLength = 1;
        }
    }
    maxLength = max(maxLength, currentLength);
    return maxLength;
}

int main(){
    vector<int> heights ;
    int x,k;
    cout<<"Enter the number of elements";
    cin>>x;
    for(int i=0;i<x;i++){
        cin>>k;
        heights.push_back(k);
    }
    int t;
    cout<<"Enter the jump";
    cin>>t;
    cout << "Longest stable path length: " << longestStablePath(heights, t) << endl;
    return 0;
}
