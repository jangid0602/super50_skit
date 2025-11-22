/**
 * @filename   : Task-7.cpp
 * @description: The C-String Interweaver (Interleave Two C-Strings)
 * @author : Ayushi Shukla  
 */

#include <iostream>
#include <cstring>     // for strlen()
#include <cstdlib>     // for malloc() and free()
using namespace std;

// Function to interweave two C-strings
char* interweave(char* firstString, char* secondString) {

    int lengthFirst  = strlen(firstString);
    int lengthSecond = strlen(secondString);

// Allocate memory for the interwoven string
    char* interwovenString = (char*)malloc(lengthFirst + lengthSecond + 1);

    int indexFirst = 0;
    int indexSecond = 0;
    int writeIndex = 0;

  // Interleave characters from both strings
    while (firstString[indexFirst] != '\0' &&
           secondString[indexSecond] != '\0') 
    {
        interwovenString[writeIndex++] = firstString[indexFirst++];
        interwovenString[writeIndex++] = secondString[indexSecond++];
    }

    // Append remaining characters from first string
    while (firstString[indexFirst] != '\0') {
        interwovenString[writeIndex++] = firstString[indexFirst++];
    }

    // Append remaining characters from second string
    while (secondString[indexSecond] != '\0') {
        interwovenString[writeIndex++] = secondString[indexSecond++];
    }

    // Null-terminate the interwoven string
    interwovenString[writeIndex] = '\0';

    return interwovenString;
}

// Main Function
int main() {

    char firstInput[200];
    char secondInput[200];

    cout << "Enter first string: ";
    cin >> firstInput;

    cout << "Enter second string: ";
    cin >> secondInput;

    char* result = interweave(firstInput, secondInput);

    cout << "\nInterwoven String: " << result << "\n";

    free(result);  // free allocated heap memory

    return 0;
}
