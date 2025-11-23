/**
 * @filename - Story1.cpp
 * @description -  O(1) Averase Stack
 * @author - Diya Garg
 */

#include <stack>
#include <iostream>
#include <limits>
using namespace std;

class AverageStack {
private:
    stack<int> valueStack; 
    stack<double> averageStack;

public:
    AverageStack() {}

    void pushValue(int value) {
        valueStack.push(value);
        if (averageStack.empty()) {
            averageStack.push(value);
        } else {
            double currentAverage = averageStack.top();
            double newAverage =
                (currentAverage * (valueStack.size() - 1) + value) / valueStack.size();
            averageStack.push(newAverage);
        }
    }

    int popValue() {
        if (valueStack.empty()) {
            throw out_of_range("Stack is empty!");
        }
        int poppedValue = valueStack.top();
        valueStack.pop();
        averageStack.pop();
        return poppedValue;
    }

    int topValue() {
        if (valueStack.empty()) {
            throw out_of_range("null");
        }
        return valueStack.top();
    }

    double getAverageValue() {
        if (averageStack.empty()) {
            throw out_of_range("null");
        }
        return averageStack.top();
    }

    bool isEmpty() {
        return valueStack.empty();
    }
};

int main() {
    AverageStack avgStack;
    int choice;

    while (true) {

        cout << "\n====== MENU ======\n";
        cout << "1. Push Value\n";
        cout << "2. Pop Value\n";
        cout << "3. Top Value\n";
        cout << "4. Get Average\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";

        // Validate choice input
        if (!(cin >> choice)) {
            cout << "Invalid input! Please enter numbers only.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            continue;
        }

        switch (choice) {
            case 1: {
                int value;
                cout << "Enter value to push: ";
                while (!(cin >> value)) {
                    cout << "Invalid input! Enter an integer value: ";
                    cin.clear();
                    cin.ignore(numeric_limits<streamsize>::max(), '\n');
                }
                avgStack.pushValue(value);
                break;
            }

            case 2:
                try {
                    cout << "Popped: " << avgStack.popValue() << endl;
                } catch (const exception& e) {
                    cout << e.what() << endl;
                }
                break;

            case 3:
                try {
                    cout << "Top Element: " << avgStack.topValue() << endl;
                } catch (const exception& e) {
                    cout << e.what() << endl;
                }
                break;

            case 4:
                try {
                    cout << "Current Average: " 
                         << avgStack.getAverageValue() << endl;
                } catch (const exception& e) {
                    cout << e.what() << endl;
                }
                break;

            case 5:
                cout << "Exiting program...\n";
                return 0;

            default:
                cout << "Invalid Choice! Try again.\n";
        }
    }
}