/**
 * @filename - Task-4.cpp
 * @description - The Word Mirror
 * @author - Diya Garg
 */

#include <iostream>
using namespace std;

bool isPalindrome(string s, int start, int end)
{
    if (start >= end)
    {
        return true;
    }
    if (s[start] != s[end])
    {
        return false;
    }

    isPalindrome(s, start + 1, end - 1);
}

int main()
{
    string s;
    cout << "enter a string :";
    cin >> s;

    if (isPalindrome(s, 0, s.size() - 1))
    {
        cout << "True";
    }
    else
        cout << "False";

    return 0;
}