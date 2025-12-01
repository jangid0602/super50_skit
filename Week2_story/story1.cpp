/**
 * @filename   : story1.cpp
 * @description: The Trendsetter Score
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int findTrendsetterScore(vector<int>& arr, int k) {
    unordered_map<int, int> freq;
    int score = 0, left = 0;

    for (int right = 0; right < arr.size(); right++) {
        freq[arr[right]]++;

        if (right - left + 1 > k) {
            freq[arr[left]]--;
            if (freq[arr[left]] == 0) freq.erase(arr[left]);
            left++;
        }

        if (right - left + 1 == k) {
            int maxFreq = 0, countMax = 0;
            for (auto& p : freq) {
                if (p.second > maxFreq) {
                    maxFreq = p.second;
                    countMax = 1;
                } else if (p.second == maxFreq) countMax++;
            }
            if (countMax == 1) score++;
        }
    }

    return score;
}

int main() {
    int n, k;
    cout << "Enter number of posts and window size: ";
    cin >> n >> k;

    vector<int> posts(n);
    cout << "Enter posts: ";
    for (int i = 0; i < n; i++) cin >> posts[i];

    cout << "Trendsetter Score: " << findTrendsetterScore(posts, k) << endl;
    return 0;
}
