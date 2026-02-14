/**
 * @filename - Task4.cpp
 * @description - The Word Mirror (Recursive Approach)
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <string>
using namespace std;

// Recursive function to check mirror word
bool isMirrorWord(const string &word, int start, int end)
{
    // Base Case
    if (start >= end)
    {
        return true;
    }

    // If characters do not match
    if (word[start] != word[end])
    {
        return false;
    }

    // Recursive Call
    return isMirrorWord(word, start + 1, end - 1);
}

int main()
{
    string word;

    cout << "Enter a word: ";
    cin >> word;

    if (isMirrorWord(word, 0, word.length() - 1))
    {
        cout << "The word is a mirror word." << endl;
    }
    else
    {
        cout << "The word is not a mirror word." << endl;
    }

    return 0;
}
