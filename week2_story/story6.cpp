/**
 * @filename - story6.cpp
 * @description - Text Editor NonOverlapping Replacement
 * @author - Fatimi Bee 
 */


#include <iostream>
#include <string>

using namespace std;

string replaceNonOverlapping(string text, const string& findStr, const string& replaceStr) {
    string result = "";
    int i = 0;

    while (i < text.length()) {
        // Check if findStr matches starting at index i
        if (text.substr(i, findStr.length()) == findStr) {
            result += replaceStr;
            i += findStr.length();  // jump to next non-overlapping segment
        } else {
            result += text[i];
            i++;
        }
    }

    return result;
}
int main() {
    string text, findStr, replaceStr;
    cout<<"Enter the original text :";
    cin>>text;
    cout<<"Enter the string to find :";
    cin>>findStr;
    cout<<"Enter the string to replace with :";
    cin>>replaceStr;
    cout<<"Modified Text :"<<replaceNonOverlapping(text, findStr, replaceStr);
}