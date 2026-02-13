/**
 * @filename - Task-1.cpp
 * @description -  The O(1) Average Stack
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <stdexcept> 

using namespace std;

class AverageStack {
private:
    vector<int> stackData;   
    long long totalSum;      

public:
    AverageStack() {
        totalSum = 0;
    }

    void push(int value) {
        stackData.push_back(value);
        totalSum += value;
    }

    int pop() {
        if (stackData.empty()) {
            throw runtime_error("Stack is empty. Element cannot be popped.");
        }
        int topValue = stackData.back();
        stackData.pop_back();
        totalSum -= topValue;
        return topValue;
    }

    int top() {
        if (stackData.empty()) {
            throw runtime_error("Stack is empty.");
        }
        return stackData.back();
    }

    double getAverage() {
        if (stackData.empty()) {
            throw runtime_error("Stack is empty.");
        }
        return static_cast<double>(totalSum) / stackData.size();
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

        try {
            if (choice == 1) {
                int value;
                cout << "Enter value to push: ";
                cin >> value;
                s.push(value);
                cout << "Pushed!\n";

            } else if (choice == 2) {
                cout << "Popped element: " << s.pop() << endl;

            } else if (choice == 3) {
                cout << "Top element: " << s.top() << endl;

            } else if (choice == 4) {
                cout << "Average: " << s.getAverage() << endl;

            } else if (choice == 5) {
                cout << "Exiting...\n";
                break;

            } else {
                cout << "Invalid choice, please try again.\n";
            }
        }
        catch (const exception &e) {
            cout << "Error: " << e.what() << endl;
        }
    }

    return 0;
}
