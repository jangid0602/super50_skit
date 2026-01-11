/**
 * @filename - Task8.cpp
 * @description - The String Tiling Challenge (Recursion)
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <string>
using namespace std;

string compressString(string text) {
    if (text.size() == 0) return "";

    char currentChar = text[0];
    int count = 1;
    int index = 1;

    while (index < text.size() && text[index] == currentChar) {
        count++;
        index++;
    }

    return to_string(count) + currentChar + compressString(text.substr(index));
}

int main() {
    string input;
    cout << "Enter a string: ";
    cin >> input;
    cout << compressString(input) << endl;
    return 0;
}
