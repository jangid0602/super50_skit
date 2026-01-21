#include <iostream>
using namespace std;

bool isMirrorPair(char a, char b) {
    if ((a == 'b' && b == 'd') || (a == 'd' && b == 'b')) return true;
    if ((a == 'p' && b == 'q') || (a == 'q' && b == 'p')) return true;
    if (a == b && (a == 's' || a == 'x' || a == 'z' || a == 'o')) return true;
    return false;
}

//bool ismw(string s){
//	int l = 0;
//	int r = s.length()-1;
//	while(l<r){
//		if (!isMirrorPair(s[l], s[r]))
//        	return false;
//        l++;
//        r--;
//	}
//	return true;
//}
bool isMirrorWord(string s, int left, int right) {
    if (left >= right)
        return true;

    if (!isMirrorPair(s[left], s[right]))
        return false;

    return isMirrorWord(s, left + 1, right - 1);
}

int main() {
    string word = "bpoqd";
    cout << isMirrorWord(word, 0, word.length() - 1);
    //cout<< ismw(word);
    return 0;
}

