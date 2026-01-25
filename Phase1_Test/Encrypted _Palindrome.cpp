#include<bits/stdc++.h>
using namespace std;
string solve(string input)
{
    string answer = "";
    for(char x:input)
    {
        if(x=='a')
        {
            answer = answer + 'e';
            continue;
        }
        if (x == 'e')
        {
            answer = answer + 'i';
            continue;
        }
        if (x == 'i')
        {
            answer = answer + 'o';
            continue;
        }
        if (x == 'o')
        {
            answer = answer + 'u';
            continue;
        }
        if (x == 'u')
        {
            answer = answer + 'a';
            continue;
        }
        answer = answer + x;
    }
    int length = answer.length();
    for (int i = 0, j = length-1; i<(length / 2) + 1, j>= i;i++,j--)
    {
        if(answer[i]!=answer[j])
            return "false";
    }
    return "true";
}
int main(){
    string input = "ace";
    cout << solve(input);
}