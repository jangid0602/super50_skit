/**
 * @filename - Task2.cpp
 * @description - The Staircase Architect (Recursion) 
 * @author - Disha Toshniwal 
 */
#include <iostream>
using namespace std;

int countWays(int steps) {
    if (steps < 2) return 1;
    return countWays(steps - 1) + countWays(steps - 2);
}

int main() {
    int totalSteps;
    cout << "Enter total number of steps: ";
    cin >> totalSteps;

    int totalWays = countWays(totalSteps);
    cout << "Total distinct ways to climb: " << totalWays;

    return 0;
}
