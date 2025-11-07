/**
 * @filename - Story4.cpp
 * @description - The Odd One Out using XOR
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;

const int NOT_FOUND = -1;


int oddOneOut(const vector<int>& elements) {
    int xorResult = 0;

    for (int value : elements) {
        xorResult ^= value;
    }

    // If XOR result is zero, means no odd occurring element found
    if (xorResult == 0) {
        return NOT_FOUND;
    }

    return xorResult;
}

int main() {
    vector<int> elements;

    cout << "Enter number of elements: ";
    int size;
    cin >> size;

    cout << "Enter elements: ";
    for (int i = 0; i < size; i++) {
        int value;
        cin >> value;
        elements.push_back(value);
    }

    int result = oddOneOut(elements);

    if (result == NOT_FOUND) {
        cout << "No odd one out found." << endl;
    } else {
        cout << "The odd one out is: " << result << endl;
    }

    return 0;
}
