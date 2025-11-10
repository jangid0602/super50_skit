#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    int resume1KeywordCount, resume2KeywordCount;
    cout << "Enter number of keywords in Resume 1: ";
    cin >> resume1KeywordCount;

    vector<string> resume1Keywords(resume1KeywordCount);
    cout << "Enter keywords for Resume 1:\n";
    for (int i = 0; i < resume1KeywordCount; i++) {
        cin >> resume1Keywords[i];
    }

    cout << "Enter number of keywords in Resume 2: ";
    cin >> resume2KeywordCount;

    vector<string> resume2Keywords(resume2KeywordCount);
    cout << "Enter keywords for Resume 2:\n";
    for (int i = 0; i < resume2KeywordCount; i++) {
        cin >> resume2Keywords[i];
    }

    unordered_map<string, int> resume1Frequency, resume2Frequency;
    for (const string& keyword : resume1Keywords) resume1Frequency[keyword]++;
    for (const string& keyword : resume2Keywords) resume2Frequency[keyword]++;

    int similarityScore = 0;
    for (auto& entry : resume1Frequency) {
        string keyword = entry.first;
        if (resume2Frequency.find(keyword) != resume2Frequency.end()) {
            similarityScore += min(entry.second, resume2Frequency[keyword]);
        }
    }

    cout << "\nSimilarity Score: " << similarityScore << endl;
    return 0;
}
