//  The Mirror Word Via Recursion 
 
#include<iostream>
#include<string>
using namespace std;
class MirrorWordChecker {
public:
    bool isMirror(const string& str, int left, int right) {
        if (left >= right) {
            return true;
        }
        char leftChar = str[left];
        char rightChar = str[right];
        if (!isMirrorPair(leftChar, rightChar)) {
            return false;
        }
        return isMirror(str, left + 1, right - 1);
    }

    bool isMirrorPair(char a, char b) {
        switch (a) {
            case 'b': return b == 'd';
            case 'd': return b == 'b';
            case 'p': return b == 'q';
            case 'q': return b == 'p';
            case 's': return b == 's';
            case 'x': return b == 'x';
            case 'z': return b == 'z';
            case 'o': return b == 'o';
            default: return false;
        }
    }

    bool isMirrorWord(const string& str) {
        return isMirror(str, 0, str.length() - 1);
    }
};
int main() {
    string input;
    cout << "Enter a word to check if it's a mirror word: ";
    cin >> input;
    MirrorWordChecker checker;
    if (checker.isMirrorWord(input)) {
        cout << input << " is a mirror word." << endl;
    } else {
        cout << input << " is not a mirror word." << endl;
    }
    return 0;
}