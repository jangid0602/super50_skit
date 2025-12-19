/**
 * @filename   : Story7.cpp
 * @description: Interweave two C-style strings into a newly allocated string.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

char* interweaveStrings(const char* first, const char* second) {

    int lenFirst = strlen(first);
    int lenSecond = strlen(second);

   
    char* merged = (char*)malloc(lenFirst + lenSecond + 1);

    int i = 0, j = 0, pos = 0;

    
    while(i < lenFirst && j < lenSecond) {
        merged[pos++] = first[i++];
        merged[pos++] = second[j++];
    }

    
    while(i < lenFirst) {
        merged[pos++] = first[i++];
    }

    
    while(j < lenSecond) {
        merged[pos++] = second[j++];
    }

    merged[pos] = '\0';  
    return merged;
}

int main() {

    char str1[100];
    char str2[100];

    cout << "Enter first string ";
    cin >> str1;

    cout << "Enter second string ";
    cin >> str2;

    char* result = interweaveStrings(str1, str2);
    cout << "Interwoven string: " <<result<< endl;

    free(result);   
    return 0;
}
