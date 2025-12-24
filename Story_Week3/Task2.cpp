/**
 * @filename - Task-2.cpp
 * @description - The Python Indentation Validator
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <string>
#include <stack>
using namespace std;

bool isValidIndentation(const vector<string> &codeLines)
{

    // Stack to keep track of indentation levels
    stack<int> indentStack;
    indentStack.push(0); // Base indentation level

    bool previousLineStartsBlock = false;

    for (const string &line : codeLines)
    {

        if (line.empty())
            continue;

        // Count leading spaces
        int spaceCount = 0;
        for (char ch : line)
        {
            if (ch == ' ')
                spaceCount++;
            else
                break;
        }

        int currentIndentation = spaceCount;

        // ---------------------------
        // RULE 1: Check indentation validity
        // ---------------------------
        if (currentIndentation > 0 && !previousLineStartsBlock)
            return false;

        // ---------------------------
        // RULE 2: Manage indentation stack
        // ---------------------------
        if (currentIndentation > indentStack.top())
        {
            indentStack.push(currentIndentation);
        }
        else if (currentIndentation == indentStack.top())
        {
            // Same level, do nothing
        }
        else
        {
            // Decrease in indentation
            while (!indentStack.empty() && indentStack.top() > currentIndentation)
            {
                indentStack.pop();
            }
            if (indentStack.empty() || indentStack.top() != currentIndentation)
                return false;
        }

        // ---------------------------
        // RULE 3: Check if this line ends with ':'
        // ---------------------------
        previousLineStartsBlock = (!line.empty() && line.back() == ':');
    }

    return true;
}

int main()
{

    int totalLines;
    cout << "Enter number of lines: ";
    cin >> totalLines;

    cin.ignore();

    vector<string> codeLines(totalLines);

    cout << "\nEnter the Python code lines:\n";
    for (int index = 0; index < totalLines; index++)
    {
        getline(cin, codeLines[index]);
    }

    bool isValid = isValidIndentation(codeLines);

    if (isValid)
        cout << "\nIndentation is VALID.\n";
    else
        cout << "\nIndentation is INVALID.\n";

    return 0;
}
