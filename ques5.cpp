#include<bits/stdc++.h>
#include<iostream>
using namespace std;

string solve(string s){
    if(s.size() == 1) return s;
    stack<char>st;
    st.push(s[0]);
    for(int i = 1 ; i < s.size() ; i++){
       if(tolower(s[i]) == st.top() ) st.pop();
       st.push(s[i]);
    }
    string ans;
    while(!st.empty()){
        ans+=st.top();
        st.pop()
    }
    reverse(ans.begin(),ans.end());
    return ans;
}