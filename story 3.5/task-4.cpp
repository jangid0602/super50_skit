/**
 * @filename - Task-4.cpp
 * @description -  The Spy’s Cipher 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

int main() {
    string originalString, scrambledString;

    cout << "Enter original string: ";
    cin >> originalString;

    cout << "Enter scrambled string: ";
    cin >> scrambledString;

    unordered_map<char, int> characterFrequency;

    // Count frequency of original string
    for (char currentChar : originalString) {
        characterFrequency[currentChar]++;
    }

    // Find extra character
    for (char currentChar : scrambledString) {
        characterFrequency[currentChar]--;
        if (characterFrequency[currentChar] < 0) {
            cout << currentChar;
            break;
        }
    }

    return 0;
}
