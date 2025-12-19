/**
 * @filename   : BrowserHistory.cpp
 * @description: Implement browser navigation using back and forward stacks.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <stack>
using namespace std;

class BrowserHistory {
private:
    stack<string> backStack;
    stack<string> forwardStack;
    string currentPage;

public:
    BrowserHistory() {
        currentPage = "";
    }

  
    void visit(string page) {
        if (!currentPage.empty()) {
            backStack.push(currentPage);
        }
        currentPage = page;

       
        while (!forwardStack.empty())
            forwardStack.pop();
    }

   
    string back() {
        if (backStack.empty())
            return currentPage;

        forwardStack.push(currentPage);
        currentPage = backStack.top();
        backStack.pop();

        return currentPage;
    }


    string forward() {
        if (forwardStack.empty())
            return "NULL";

        backStack.push(currentPage);
        currentPage = forwardStack.top();
        forwardStack.pop();

        return currentPage;
    }

    string getCurrentPage() {
        return currentPage;
    }
};

int main() {

    BrowserHistory browser;

    // Test Case 1
    browser.visit("A");
    browser.visit("B");
    cout << browser.back() << endl;  

    // Test Case 2
    browser.back();
    browser.visit("C");
    cout << browser.forward() << endl; 

    // Test Case 3
    BrowserHistory browser2;
    browser2.visit("1");
    browser2.visit("2");
    browser2.visit("3");
    browser2.back();
    cout << browser2.forward() << endl; 

    return 0;
}
