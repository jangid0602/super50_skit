/**
 * @filename - story2-3.cpp
 * @description - E-Commerce Funnel Analysis 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
#include <sstream>
using namespace std;

string findMostVisitedTwoStepPath(vector<string> &userActions) {
    unordered_map<string, vector<string>> userPages;

    for (string action : userActions) {
        stringstream ss(action);
        string userId, pageName;
        getline(ss, userId, ',');
        getline(ss, pageName, ',');
        userPages[userId].push_back(pageName);
    }

    map<string, int> pathFrequency;
    for (auto &entry : userPages) {
        vector<string> pagesVisited = entry.second;
        for (int i = 0; i + 1 < pagesVisited.size(); i++) {
            string path = pagesVisited[i] + "," + pagesVisited[i + 1];
            pathFrequency[path]++;
        }
    }

    string mostFrequentPath = "";
    int highestFrequency = 0;
    for (auto &entry : pathFrequency) {
        if (entry.second > highestFrequency) {
            highestFrequency = entry.second;
            mostFrequentPath = entry.first;
        }
    }

    return mostFrequentPath;
}

int main() {
    int n;
    cout << "Enter number of user actions: ";
    cin >> n;
    cin.ignore(); 

    vector<string> userActions(n);
    cout << "Enter each action in the format userId,pageName (e.g., u1,home):\n";
    for (int i = 0; i < n; i++) {
        getline(cin, userActions[i]);
    }

    string result = findMostVisitedTwoStepPath(userActions);

    cout << "\nMost frequent 2-step path: " << result << endl;

    return 0;
}
