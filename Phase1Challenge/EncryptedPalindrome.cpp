#include<bits/stdc++.h>
using namespace std;
bool checkEncryptedPalindrome(string &s){
    string encrypted="";
    unordered_map<char,char> mpp;
    mpp['a']='e';
    mpp['e']='i';
    mpp['i']='o';
    mpp['o']='u';
    mpp['u']='a';
    for(int i=0;i<s.size();i++){
        if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u') encrypted+=mpp[s[i]];
        else encrypted+=s[i];

    }
    int start=0,end=encrypted.size()-1;
    while(start<end){
        if(encrypted[start]!=encrypted[end]) return false;
        start++;
        end--;
    }
    return true;
}
int main(){
    string s;
    cout<<"Enter string"<<endl;
    cin>>s;
    bool result=checkEncryptedPalindrome(s);
    if(result) cout<<"True";
    else cout<<"False";
    return 0;
}