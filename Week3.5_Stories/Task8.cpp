/**
 * @filename - Task-8.cpp
 * @description - The Browser History Navigator 
 * @author - Diya Garg
 */
#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    stack<string> backHistoryStack;
    stack<string> forwardHistoryStack;

    string currentPageUrl = "home";
    cout << "Current Page: " << currentPageUrl << endl;

    int userChoice;
    string newPageUrl;

    while (true) {
        cout << "\n1. Visit New Page";
        cout << "\n2. Back";
        cout << "\n3. Forward";
        cout << "\n4. Exit";
        cout << "\nEnter choice: ";
        cin >> userChoice;

        if (userChoice == 1) {
            cout << "Enter page name: ";
            cin >> newPageUrl;

            backHistoryStack.push(currentPageUrl);
            currentPageUrl = newPageUrl;

            // clear forward history
            while (!forwardHistoryStack.empty())
                forwardHistoryStack.pop();

            cout << "Current Page: " << currentPageUrl << endl;
        }
        else if (userChoice == 2) {
            if (backHistoryStack.empty()) {
                cout << "No page to go back.\n";
            } else {
                forwardHistoryStack.push(currentPageUrl);
                currentPageUrl = backHistoryStack.top();
                backHistoryStack.pop();
                cout << "Current Page: " << currentPageUrl << endl;
            }
        }
        else if (userChoice == 3) {
            if (forwardHistoryStack.empty()) {
                cout << "No page to go forward.\n";
            } else {
                backHistoryStack.push(currentPageUrl);
                currentPageUrl = forwardHistoryStack.top();
                forwardHistoryStack.pop();
                cout << "Current Page: " << currentPageUrl << endl;
            }
        }
        else if (userChoice == 4) {
            break;
        }
        else {
            cout << "Invalid choice\n";
        }
    }

    return 0;
}
