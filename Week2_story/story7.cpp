/**
 * @filename   : story7.cpp
 * @description: Log File Compaction
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <string>
#include <sstream>
using namespace std;

string compactLogs(string logs) {
    stringstream ss(logs);
    string word, prev = "", result = "";
    int cnt = 0;

    while (ss >> word) {
        if (word == prev) cnt++;
        else {
            if (!prev.empty())
                result += prev + "(" + to_string(cnt) + ") ";
            prev = word;
            cnt = 1;
        }
    }

    if (!prev.empty())
        result += prev + "(" + to_string(cnt) + ")";

    return result;
}

int main() {
    string input;
    getline(cin, input);
    cout << "Compact Logs: " << compactLogs(input) << endl;
    return 0;
}
