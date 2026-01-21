#include <bits/stdc++.h>
using namespace std;

// Function to check if two characters are mirror of each other
bool isMirrorPair(char a, char b) {
    if ((a == 'b' && b == 'd')||(a == 'd' && b == 'b')) return true;
    if ((a == 'p' && b == 'q')||(a == 'q' && b == 'p')) return true;
    if ((a == 's' && b == 's')) return true;
    if ((a == 'x' && b == 'x')) return true;
    if ((a == 'z' && b == 'z')) return true;
    if ((a == 'o' && b == 'o')) return true;
    return false;
}
bool isMirrorWord(string s, int left, int right) {
    if (left > right) return true; 
    if (!isMirrorPair(s[left], s[right])) return false;
    return isMirrorWord(s, left + 1, right - 1);
}

int main() {
    string s1 = "bod";
    string s2 = "pq";
    string s3 = "abc";
    if((isMirrorWord(s1, 0, s1.size() - 1)))
    cout<<"true";
    else
    cout<<"false";
    if((isMirrorWord(s2, 0, s2.size() - 1)))
    cout<<"true";
    else
    cout<<"false";
    if((isMirrorWord(s3, 0, s3.size() - 1)))
    cout<<"true";
    else
    cout<<"False";
}
