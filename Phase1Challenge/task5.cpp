/**
 * @filename - task5.cpp
 * @description -Oxygen Tank Scrubber
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;
string helper(string input)
{
    string ans = "";
    stack<char> checker;
    for (int i = 0; i < input.size(); i++)
    {
        if (checker.empty() || !((tolower(checker.top()) == tolower(input[i])) && (checker.top() != input[i])))
        {
            checker.push(input[i]);
        }
        else
        {
            checker.pop();
        }
    }
    while (!checker.empty())
    {
        ans = checker.top() + ans;
        checker.pop();
    }
    return ans;
}
int main()
{
    cout << "Enter input string: ";
    string input;
    cin >> input;
    cout << helper(input) << endl;
    return 0;
}