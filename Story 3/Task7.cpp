/**
 * @filename - Task-7.cpp
 * @description - The C-String Interweaver
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <cstring>   
#include <cstdlib>   
using namespace std;

char* interweave(char* s1, char* s2) {
    int len1 = strlen(s1);
    int len2 = strlen(s2);

    char* result = (char*)malloc(len1 + len2 + 1);

    int index1 = 0, index2 = 0, writeIndex = 0;

    while (s1[index1] != '\0' && s2[index2] != '\0') {
        result[writeIndex++] = s1[index1++];
        result[writeIndex++] = s2[index2++];
    }

    while (s1[index1] != '\0') {
        result[writeIndex++] = s1[index1++];
    }

    while (s2[index2] != '\0') {
        result[writeIndex++] = s2[index2++];
    }

    result[writeIndex] = '\0';

    return result;
}

int main() {
    char s1[100], s2[100];

    cout << "Enter first string: ";
    cin >> s1;

    cout << "Enter second string: ";
    cin >> s2;

    char* output = interweave(s1, s2);

    cout << "\nInterwoven string: " << output << "\n";

    free(output); 
    return 0;
}
