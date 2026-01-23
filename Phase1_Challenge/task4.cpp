#include <iostream>
using namespace std;

bool isMirrorPair(char a, char b) {
    if ((a == 'b' && b == 'd') || (a == 'd' && b == 'b'))
        return true;
    if ((a == 'p' && b == 'q') || (a == 'q' && b == 'p'))
        return true;
    if (a == b && (a == 's' || a == 'x' || a == 'z' || a == 'o'))
        return true;
    return false;
}

bool isMirror(string s, int l, int r) {
    if (l >= r)
        return true;

    if (!isMirrorPair(s[l], s[r]))
        return false;

    return isMirror(s, l + 1, r - 1);
}

int main() {
    string s;
    cout<<"enter the string s:";
    cin >> s;

    if (isMirror(s, 0, s.length() - 1))
        cout << "true";
    else
        cout << "false";
    return 0;
}
