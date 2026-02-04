#include <bits/stdc++.h>
using namespace std;

int main() {
	cout<<"enter no of test cases\n";
    int t;
    cin>>t;
    while(t--){
        string s;
        cout<<"enter the string\n";
        cin>>s;
        int n=s.size();
        stack<char> stk;
        stk.push(s[0]);
        for(int i=1;i<n;i++){
            if(stk.empty()){
                stk.push(s[i]);
                continue;
            }
            if(isupper(s[i])){
                if(stk.top()==tolower(s[i])){
                    stk.pop();
                }
                // else if()
                else{
                    stk.push(s[i]);
                }
            }else{
                if(stk.top()==toupper(s[i])){
                    stk.pop();
                }else{
                    stk.push(s[i]);
                }
            }
        }
        if(stk.empty()){
            cout<<"empty string";
            continue;
        }
        string ans;
        while(!stk.empty()){
            ans.push_back(stk.top());
            stk.pop();
        }
        reverse(ans.begin(),ans.end());
        cout<<ans<<"\n";
        
    }
}
