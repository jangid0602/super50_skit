#include<bits/stdc++.h>
using namespace std;



bool check(string s){
    int n=s.size();
    int i=0,j=n-1;
    while(i<j){
        if(s[i]!=s[j]) return false;
        i++;
        j--;
    }
    return true;
}

int main(){
    cout<<"enter string";
    string str;
    cin>>str;
    map<char,char>mp;
    mp['a']='e';
    mp['e']='i';
    mp['i']='o';
    mp['o']='u';
    mp['u']='a';

    string s="";
    int n=str.size();
    for(int i=0;i<n;i++){
        if(mp.find(str[i])!=mp.end()){
            s.push_back(mp[str[i]]);
            
        }
        else{
            s.push_back(str[i]);
        }
    }
   
    if(check(s)) cout<<"true";
    else cout<<"false";
}