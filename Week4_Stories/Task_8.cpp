/**
 * @filename - Task-8.cpp
 * @description - String Building
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

string compressString(string s, int index)
{
    if (index >= s.length())
        return "";

    char current = s[index];
    int count = 1;

    int i = index + 1;
    while (i < s.length() && s[i] == current)
    {
        count++;
        i++;
    }

    return to_string(count) + current + compressString(s, i);
}

int main()
{
    string s;
    cin >> s;

    cout << compressString(s, 0);
    return 0;
}
