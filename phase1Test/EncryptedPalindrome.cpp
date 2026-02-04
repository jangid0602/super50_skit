#include <bits/stdc++.h>
using namespace std;

int main() {
	cout<<"enter no of test cases\n";
    int t;
    cin>>t;
    while(t--){
        string s;
        cout<<"enter the string onlu in lower case\n";
        cin>>s;
        for(int i=0;i<s.size();i++){
            char it=s[i];
            if(it=='a'){
                s[i]='e';
            }else if(it=='e'){
                s[i]='i';
            }else if(it=='i'){
                s[i]='o';
            }
            else if(it=='o'){
                s[i]='u';
            }
            else if(it=='u'){
                s[i]='a';
            }
        }
        int n=s.size();
        int flag=0;
        for(int i=0;i<n/2;i++){
            if(s[i]==s[n-1-i]){
                continue;
            }else{
                cout<<"false\n";
                flag=1;
                break;
            }
        }
        if(flag==0)
        cout<<"True\n";
    }

}
