#include<bits/stdc++.h>
using namespace std;

int main(){
    string s;
    cout<<"Enter the string:";
    cin>>s;
    string ans="";
    int k=s.size();
    int i=1;
    while(i<k){
        if(s[i-1]-s[i]==32){
            i+=2;
        }
        else{
            ans+=s[i-1];
            i++;
        }
    }

    cout<<ans<<endl;
}