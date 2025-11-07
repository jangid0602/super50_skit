/**
 * @filename - story10.cpp
 * @description - Resume Similarity Score
 * @author - Fatimi Bee 
 */


#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

int findSimilarityScore(vector<string> resumeV1, vector<string> resumeV2) {
    unordered_map<string, int> freqV1, freqV2;
    int score = 0;

    // Count frequency of each keyword in resumeV1
    for (string word : resumeV1) {
        freqV1[word]++;
    }

    // Count frequency of each keyword in resumeV2
    for (string word : resumeV2) {
        freqV2[word]++;
    }

    // Compare frequencies and sum up minimum occurrences
    for (auto &entry : freqV1) {
        string keyword = entry.first;
        int count1 = entry.second;
        if (freqV2.find(keyword) != freqV2.end()) {
            int count2 = freqV2[keyword];
            score += min(count1, count2);
        }
    }

    return score;
}

int main() {
    vector<string> resumeV1;
    vector<string> resumeV2;
    int size1,size2;
    cout<<"Enter number of keywords in resume v1 and v2 :";
    cin>>size1>>size2;

    cout<<"Enter keywords for resume v1 :";
    for(int i=0;i<size1 ;i++){
        string word;
        cin>>word;
        resumeV1.push_back(word);
    }

    cout<<"Enter keywords for resume v2 :";
    for(int i=0;i<size2 ;i++){
        string word;
        cin>>word;
        resumeV2.push_back(word);
    }

    cout << "Output: " << findSimilarityScore(resumeV1, resumeV2) << endl;
    // Expected Output: 2

    return 0;
}
