#include <bits/stdc++.h>
using namespace std;

string oxygenTankScrubber(string s) {
    stack<char> st;

    for (char ch : s) {
        if (!st.empty() && abs(st.top() - ch) == 32) {
            st.pop();
        } else {
            st.push(ch);
        }
    }
    string result = "";
    while (!st.empty()) {
        result.push_back(st.top());
        st.pop();
    }

    reverse(result.begin(), result.end());
    return result;
}

int main() {
    cout << oxygenTankScrubber("aAbBcC") << endl;
    cout << oxygenTankScrubber("ABbC") << endl;
    cout << oxygenTankScrubber("sSttaA") << endl;
    return 0;
}
