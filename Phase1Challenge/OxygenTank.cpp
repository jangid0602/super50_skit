#include<bits/stdc++.h>
using namespace std;

string solve(string str){
    string s="";
    int n=str.size();
    int i=0;
    int flag=0;
    while(i<n-1){
        if(str[i]>='A' && str[i]<='Z'){
            if(str[i+1]>='a' && str[i+1]<='z'){
                i+=2;
                if(i==n-1) flag=1;
            }
            else{
                s.push_back(str[i]);
                i++;
            } 
        }
        else{
            if(str[i+1]>='A' && str[i+1]<='Z'){
                i+=2;
                if(i==n-1) flag=1;
            }
            else{
                s.push_back(str[i]);
                i++;
            } 
        }
    }
    if(flag) s.push_back(str[n-1]);
    return s;
}

int main(){
    cout<<"Enter string";
    string str;
    cin>>str;
    string s=solve(str);
    if(s=="") cout<<"empty";
    else cout<<s;
}