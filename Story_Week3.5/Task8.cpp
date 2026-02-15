/* @file: Task3.cpp
@Description: The Browser History Navigator
@Author: Ayushi Shukla */
#include <iostream>
#include <stack>
using namespace std;
class BrowserHistory
{
    stack<string> backStack;
    stack<string> forwardStack;
    string currentPage;

public:
    BrowserHistory()
    {
        currentPage = "NULL";
    }
    void visit(const string &page)
    {
        if (currentPage != "NULL")
        {
            backStack.push(currentPage);
        }
        currentPage = page;
        // Clear forward history
        while (!forwardStack.empty())
        {
            forwardStack.pop();
        }
    }
    string back()
    {
        if (backStack.empty())
        {
            return currentPage; // No page to go back to
        }
        forwardStack.push(currentPage);
        currentPage = backStack.top();
        backStack.pop();
        return currentPage;
    }
    string forward()
    {
        if (forwardStack.empty())
        {
            return currentPage; // No page to go forward to
        }
        backStack.push(currentPage);
        currentPage = forwardStack.top();
        forwardStack.pop();
        return currentPage;
    }
    string getCurrentPage()
    {
        return currentPage;
    }
};
int main()
{
    BrowserHistory browser;
    int operations;
    cout << "Enter number of operations: ";
    cin >> operations;
    cout << "Enter operations (visit <url>/back/forward): " << endl;
    while (operations--)
    {
        string command;
        cin >> command;
        if (command == "visit")
        {
            string page;
            cout << "Enter page URL: ";
            cin >> page;
            browser.visit(page);
        }
        else if (command == "back")
        {
            browser.back();
        }
        else if (command == "forward")
        {
            browser.forward();
        }
    }
    cout << "Current page: " << browser.getCurrentPage() << endl;
}