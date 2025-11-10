/**
 * @filename - story2-1.cpp
 * @description -  The Trendsetter Score 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int calculateTrendsetterScore(vector<int>& postIDs, int windowSize) {
    int totalPosts = postIDs.size();
    if (windowSize > totalPosts) return 0;

    unordered_map<int, int> frequencyMap;
    int trendsetterScore = 0;

    for (int i = 0; i < windowSize; i++) frequencyMap[postIDs[i]]++;

    auto hasUniqueTopPost = [&]() {
        int highestFrequency = 0, highestCount = 0;
        for (auto &entry : frequencyMap) {
            if (entry.second > highestFrequency) {
                highestFrequency = entry.second;
                highestCount = 1;
            } else if (entry.second == highestFrequency) {
                highestCount++;
            }
        }
        return highestCount == 1;
    };

    if (hasUniqueTopPost()) trendsetterScore++;

    for (int i = windowSize; i < totalPosts; i++) {
        frequencyMap[postIDs[i - windowSize]]--;
        if (frequencyMap[postIDs[i - windowSize]] == 0) frequencyMap.erase(postIDs[i - windowSize]);
        frequencyMap[postIDs[i]]++;

        if (hasUniqueTopPost()) trendsetterScore++;
    }

    return trendsetterScore;
}

int main() {
    int totalPosts, windowSize;
    cout << "Enter number of posts: ";
    cin >> totalPosts;
    vector<int> postIDs(totalPosts);
    cout << "Enter post IDs: ";
    for (int i = 0; i < totalPosts; i++) cin >> postIDs[i];

    cout << "Enter window size k: ";
    cin >> windowSize;

    cout << "Trendsetter score: " << calculateTrendsetterScore(postIDs, windowSize) << endl;
    return 0;
}
