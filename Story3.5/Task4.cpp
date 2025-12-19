/**
 * @filename - Task-4.cpp
 * @description - The Spy’s Cipher
 * @author - Avani Shrimali
 */

#include <iostream>
#include <string>
using namespace std;

char findExtraCharacter(string original, string scrambled) {
    int frequency[256] = {0};

    for (char c : scrambled) frequency[c]++;
    for (char c : original) frequency[c]--;

    for (int index = 0; index < 256; index++) {
        if (frequency[index] > 0) return char(index);
    }

    return '\0';
}

int main() {
    string original, scrambled;
    cin >> original >> scrambled;

    cout << findExtraCharacter(original, scrambled) << endl;
    return 0;
}

