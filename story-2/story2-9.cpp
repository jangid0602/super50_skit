/**
 * @filename - story2-9.cpp
 * @description - Chat Message Redaction
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

string filterBannedWordsFromMessage(string originalMessage, vector<string>& bannedWordList) {
    string lowerCaseMessage = originalMessage;
    transform(lowerCaseMessage.begin(), lowerCaseMessage.end(), lowerCaseMessage.begin(), ::tolower);

    for (string bannedWord : bannedWordList) {
        transform(bannedWord.begin(), bannedWord.end(), bannedWord.begin(), ::tolower);
        size_t position = 0;

        while ((position = lowerCaseMessage.find(bannedWord, position)) != string::npos) {
            for (size_t i = 0; i < bannedWord.size(); i++) {
                originalMessage[position + i] = '*';
            }
            position += bannedWord.size();
        }
    }
    return originalMessage;
}

int main() {
    string inputMessage;
    cout << "Enter Message: ";
    getline(cin, inputMessage);

    int bannedWordCount;
    cout << "Enter number of banned words: ";
    cin >> bannedWordCount;
    cin.ignore();

    vector<string> bannedWordList(bannedWordCount);
    cout << "Enter Banned Words:\n";
    for (int i = 0; i < bannedWordCount; i++) {
        getline(cin, bannedWordList[i]);
    }

    string censoredMessage = filterBannedWordsFromMessage(inputMessage, bannedWordList);

    cout << "\nCensored message: " << censoredMessage << endl;
    return 0;
}
