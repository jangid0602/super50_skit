/**
 * @filename - Task-8.cpp
 * @description - The Browser History Navigator
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class BrowserHistory {
private:
    vector<string> backStack;
    vector<string> forwardStack;
    string currentPage;

public:
    BrowserHistory() {
        currentPage = "";
    }

    void visitPage(string page) {
        if (currentPage != "") {
            backStack.push_back(currentPage);
        }
        currentPage = page;
        forwardStack.clear();
    }

    string goBack() {
        if (backStack.empty()) return "NULL";
        forwardStack.push_back(currentPage);
        currentPage = backStack.back();
        backStack.pop_back();
        return currentPage;
    }

    string goForward() {
        if (forwardStack.empty()) return "NULL";
        backStack.push_back(currentPage);
        currentPage = forwardStack.back();
        forwardStack.pop_back();
        return currentPage;
    }
};

int main() {
    BrowserHistory browser;
    browser.visitPage("A");
    browser.visitPage("B");
    cout << browser.goBack() << endl;
    return 0;
}

