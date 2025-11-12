/**
 * @filename   : story3.cpp
 * @description: E-Commerce Funnel Analysis
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
using namespace std;

string findPopularPath(vector<string>& actions) {
    unordered_map<string, string> lastSeen;
    unordered_map<string, int> pathCount;
    string result = "";
    int best = 0;

    for (string entry : actions) {
        int pos = entry.find(',');
        string user = entry.substr(0, pos);
        string page = entry.substr(pos + 1);

        if (lastSeen.count(user)) {
            string path = lastSeen[user] + "," + page;
            pathCount[path]++;
            if (pathCount[path] > best || 
                (pathCount[path] == best && path < result)) {
                best = pathCount[path];
                result = path;
            }
        }
        lastSeen[user] = page;
    }

    return result;
}

int main() {
    int n;
    cout << "Enter number of records: ";
    cin >> n;
    vector<string> data(n);

    cout << "Enter user,page pairs: ";
    for (int i = 0; i < n; i++) cin >> data[i];

    cout << "Most Frequent Path: " << findPopularPath(data) << endl;
    return 0;
}
