#include <bits/stdc++.h>
using namespace std;
bool fuc(string s){
    unordered_map<char,char> ud;
    ud['b']='d';
    ud['d']='b';
    ud['p']='q';
    ud['q']='p';
    ud['s']='s';
    ud['x']='x';
    ud['z']='z';
    ud['o']='o';
    int n=s.size();
    for(int i=n-1;i>=0;i--){
        if(ud[s[i]]==s[n-1-i]){
            continue;
        }else{
            return false;
        }
    }
    return true;

}

int main() {
	cout<<"enter no of test cases\n";
    int t;
    cin>>t;
    while(t--){
        cout<<"enter the string\n";
        string s;
        cin>>s;
        if(fuc(s))
            cout<<"True"<<"\n";
        else{
            cout<<"False\n";
        }
    }

}
