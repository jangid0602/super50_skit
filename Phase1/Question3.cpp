#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution{
    public :
   

    bool encryptedPalindrome(string &word)
    {
        for(int i=0;i< word.size();i++)
        {
            if(word[i]=='a')
            { word[i]='e';}
            else if(word[i]=='e')
            { word[i]='i';}
            else if(word[i]=='i')
            { word[i]='o';}
            else if(word[i]=='o')
            { word[i]='u';}
            else if(word[i]=='u')
            { word[i]='a';}              
        }
        cout<<word<<endl;
        int i=0;
        int j=word.size()-1;
        while(i<j)
        {
            if(word[i]==word[j])
            {
                i++;
                j--;
            }
            else
            return false;
        }
        return true;
    }

};

int main()
{
    Solution solution;
    
    string input;
    cout<<"Enter the input string:";
    cin>>input;
    
    cout<<input<<endl;
    cout<<"The string is Palindrome:";
    int ans=solution.encryptedPalindrome(input);
    if(ans)
    cout<<"True";
    else
    cout<<"false";
    return 0;
}