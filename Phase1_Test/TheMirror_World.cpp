#include<bits/stdc++.h>
using namespace std;

string solve(string input)
{
    string answer = "";
    for (char x : input)
    {
        if (x == 'b')
        {
            answer = answer + 'd';
            continue;
        }
        if (x == 'p')
        {
            answer = answer + 'q';
            continue;
        }
        
        answer = answer + x;
    }
    int length = answer.length();
    for (int i = 0, j = length - 1; i < (length / 2) + 1, j >= i; i++, j--)
    {
        if (answer[i] != answer[j])
            return "false";
    }
    return "true";
}
int main()
{
    string input = "abc";
    cout << solve(input);
}