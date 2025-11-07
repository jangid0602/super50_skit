/**
 * @filename - story7.cpp
 * @description - Log file compaction
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <string>
using namespace std;

string compactLog(string logs) {
    string word = "", prevWord = "", result = "";
    int count = 0;

    logs += ' '; 

    for (int i = 0; i < logs.size(); i++) {
        if (logs[i] != ' ') {
            word += logs[i];
        } else {
            if (!word.empty()) {
                if (word == prevWord) {
                    count++;
                } else {
                    if (!prevWord.empty()) {
                        result += prevWord + "(" + to_string(count) + ") ";
                    }
                    prevWord = word;
                    count = 1;
                }
                word = "";
            }
        }
    }

    // Add last log entry
    if (!prevWord.empty()) {
        result += prevWord + "(" + to_string(count) + ")";
    }

    return result;
}

int main() {
    string logs1 = "INFO INFO INFO WARN WARN INFO ERROR";
    cout << "Output: " << compactLog(logs1) << endl;

    string logs2 = "ERROR ERROR ERROR ERROR";
    cout << "Output: " << compactLog(logs2) << endl;

    string logs3 = "DEBUG WARN INFO";
    cout << "Output: " << compactLog(logs3) << endl;

    return 0;
}
