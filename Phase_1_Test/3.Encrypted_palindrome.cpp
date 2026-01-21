#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool isPalindrome(string s)
{
    int n = s.size();
    int l = 0;
    int r = n - 1;
    while(l < r)
    {
        if(s[l] != s[r]) return false;
        l++;
        r--;
    }
    return true;
}

bool Encrypted_Palindrome(string s)
{
    int n = s.size();
    for(int i = 0; i < n; i++)
    {
        if(s[i]=='a')
            s[i]='e';
        else if(s[i]=='e')
            s[i]='i';
        else if(s[i]=='i')
            s[i]='o';
        else if(s[i]=='o')
            s[i]='u';
        else if(s[i]=='u')
            s[i]='a';
    }
    return isPalindrome(s);
}

int main()
{
    bool flag = Encrypted_Palindrome("ebba");
    if(flag == true)
        cout << "String is a Palindrome" << endl;
    else
        cout << "String is Not a Palindrome" << endl;

    bool flag2 = Encrypted_Palindrome("ace");
    if(flag2 == true)
        cout << "String is a Palindrome" << endl;
    else
        cout << "String is Not a Palindrome" << endl;

    bool flag3 = Encrypted_Palindrome("vutuv");
    if(flag3 == true)
        cout << "String is a Palindrome" << endl;
    else
        cout << "String is Not a Palindrome" << endl;
}
