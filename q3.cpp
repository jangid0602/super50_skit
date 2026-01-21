// Encrypted Palindrome
// Explanation: First, transform every vowel in the string using the mapping: a→e, e→i, i→o,
// o→u, u→a. After the transformation, check if the resulting string reads the same forwards
// and backwards.
// Test Cases:
// 2. Input: s = "ace" → Output: false (Becomes "eci")
// 3. Input: s = "vutuv" → Output: true (Vowel 'u' becomes 'a'. "vatav" is a palindrome).

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
bool isEncryptedPalindrome(const string& s) {
    unordered_map<char, char> vowelMap = {
        {'a', 'e'},
        {'e', 'i'},
        {'i', 'o'},
        {'o', 'u'},
        {'u', 'a'},
        {'A', 'E'},
        {'E', 'I'},
        {'I', 'O'},
        {'O', 'U'},
        {'U', 'A'}
    };

    string transformed;
    for (char c : s) {
        if (vowelMap.find(c) != vowelMap.end()) {
            transformed += vowelMap[c];
        } else {
            transformed += c;
        }
    }

    int left = 0;
    int right = transformed.size() - 1;
    while (left < right) {
        if (transformed[left] != transformed[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
int main() {
    string s;
    cout << "Enter a string: ";
    getline(cin, s);
    if (isEncryptedPalindrome(s)) {
        cout << "The encrypted string is a palindrome." << endl;
    } else {
        cout << "The encrypted string is not a palindrome." << endl;
    }
    return 0;
}