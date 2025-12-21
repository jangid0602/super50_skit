/**
 * @filename - Story8.cpp
 * @description -  Browser History Navigator
 * @author - Fatimi Bee
 */

 #include <iostream>
#include <stack>
#include <string>
using namespace std;

class BrowserHistory {
private:
    stack<string> backStack;
    stack<string> forwardStack;
    string currentPage;

public:
    BrowserHistory(string homepage) {
        currentPage = homepage;
    }

    void visit(string url) {
        backStack.push(currentPage);  // save current page to back history
        currentPage = url;
        // visiting a new page clears forward history
        while (!forwardStack.empty()) forwardStack.pop();
    }

    void back() {
        if (backStack.empty()) {
            cout << "No pages in back history." << endl;
            return;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.top();
        backStack.pop();
        cout << currentPage << endl;
    }

    void forward() {
        if (forwardStack.empty()) {
            cout << "No pages in forward history." << endl;
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.top();
        forwardStack.pop();
        cout <<currentPage << endl;
    }

    void current() {
        cout << "Current page: " << currentPage << endl;
    }
};

int main() {
    string homepage;
    cout << "Enter homepage: ";
    cin >> homepage;

    BrowserHistory browser(homepage);

    int choice;
    string url;

    do {
        cout << "\nBrowser Menu:\n";
        cout << "1. Visit a new page\n";
        cout << "2. Go back\n";
        cout << "3. Go forward\n";
        cout << "4. Current page\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch(choice) {
            case 1:
                cout << "Enter URL to visit: ";
                cin >> url;
                browser.visit(url);
                break;
            case 2:
                browser.back();
                break;
            case 3:
                browser.forward();
                break;
            case 4:
                browser.current();
                break;
            case 5:
                cout << "Exiting browser." << endl;
                break;
            default:
                cout << "Invalid choice. Try again." << endl;
        }
    } while(choice != 5);

    return 0;
}
