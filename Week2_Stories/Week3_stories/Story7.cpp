/**
 * @filename - Story7.cpp
 * @description -  C-String Invervewer
 * @author - Diya Garg
 */

#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

char* interweave(char* s1, char* s2) {
    int length1 = strlen(s1);
    int length2 = strlen(s2);

    // Allocate memory for new string (max len = n1 + n2 + 1)
    char* result = (char*)malloc(length1 + length2 + 1);

    int i = 0, j = 0, k = 0;

    // Take characters alternatively
    while (i < length1 && j < length2) {
        result[k++] = s1[i++];
        result[k++] = s2[j++];
    }

    // Append remaining from s1
    while (i < length1)
        result[k++] = s1[i++];

    // Append remaining from s2
    while (j < length2)
        result[k++] = s2[j++];

    result[k] = '\0'; // Null-terminate
    return result;
}

int main() {
    char s1[100], s2[100];

    cout << "Enter first string: ";
    cin >> s1;

    cout << "Enter second string: ";
    cin >> s2;

    char* ans = interweave(s1, s2);

    cout << "Interweaved string: " << ans << endl;

    free(ans); // free allocated memory
    return 0;
}