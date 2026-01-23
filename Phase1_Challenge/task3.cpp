#include <iostream>
#include <string>
using namespace std;

char encryptVowel(char ch) {
    if (ch == 'a') return 'e';
    if (ch == 'e') return 'i';
    if (ch == 'i') return 'o';
    if (ch == 'o') return 'u';
    if (ch == 'u') return 'a';
    return ch;
}

bool encryptedPalindrome(string str) {
    
    for (int i = 0; i < str.length(); i++) {
        str[i] = encryptVowel(str[i]);
    }

    int left = 0, right = str.length() - 1;
    while (left < right) {
        if (str[left] != str[right])
            return false;
        left++;
        right--;
    }
    return true;
}

int main() {
    string str;
    cout << "Enter string: ";
    cin >> str;

    if (encryptedPalindrome(str))
        cout << "true";
    else
        cout << "false";

    return 0;
}
