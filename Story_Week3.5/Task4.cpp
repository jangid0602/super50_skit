/* @file: Task3.cpp
@Description: The Spy's Cipher
@Author: Ayushi Shukla */
#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;
char findExtraCharacter(const string &original, const string &scrambled)
{
    unordered_map<char, int> frequency;
    for (char character : scrambled)
    {
        frequency[character]++;
    }
    for (char character : original)
    {
        frequency[character]--;
    }
    for (const auto &pair : frequency)
    {
        if (pair.second > 0)
        {
            return pair.first;
        }
    }
    return '\0'; // Return null character if no extra character is found
}
int main()
{
    string original, scrambled;
    cout << "Enter original string: ";
    cin >> original;
    cout << "Enter scrambled string: ";
    cin >> scrambled;
    char extraCharacter = findExtraCharacter(original, scrambled);
    cout << "The extra character is: ";
    if (extraCharacter != '\0')
    {
        cout << extraCharacter;
    }
    else
    {
        cout << "No extra character found";
    }
}
