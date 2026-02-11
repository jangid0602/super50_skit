// @filename-task1.cpp
// @Description: This program calculates the "trendsetter score" for a series of social media posts.
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int calculateTrendsetterScore(vector<int>& postIDs, int windowSize) {
    int totalPosts = postIDs.size();
    if (windowSize > totalPosts) return 0;

    unordered_map<int, int> frequencyMap;
    int trendsetterScore = 0;

    // Step 1: Initialize the first window
    for (int i = 0; i < windowSize; i++)
        frequencyMap[postIDs[i]]++;

    // Lambda to check if window has a unique most frequent post
    auto hasUniqueTopPost = [&](unordered_map<int, int>& freqMap) {
        int highestFrequency = 0, highestCount = 0;
        for (auto& entry : freqMap) {
            if (entry.second > highestFrequency) {
                highestFrequency = entry.second;
                highestCount = 1;
            } else if (entry.second == highestFrequency) {
                highestCount++;
            }
        }
        return highestCount == 1;
    };

    if (hasUniqueTopPost(frequencyMap))
        trendsetterScore++;

    // Step 2: Slide the window
    for (int i = windowSize; i < totalPosts; i++) {
        int outgoing = postIDs[i - windowSize];
        int incoming = postIDs[i];

        // Update frequencies
        frequencyMap[outgoing]--;
        if (frequencyMap[outgoing] == 0)
            frequencyMap.erase(outgoing);
        frequencyMap[incoming]++;

        if (hasUniqueTopPost(frequencyMap))
            trendsetterScore++;
    }

    return trendsetterScore;
}

int main() {
    int totalPosts, windowSize;
    cout << "Enter number of posts: ";
    cin >> totalPosts;

    vector<int> postIDs(totalPosts);
    cout << "Enter post IDs: ";
    for (int i = 0; i < totalPosts; i++)
        cin >> postIDs[i];

    cout << "Enter window size k: ";
    cin >> windowSize;

    int score = calculateTrendsetterScore(postIDs, windowSize);
    cout << "Trendsetter score: " << score << endl;

    return 0;
}
