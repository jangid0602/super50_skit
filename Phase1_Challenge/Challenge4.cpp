#include <bits/stdc++.h>
using namespace std;
bool isMirror(char a, char b) {
    if (a == 'b' && b == 'd') return true;
    if (a == 'd' && b == 'b') return true;
    if (a == 'p' && b == 'q') return true;
    if (a == 'q' && b == 'p') return true;
    if (a == b && (a == 's' || a == 'x' || a == 'z' || a == 'o'))
        return true;

    return false;
}
bool isMirrorWord(string &s, int l, int r) {
    // base case
    if (l >= r)
        return true;
    if (!isMirror(s[l], s[r]))
        return false;
    return isMirrorWord(s, l + 1, r - 1);
}

int main() {
    string s;
    cin >> s;

    if (isMirrorWord(s, 0, s.length() - 1))
        cout << "true";
    else
        cout << "false";

    return 0;
}
