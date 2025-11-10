#include <iostream>
#include <vector>
using namespace std;

bool isPermutationPresent(string &text, string &pattern) {
    int textLength = text.size();
    int patternLength = pattern.size();
    if (textLength < patternLength) return false;

    vector<int> patternFreq(26, 0);
    vector<int> windowFreq(26, 0);

    for (int i = 0; i < patternLength; i++) {
        windowFreq[text[i] - 'a']++;
    }
    for (char c : pattern) {
        patternFreq[c - 'a']++;
    }

    for (int i = 0; i <= textLength - patternLength; i++) {
        if (patternFreq == windowFreq) {
            return true;
        }
        if (i < textLength - patternLength) {
            windowFreq[text[i] - 'a']--;
            windowFreq[text[i + patternLength] - 'a']++;
        }
    }
    return false;
}

int main() {
    string text, pattern;
    cout << "Enter Superstring: ";
    cin >> text;
    cout << "Enter Substring: ";
    cin >> pattern;
    cout << (isPermutationPresent(text, pattern) ? "true" : "false");
    return 0;
}
