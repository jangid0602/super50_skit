/**
 * @filename   : story6.cpp
 * @description: Non-overlapping String Replacement
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <string>
using namespace std;

string replaceWords(string text, string from, string to) {
    string result = "";
    int i = 0;

    while (i < text.size()) {
        if (text.substr(i, from.size()) == from) {
            result += to;
            i += from.size();
        } else {
            result += text[i];
            i++;
        }
    }

    return result;
}

int main() {
    string text, a, b;
    cout << "Enter text: ";
    cin >> text;
    cout << "Find: ";
    cin >> a;
    cout << "Replace with: ";
    cin >> b;

    cout << "Modified: " << replaceWords(text, a, b) << endl;
    return 0;
}
