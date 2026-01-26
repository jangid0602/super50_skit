#include<bits/stdc++.h>
using namespace std;
bool check(string s,int i,int j,unordered_map<char,char> &mpp){
    if(i>j) return true;
    if(mpp.find(s[i])==mpp.end()) return false;
    if(mpp[s[i]]!=s[j]) return false; 
    return check(s,i+1,j-1,mpp);
}
int main(){
    string s;
    cout<<"enter string"<<endl;
    cin>>s;
    unordered_map<char,char> mpp;
    mpp['b']='d';
    mpp['p']='q';
    mpp['s']='s';
    mpp['x']='x';
    mpp['z']='z';
    mpp['o']='o';
    mpp['d']='b';
    mpp['q']='p';
    bool result=check(s,0,s.size()-1,mpp);
    if(result) cout<<"True";
    else cout<<"False";
    return 0;
}