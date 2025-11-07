/**
 * @filename - story3.cpp
 * @description - E-Commerce funnel Analysis
 * @author - Fatimi Bee 
 */


#include <iostream>
#include<vector>
#include<unordered_map>
#include<string>
using namespace std;

string mostFrequentTwoStepPath(vector<string>& actions) {
    unordered_map<string, string> lastPageOfUser;     // user → last page visited
    unordered_map<string, int> pathFrequency;         // "A,B" → count

    for (string action : actions) {
        int commaIndex = action.find(',');
        string userId = action.substr(0, commaIndex);
        string page = action.substr(commaIndex + 1);

        // If user has a previous page, form a path
        if (lastPageOfUser.count(userId)) {
            string path = lastPageOfUser[userId] + "," + page;
            pathFrequency[path]++;
        }

        lastPageOfUser[userId] = page;
    }

    // Select most frequent, tie → lexicographically smallest
    string resultPath = "";
    int maxCount = 0;

    for (auto& entry : pathFrequency) {
        if (entry.second > maxCount ||
           (entry.second == maxCount && entry.first < resultPath)) {
            maxCount = entry.second;
            resultPath = entry.first;
        }
    }

    return resultPath;
}

int main() {
    // Example use:
    int size;
    cout<<"Enter number of path you have :";
    cin>>size;

    vector<string> actions(size);
    cout<<"Enter userId and page visited (format : userId,page) :";
    for(int i=0; i<size ;i++){
        cin>>actions[i];
    }

    cout << mostFrequentTwoStepPath(actions) << endl;

    

    return 0;
}