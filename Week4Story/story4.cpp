/**
 * @filename - Story4.cpp
 * @description -  Word Mirror
 * @author - Fatimi Bee
 */

#include <iostream>
#include <string>

using namespace std;

bool compare(string word, int start, int end)
{
    if (start >= end)
    {
        return true;
    }

    if (word[start] != word[end])
    {
        return false;
    }
    compare(word, start + 1, end - 1);
}

int main()
{
    string word;
    cout << "Enter a word: ";
    getline(cin, word);

    bool isMirror = compare(word, 0, word.length() - 1);

    cout << "Is the word a mirror ?" << (isMirror ? "True" : "False") << endl;
}