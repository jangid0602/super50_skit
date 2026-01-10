/**
 * @filename   : TheWordMirror.cpp
 * @description: Check whether a word is a palindrome using recursion.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

bool checkPalindrome(int left, int right, const string &word)
{
    if (left >= right)
        return true;

    if (word[left] != word[right])
        return false;

    return checkPalindrome(left + 1, right - 1, word);
}

int main()
{
    string word = "racecar";

    cout << (checkPalindrome(0, word.size() - 1, word) ? "True" : "False");
    return 0;
}
