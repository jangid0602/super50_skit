/**
 * @filename - Task1.cpp
 * @description - The O(1) Average Stack
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <stack>
using namespace std;

class AverageStack {
private:
    stack<int> dataStack;     // Stack to store elements
    long long totalSum;       // Maintains sum of stack elements

public:
    // Constructor to initialize sum
    AverageStack() : totalSum(0) {}

    // Push an element inside stack
    void push(int value) {
        dataStack.push(value);
        totalSum += value;
    }

    // Pop and return top element
    int pop() {
        if (dataStack.empty()) {
            cout << "Stack is empty. Cannot pop element.\n";
            return -1;
        }
        int topValue = dataStack.top();
        dataStack.pop();
        totalSum -= topValue;
        return topValue;
    }

    // Return top element without removing
    int top() {
        if (dataStack.empty()) {
            cout << "Stack is empty.\n";
            return -1;
        }
        return dataStack.top();
    }

    // Return average of stack elements
    double getAverage() {
        if (dataStack.empty()) {
            cout << "Stack is empty. Average cannot be determined.\n";
            return 0.0;
        }
        return static_cast<double>(totalSum) / dataStack.size();
    }

    // Utility to check stack emptiness
    bool empty() {
        return dataStack.empty();
    }
};

int main() {
    AverageStack s;
    int choice;

    cout << "----- Average Stack Menu -----\n";
    cout << "1. Push element\n";
    cout << "2. Pop element\n";
    cout << "3. Top element\n";
    cout << "4. Get Average\n";
    cout << "5. Exit\n";

    while (true) {
        cout << "\nEnter your choice: ";
        cin >> choice;

        if (choice == 1) {
            int value;
            cout << "Enter value to push: ";
            cin >> value;
            s.push(value);
            cout << "Pushed!\n";
        }
        else if (choice == 2) {
            cout << "Popped element: " << s.pop() << endl;
        }
        else if (choice == 3) {
            cout << "Top element: " << s.top() << endl;
        }
        else if (choice == 4) {
            cout << "Average: " << s.getAverage() << endl;
        }
        else if (choice == 5) {
            cout << "Exiting...\n";
            break;
        }
        else {
            cout << "Invalid choice! Try again.\n";
        }
    }

    return 0;
}
