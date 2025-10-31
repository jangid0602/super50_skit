/**
 * @filename - Story4.cpp
 * @description - The Minimalist Painter 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    // Function to calculate minimum total time after skipping one wall
    int findMinTimeAfterSkippingMax(vector<int>& wallTimes) {
        // Find the maximum time (the wall to skip)
        int maxTime = *max_element(wallTimes.begin(), wallTimes.end());

        int n = wallTimes.size();
        int totalTime = 0;

        // Calculate total time of all walls
        for (int i = 0; i < n; i++) {
            totalTime += wallTimes[i];
        }

        // Subtract the maximum time (skip that wall)
        return totalTime - maxTime;
    }
};

int main() {
    int size;
    cout << "Enter number of walls: ";
    cin >> size;

    vector<int> wallTimes(size);
    cout << "Enter time taken for each wall: ";
    for (int i = 0; i < size; i++) {
        cin >> wallTimes[i];
    }

    Solution obj;
    cout << "Minimum total time after skipping one wall is: ";

    // Call the function and display result
    int result = obj.findMinTimeAfterSkippingMax(wallTimes);
    cout << result;

    return result;
}
