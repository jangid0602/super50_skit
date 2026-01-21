/*3. Encrypted Palindrome*/

#include <iostream>
using namespace std;

char encryptVowel(char c){
    if (c == 'a') return 'e';
    if (c == 'e') return 'i';
    if (c == 'i') return 'o';
    if (c == 'o') return 'u';
    if (c == 'u') return 'a';
    return c;
}

void encryptSentence(string & s){
    for (int i = 0 ; i < s.length() ; i++) {
        s[i] = encryptVowel(s[i]);
    }
}
bool isPalindrome(string & s){
	encryptSentence(s);
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s[l] != s[r])
            return 0;
        l++;
        r--;
    }
    return 1;
}

int main(){
    string s = "vutav";
    cout << isPalindrome(s);
    return 0;
}

