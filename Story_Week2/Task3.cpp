// @filename-Task3.cpp
// @Description: Finds the most frequent 2-step path taken by users in an e-commerce platform.
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
#include <sstream>
using namespace std;

class FunnelAnalyzer
{
public:
    string findMostFrequentTwoStepPath(const vector<string> &userActions)
    {
        unordered_map<string, vector<string>> userPages; // userID -> pages visited

        // Step 1: Group pages visited by each user
        for (const string &action : userActions)
        {
            stringstream ss(action);
            string userId, pageName;
            getline(ss, userId, ',');
            getline(ss, pageName, ',');
            userPages[userId].push_back(pageName);
        }

        map<string, int> pathFrequency; // path -> count (map keeps keys sorted for tie-breaking)

        // Step 2: Count all 2-step paths
        for (const auto &entry : userPages)
        {
            const vector<string> &pagesForUser = entry.second;
            for (size_t i = 0; i + 1 < pagesForUser.size(); i++)
            {
                string path = pagesForUser[i] + "," + pagesForUser[i + 1];
                pathFrequency[path]++;
            }
        }

        // Step 3: Find the path with maximum frequency (lexicographically first if tie)
        string mostFrequentPath;
        int maxFrequency = 0;

        for (const auto &entry : pathFrequency)
        {
            if (entry.second > maxFrequency)
            {
                maxFrequency = entry.second;
                mostFrequentPath = entry.first;
            }
        }

        return mostFrequentPath;
    }
};

int main()
{
    int n;
    cout << "Enter number of user actions: ";
    cin >> n;
    cin.ignore(); // ignore leftover newline

    vector<string> userActions(n);
    cout << "Enter each action in the format userId,pageName (e.g., u1,home):\n";
    for (int i = 0; i < n; i++)
    {
        getline(cin, userActions[i]);
    }

    FunnelAnalyzer analyzer;
    string result = analyzer.findMostFrequentTwoStepPath(userActions);

    cout << "\nMost frequent 2-step path: " << result << endl;

    return 0;
}
