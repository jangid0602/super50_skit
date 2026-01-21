#include <bits/stdc++.h>
using namespace std;
class Solution5
{
    public:
    string crushedString(string s){
         int i=0;
         string ans="";
         while(i<s.length()-1){
            if(((s[i]>='a'&&s[i]<'z')&&(abs(s[i+1]-s[i])==32))
            ||(s[i]>='A'&&s[i]<='Z')&&(abs(s[i+1]-s[i]==32))){
              i+=2;
            }
            else{
                ans+=s[i];
                i++;
            }
         }
         return ans;
    }
};
    int main(){
        Solution5 obj=Solution5();
        string s;
        cout <<"enter string:";
        cin >>s;
        cout <<"the crushed string is:"<<obj.crushedString(s);
    }
