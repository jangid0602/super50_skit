/**
 * @filename - task3.cpp
 * @description - encrypt palindrome
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

char mapVowel(char c)
{
    switch (tolower(c))
    {
    case 'a':
        return 'e';
    case 'e':
        return 'i';
    case 'i':
        return 'o';
    case 'o':
        return 'u';
    case 'u':
        return 'a';
    default:
        return c;
    }
}

bool chkEncryptPalindrom(string input)
{
    string encrypted = "";
    for (char c : input)
    {
        encrypted += mapVowel(c);
    }

    string reversed = encrypted;
    reverse(reversed.begin(), reversed.end());

    return encrypted == reversed;
}

int main()
{
    cout << "Enter string ";
    string input;
    getline(cin, input);
    bool ans = chkEncryptPalindrom(input);
    if (ans == 1)
    {
        cout << "True";
    }
    else
    {
        cout << "False";
    }
}
