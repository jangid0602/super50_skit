// @filename-Task6.cpp
// @Description: Replaces all non-overlapping occurrences of a substring in text with a replacement string.
// @Author: Ayushi Shukla

#include <iostream>
#include <string>
using namespace std;

class TextEditorReplacer
{
public:
    string replaceNonOverlapping(string text, const string &findStr, const string &replaceStr)
    {
        string result = "";
        size_t i = 0;
        size_t n = text.length();
        size_t m = findStr.length();

        while (i < n)
        {
            if (i + m <= n && text.substr(i, m) == findStr)
            {
                result += replaceStr;
                i += m; // move past the replaced substring (non-overlapping)
            }
            else
            {
                result += text[i];
                i++;
            }
        }

        return result;
    }
};

int main()
{
    string text, findStr, replaceStr;

    cout << "Enter text: ";
    getline(cin, text);

    cout << "Enter string to find: ";
    getline(cin, findStr);

    cout << "Enter string to replace with: ";
    getline(cin, replaceStr);

    TextEditorReplacer replacer;
    string output = replacer.replaceNonOverlapping(text, findStr, replaceStr);

    cout << "Result after replacement: " << output << endl;

    return 0;
}
