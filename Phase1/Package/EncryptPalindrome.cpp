#include<bits/stdc++.h>
using namespace std;
string transfome(string s)
{
    string res="";
    for(int i=0 ; i<s.length(); i++)
    {
         if(s[i]=='a')
         {
            res+='e';
         }
         if(s[i]=='e')
         {
            res+='i';
         }
         if(s[i]=='i')
        {
           res+='o';
        }
        if(s[i]=='o')
        {
            res+='u';
        }
        if(s[i]=='u')
        {
            res+='a';
        }
        else
        {
            res+=s[i];
        }
    }
    return res;

}
bool isPalindrome(string s)
{
   int left = 0;
   int right = s.length() - 1;
   string transformed = transfome(s);
   while (left < right)
   {
      if (transformed[left] != transformed[right])
      {
         return false;
      }
      left++;
      right--;
   }
   return true;
}
int main()
{
    string s="ace";
    cout<<isPalindrome(s);
    return 0;
}