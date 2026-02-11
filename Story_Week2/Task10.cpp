// @filename-Task10.cpp
// @Description: Calculates the similarity score between two resumes based on common keyword frequency.
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

class ResumeSimilarityCalculator
{
public:
    int calculateSimilarityScore(const vector<string> &resumeV1, const vector<string> &resumeV2)
    {
        unordered_map<string, int> frequencyV1, frequencyV2;

        // Count frequencies of keywords in both resumes
        for (const string &keyword : resumeV1)
            frequencyV1[keyword]++;
        for (const string &keyword : resumeV2)
            frequencyV2[keyword]++;

        int similarityScore = 0;
        // Calculate similarity score based on minimum frequencies of common keywords
        for (const auto &entry : frequencyV1)
        {
            const string &keyword = entry.first;
            if (frequencyV2.find(keyword) != frequencyV2.end())
            {
                similarityScore += min(entry.second, frequencyV2[keyword]);
            }
        }

        return similarityScore;
    }
};

int main()
{
    int sizeV1, sizeV2;

    cout << "Enter number of keywords in Resume V1: ";
    cin >> sizeV1;
    vector<string> resumeV1(sizeV1);
    cout << "Enter keywords for Resume V1:\n";
    for (int i = 0; i < sizeV1; i++)
        cin >> resumeV1[i];

    cout << "Enter number of keywords in Resume V2: ";
    cin >> sizeV2;
    vector<string> resumeV2(sizeV2);
    cout << "Enter keywords for Resume V2:\n";
    for (int i = 0; i < sizeV2; i++)
        cin >> resumeV2[i];

    ResumeSimilarityCalculator calculator;
    int similarityScore = calculator.calculateSimilarityScore(resumeV1, resumeV2);

    cout << "\nSimilarity Score: " << similarityScore << endl;

    return 0;
}
