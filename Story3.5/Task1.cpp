/**
 * @filename - Task-1.cpp
 * @description - The Cosmic Courier Challenge
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
using namespace std;

int calculateMinimumDeadline(vector<int>& routeTimes) {
    if (routeTimes.size() == 0) return 0;
    if (routeTimes.size() == 1) return routeTimes[0];

    int largestTime = routeTimes[0];
    int secondLargestTime = -1;

    for (int index = 1; index < routeTimes.size(); index++) {
        if (routeTimes[index] > largestTime) {
            secondLargestTime = largestTime;
            largestTime = routeTimes[index];
        } else if (routeTimes[index] > secondLargestTime) {
            secondLargestTime = routeTimes[index];
        }
    }

    return secondLargestTime;
}

int main() {
    int numberOfRoutes;
    cout << "Enter number of routes: ";
    cin >> numberOfRoutes;

    if (numberOfRoutes <= 0) {
        cout << "Invalid input." << endl;
        return 0;
    }

    vector<int> routeTimes(numberOfRoutes);
    for (int index = 0; index < numberOfRoutes; index++) {
        cin >> routeTimes[index];
    }

    cout << "Minimum Deadline: "
         << calculateMinimumDeadline(routeTimes) << endl;

    return 0;
}

