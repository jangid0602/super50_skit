/**
 * @filename - Task-2.cpp
 * @description -  The Python Indentation Validator
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <string>
#include <stack>
using namespace std;

bool isValidIndentation(const vector<string>& codeLines) {
    stack<int> indentationLevels;  
    indentationLevels.push(0); 
    for (const string& line : codeLines) {
        if (line.empty())
            continue;
        int leadingSpaces = 0;
        for (char ch : line) {
            if (ch == ' ')
                leadingSpaces++;
            else
                break;
        }
        if (leadingSpaces == 0)
            continue;
        int currentIndent = leadingSpaces;
        if (currentIndent > indentationLevels.top()) {
            indentationLevels.push(currentIndent);
        }
        else if (currentIndent == indentationLevels.top()) {
            continue;
        }
        else {
            while (!indentationLevels.empty() && indentationLevels.top() > currentIndent) {
                indentationLevels.pop();
            }
            if (indentationLevels.empty() || indentationLevels.top() != currentIndent)
                return false;
        }
    }

    return true;
}

int main() {
    int numberOfLines;
    cout << "Enter number of lines: ";
    cin >> numberOfLines;

    cin.ignore();
    vector<string> codeLines(numberOfLines);

    cout << "\nEnter the Python code lines:\n";
    for (int i = 0; i < numberOfLines; i++) {
        getline(cin, codeLines[i]);
    }

    bool result = isValidIndentation(codeLines);

    if (result)
        cout << "\nIndentation is VALID.\n";
    else
        cout << "\nIndentation is INVALID.\n";

    return 0;
}
