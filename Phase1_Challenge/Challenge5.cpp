#include<iostream>
#include <bits/stdc++.h>
using namespace std;

string oxygenTankScrubber(string s) {
    stack<char> st;

    for (char c : s) {
        if (!st.empty() && abs(st.top() - c) == 32) {
            st.pop();   
        } else {
            st.push(c);
        }
    }

    // build final string from stack
    string ans;
    while (!st.empty()) {
        ans.push_back(st.top());
        st.pop();
    }

    reverse(ans.begin(), ans.end());
    return ans;
}

int main() {
    string s;
     getline(cin, s);   // general input string

    cout << oxygenTankScrubber(s);
    return 0;
}
