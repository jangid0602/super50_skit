#include <iostream>
#include <bits/stdc++.h>
using namespace std;
string solve(string input)
{
    string answer;
    for (char c : input)
    {
        if (!answer.empty() && tolower(answer.back()) == tolower(c) && answer.back() != c)
            answer.pop_back();
        else
            answer.push_back(c);
    }
    return answer;
}
int main()
{
    string input = "ABbC";
    cout << solve(input);
}