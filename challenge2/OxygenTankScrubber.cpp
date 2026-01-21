#include <iostream>
#include <stack>
#include <bits/stdc++.h>
using namespace std;

class OxygenTankScrubberSolver
{
public:
    string CharRemoval(string s)
    {
        stack<char> st;

        for (char c : s)
        {
            if (!st.empty())
            {
                char top = st.top();

                if (top != c && tolower(top) == tolower(c))
                {
                    st.pop();
                }
                else
                {
                    st.push(c);
                }
            }
            else
            {
                st.push(c);
            }
        }

        string result = "";
        while (!st.empty())
        {
            result = st.top() + result;
            st.pop();
        }

        return result;
    }
};

int main()
{
    OxygenTankScrubberSolver solver;

    cout << "Test case-1: " << solver.CharRemoval("aAbBcC") << "\n";
    cout << "Test case-2: " << solver.CharRemoval("ABbC") << "\n";

    cout << "Test case-3: " << solver.CharRemoval("sSttaA") << "\n";

    return 0;
}
