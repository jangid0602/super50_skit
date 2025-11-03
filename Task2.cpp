/*
 * @filename - Task2.cpp
 * @description - This program performs Shifting Cipher operation.
 * @author - Aditi Agrawal
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cout << "Enter the string on which you want to perform shifting cipher: ";
    getline(cin, s);

    int k;
    cout << "Enter value by which you want to shift: ";
    cin >> k;

    // To handle large k values we calculate modulus (cyclic)
    k = k % 26;

    for (int i = 0; i < s.size(); i++) {
        char ch = s[i];

        if (ch >= 'A' && ch <= 'Z') {  
            s[i] = 'A' + (ch - 'A' + k) % 26;
        } 
        else if (ch >= 'a' && ch <= 'z') {
            s[i] = 'a' + (ch - 'a' + k) % 26;
        }
    }

    cout << "The string after shifting cipher operation will be: " << s << endl;
    return 0;
}
