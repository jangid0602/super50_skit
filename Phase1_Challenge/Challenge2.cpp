#include<iostream>
#include <bits/stdc++.h>
using namespace std;

vector<string> findMissingPages(vector<int>& pages, int N) {
    unordered_set<int> st;
    for (int p : pages)
        st.insert(p);

    vector<string> ans;

    for (int i = 1; i <= N; i++) {
        // agar page missing hai
        if (st.find(i) == st.end()) {
            int start = i;

            // missing pages
            while (i <= N && st.find(i) == st.end()) {
                i++;
            }

            int end = i - 1;

            if (start == end)
                ans.push_back(to_string(start));
            else
                ans.push_back(to_string(start) + "-" + to_string(end));
        }
    }
    return ans;
}

int main() {
    int m;
    cin >> m;   // number of page

    vector<int> pages(m);
    for (int i = 0; i < m; i++) {
        cin >> pages[i];
    }

    int N;
    cin >> N;   // total pages in book

    vector<string> result = findMissingPages(pages, N);

    // Output
    for (string s : result) {
        cout << s << " ";
    }

    return 0;
}
