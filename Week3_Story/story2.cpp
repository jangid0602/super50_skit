/**
 * @filename - Story2.cpp
 * @description -  Python Indentation validator
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;

bool isValidIndentation(const vector<string>& lines) {
    stack<int> indentStack;
    indentStack.push(0);   // base indentation level

    for (const string& line : lines) {

        // Count leading spaces
        int spaces = 0;
        while (spaces < line.size() && line[spaces] == ' ')
            spaces++;

        // Skip empty or all-space lines
        if (spaces == line.size()) continue;

        int lastIndent = indentStack.top();

        if (spaces == lastIndent) {
            continue;  // same level = ok
        }
        else if (spaces > lastIndent) {
            indentStack.push(spaces);  // new deeper block
        }
        else {
            // Dedent: pop until we match indentation
            while (!indentStack.empty() && indentStack.top() > spaces)
                indentStack.pop();

            if (indentStack.empty() || indentStack.top() != spaces)
                return false;  // no matching indentation found
        }
    }
    return true;
}

int main() {
    vector<string> code;
    string line;

    cout << "Enter Python code lines (empty line to stop):\n";

    while (true) {
        getline(cin, line);
        if (line.empty()) break;
        code.push_back(line);
    }

    if (isValidIndentation(code))
        cout << "Indentation is valid.\n";
    else
        cout << "Indentation is invalid.\n";

    return 0;
}
