//. Encrypted Palindrome
#include <iostream>
#include <string>
// a→e, e→i, i→o, o->u, u->a;
using namespace std;
class Solution
{
public:
    bool isPalindrome(string s)
    {
        string vowels= "";
        for (char c : s)
        {
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            {
                switch (c)
                {
                case 'a':
                    vowels +='e';
                    break;
                case 'e':
                    vowels +='i';
                    break;
                case 'i':
                    vowels +='o';
                    break;
                case 'o':
                    vowels +='u';
                    break;
                case 'u':
                    vowels += 'a';
                    break;
                }
            }
        }
        int left = 0;
        int right = vowels.size() - 1;
        while (left < right)
        {
            if (vowels[left] != vowels[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
};

int main()
{
    string s;
    cout << "Enter the string: ";
    cin >> s;
    Solution obj;
    bool result = obj.isPalindrome(s);
    if (result)
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }
}