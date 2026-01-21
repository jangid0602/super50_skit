#include<bits/stdc++.h>
using namespace std;
bool solve(string s,string t,int start,int end){
    if(start>end) return false;
    if(start==end) return true;
    if(s[start]==t[end]) return solve(s,t,start+1,end-1);
    return false;
}
bool checkMirror(string s){
    string t=s;
    reverse(t.begin(),t.end());
    int n=s.size();
    return solve(s,t,0,n-1);
}

int main(){
    cout<<"Enter your string to check:";
    string s;
    cin>>s;

    cout<<"Is the string mirror?: "<<checkMirror(s);
}