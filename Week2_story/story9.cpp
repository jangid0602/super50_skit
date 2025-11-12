/**
 * @filename   : story9.cpp
 * @description: Message Redaction 
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

string hideWords(string text, const vector<string>& banned) {
    for (int i = 0; i < banned.size(); i++) {
        string word = banned[i];
        int pos = 0;

        // keep searching until no more matches
        while (true) {
            pos = text.find(word, pos);
            if (pos == string::npos) break;

            // replace word with same length of '*'
            for (int j = 0; j < word.size(); j++)
                text[pos + j] = '*';

            pos += word.size();
        }
    }
    return text;
}

int main() {
    string message;
    cout << "Enter the message:\n";
    getline(cin, message);

    int n;
    cout << "Number of banned words: ";
    cin >> n;

    vector<string> banned(n);
    cout << "Enter banned words:\n";
    for (int i = 0; i < n; i++) cin >> banned[i];

    string redacted = hideWords(message, banned);
    cout << "\nRedacted message:\n" << redacted << endl;

    return 0;
}
