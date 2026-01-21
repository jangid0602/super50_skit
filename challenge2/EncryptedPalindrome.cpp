#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class EncryptedPalindromeSolver
{
private:
    map<char, char> vowelMap = {
        {'a', 'e'},
        {'e', 'i'},
        {'i', 'o'},
        {'o', 'u'},
        {'u', 'a'}};

    bool isPalindrome(const string &s)
    {
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            if (s[left] != s[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

public:
    bool isEncryptedPalindrome(string s)
    {
        string transformed = "";
        for (char c : s)
        {
            if (vowelMap.find(c) != vowelMap.end())
            {
                transformed += vowelMap[c];
            }
            else
            {
                transformed += c;
            }
        }

        return isPalindrome(transformed);
    }
};

int main()
{
    EncryptedPalindromeSolver solver;

    cout << boolalpha;
    cout << solver.isEncryptedPalindrome("ebba") << "\n";
    cout << solver.isEncryptedPalindrome("ace") << "\n";
    cout << solver.isEncryptedPalindrome("vutuv") << "\n";

    return 0;
}
