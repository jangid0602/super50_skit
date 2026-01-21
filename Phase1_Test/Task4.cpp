// The Mirror Word Via Recursion
#include <iostream>
using namespace std;
class Solution
{
public:
    bool isMirrorString(string s)
    {
        string mirror = "";
        // Mirror pairs: (b,d), (p,q), (s,s), (x,x), (z,z), (o,o).
        for (char c : s)
        {
            switch (c)
            {
            case 'b':
                mirror = 'd' + mirror;
                break;
            case 'd':
                mirror = 'b' + mirror;
                break;
            case 'p':
                mirror = 'q' + mirror;
                break;
            case 'q':
                mirror = 'p' + mirror;
                break;
            case 's':
                mirror = 's' + mirror;
                break;
            case 'x':
                mirror = 'x' + mirror;
                break;
            case 'z':
                mirror = 'z' + mirror;
                break;
            case 'o':
                mirror = 'o' + mirror;
                break;
            default:
                return false;
            }
        }

        return mirror == s;
    }
};
int main()
{
    string s;
    cout << "Entestring :";
    cin >> s;
    Solution obj;
    bool result = obj.isMirrorString(s);
    if (result)
    {
        cout << "mirrored string" << endl;
    }
    else
    {
        cout << "not a mirrored string" << endl;
    }
}
