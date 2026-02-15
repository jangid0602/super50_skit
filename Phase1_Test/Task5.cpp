// Oxygen Tank Scrubber
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    string removePairs(string s)
    {
        stack<char> st;
        for (char c : s)
        {
            if (!st.empty()&&abs(st.top() - c) == 32)
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }
        }
        string result = "";
        while (!st.empty())
        {
            result += st.top();
            st.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};
int main()
{
    string s;
    cout << "Enter string:";
    cin >> s;
    Solution obj;
    string result = obj.removePairs(s);
    cout << result << endl;
    return 0;
}