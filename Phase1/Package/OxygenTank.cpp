#include<bits/stdc++.h>
using namespace std;
string Scrubber(string s)
{
    string res="";
    int i=0;
     while(i+1<=s.length())
     {
        if((s[i]>='a' && s[i]<='z') && (s[i+1]>='A' && s[i+1]<='Z') || (s[i+1]>='a' && s[i+1]<='z') && (s[i]>='A' && s[i]<='Z'))
        {
            i+=2;
        }
        else
        {
            res+=s[i];
            i++;
        }

     }
     return res;
}
int main()
{
    string s="ABbcC";
    cout<<Scrubber(s);
    return 0;
}