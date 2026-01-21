/**
 * @filename - Task-3.cpp
 * @description - The Factory Floor Robot
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

string assignLabel(int weight) {
    if (weight % 15 == 0) return "Hazardous";
    if (weight % 3 == 0) return "Heavy";
    if (weight % 5 == 0) return "Fragile";
    return to_string(weight);
}

int main() {
    int count;
    cout << "Enter number of items: ";
    cin >> count;

    if (count <= 0) return 0;

    for (int index = 0; index < count; index++) {
        int weight;
        cin >> weight;
        cout << assignLabel(weight) << endl;
    }

    return 0;
}

