#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int longestStablePath(vector<int>& height, int k) {
    int n = height.size();
    int maxLen = 1;
    int currLen = 1;

    for (int i = 1; i < n; i++) {
        if (abs(height[i] - height[i - 1]) <= k) {
            currLen++;
        } else {
            currLen = 1;
        }
        maxLen = max(maxLen, currLen);
    }
    return maxLen;
}

int main() {
    int n, k;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> height(n);
    cout << "Enter heights: ";
    for (int i = 0; i < n; i++) {
        cin >> height[i];
    }

    cout << "Enter allowed height difference k: ";
    cin >> k;

    cout << "Longest stable path length: "
         << longestStablePath(height, k);

    return 0;
}
