/**
 * @filename   : SpysCipher.cpp
 * @description: Identify the extra character added to a scrambled string using frequency counting.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

/*
Problem summary:
- Given two strings:
    1) original
    2) scrambled (original + exactly one extra character, order changed)
- Return the extra character.
*/

char findExtraCharacter( string& original,  string& scrambled) {


    for(int i=0;i<scrambled.size();i++){
        bool found=false;
        for(int j=0;j<original.size();j++){
            if(scrambled[i]==original[j]) {
                found=true;
            }
        }
        if(!found) return scrambled[i];
    }
    

    return '\0';
}

int main() {
    string original, scrambled;
    cin >> original >> scrambled;

    char extraChar = findExtraCharacter(original, scrambled);
    cout << extraChar << endl;

    return 0;
}
