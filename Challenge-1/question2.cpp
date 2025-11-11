#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string shiftingCipher(string str, int index) {
        string result = "";

        for (char c : str) {
            if (isalpha(c)) { 
                char character = islower(c) ? 'a' : 'A';//for handling both uppercase and lowercase
                char shiftedChar = (c - character + index) % 26 + character;//shifting logic
                result += shiftedChar;
            } else {
             
                result += c;
            }
        }

        return result;
    }
};

int main() {
    string str;
    cout << "Enter the string : ";
    getline(cin, str); 

    int index;
    cout << "Enter the index by which string has to be shifted : ";
    cin >> index;

    Solution object;
    string answer = object.shiftingCipher(str, index);
    cout << "The shifted string is : " << answer << endl;

    return 0;
}
