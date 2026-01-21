#include<bits/stdc++.h>
using namespace std;
string oxygenTank(string s){
    string ans="";
    for(int i=0;i<s.size();i++){
        if(i==s.size()-1){
             ans+=s[s.size()-1];
             break;
        }
        if((s[i]>='a' && s[i]<='z') && (s[i+1]>='A' && s[i+1]<='Z')) i++;
        else if((s[i]>='A' && s[i]<='Z') && (s[i+1]>='a' && s[i+1]<='z')) i++;
        else ans+=s[i];
    }
    return ans;
}
int main(){
    string s="AaBbCcD";
    cout<<"Output:"<<oxygenTank(s);
    return 0;
}