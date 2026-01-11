/**
 * @filename - Task4.cpp
 * @description -  The Word Mirror (Recursion)
 * @author - Disha Toshniwal 
 */
#include <iostream>
using namespace std;

void checkPalindrome(string text) {
    int start = 0;
    int end = text.length() - 1;
    while (start < end) {
        if (text[start] == text[end]) {
            start++;
            end--;
        } else {
            cout << "False";
            return;
        }
    }
    cout << "True";
}

int main() {
    string input;
    cout << "Enter string: ";
    cin >> input;
    checkPalindrome(input);
    return 0;
}
