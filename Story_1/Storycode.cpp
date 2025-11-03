/*
------------------------------------------------------------
File Name   : MultiUtilityPrograms.cpp
Author      : Ram Goyal
Description : This program implements multiple utility functions 
              like Efficient Traveller, Sum That Stands Out,
              Flip The Switch, Odd One Out, Smart Pair Finder,
              and The Minimalist Painter using basic algorithms.
------------------------------------------------------------
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// ------------------------------------------------------------
// Function 1: The Minimalist Painter
// Description: Finds minimum total time after skipping one wall
// ------------------------------------------------------------
int minPaintingTime(vector<int>& time) {
    int totalTime = 0;
    int maxTime = 0;

    for (int t : time) {
        totalTime += t;
        maxTime = max(maxTime, t);
    }

    return totalTime - maxTime;
}

// ------------------------------------------------------------
// Function 2: Smart Pair Finder
// Description: Checks if a pair exists with given sum k
// ------------------------------------------------------------
bool hasPairWithSum(vector<int>& nums, int k) {
    for (int i = 0; i < nums.size(); i++) {
        for (int j = i + 1; j < nums.size(); j++) {
            if (nums[i] + nums[j] == k)
                return true;
        }
    }
    return false;
}

// ------------------------------------------------------------
// Function 3: Odd One Out
// Description: Finds element with frequency 1 in array
// ------------------------------------------------------------
int findSingleElement(vector<int>& arr) {
    int maxElement = *max_element(arr.begin(), arr.end());
    vector<int> freq(maxElement + 1, 0);

    for (int i = 0; i < arr.size(); i++) {
        freq[arr[i]]++;
    }

    for (int i = 0; i <= maxElement; i++) {
        if (freq[i] == 1) {
            return i;
        }
    }

    return -1;
}

// ------------------------------------------------------------
// Function 4: The Sum That Stands Out
// Description: Finds index where left sum == right sum
// ------------------------------------------------------------
int SumthatStandsOut(int arr[], int n) {
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
        totalSum += arr[i];
    }

    int leftSum = 0;
    for (int i = 0; i < n; i++) {
        int rightSum = totalSum - leftSum - arr[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += arr[i];
    }

    return -1;
}

// ------------------------------------------------------------
// Function 5: Flip the Switch
// Description: Finds minimum flips needed to make all bits same
// ------------------------------------------------------------
int FlipSwitch(int arr[], int n) {
    vector<int> freq(2, 0);
    for (int i = 0; i < n; i++) {
        freq[arr[i]]++;
    }
    return min(freq[0], freq[1]);
}

// ------------------------------------------------------------
// Function 6: Efficient Traveller
// Description: Determines how far traveller can go with given energy
// ------------------------------------------------------------
int EfficientTraveller(int arr[], int n, int energy) {
    if (energy < 0)
        return -1;

    for (int i = 0; i < n; i++) {
        energy -= arr[i];
        if (energy < 0) {
            return i;
        }
    }

    return n;
}

// ------------------------------------------------------------
// Main Program
// ------------------------------------------------------------
int main() {
    int choice;
    cout << "Enter Choice between 1 to 6:\n";
    cout << "1 for Efficient Traveller\n";
    cout << "2 for The Sum That Stands Out\n";
    cout << "3 for Flip the Switch\n";
    cout << "4 for Odd one Out\n";
    cout << "5 for Smart Pair Finder\n";
    cout << "6 for The Minimalist Painter\n";
    cin >> choice;

    switch (choice) {
        case 1: {
            cout << "\nYou selected Efficient Traveller\n";
            cout << "Enter array size: ";
            int n;
            cin >> n;

            int arr[n];
            cout << "Enter array elements: ";
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }

            cout << "Enter Initial Energy: ";
            int energy;
            cin >> energy;

            int distance = EfficientTraveller(arr, n, energy);

            if (distance == -1)
                cout << "Traveller cannot travel\n";
            else if (distance == n)
                cout << "Traveller completed the entire journey\n";
            else
                cout << "Traveller can travel up to distance: " << distance << "\n";
            break;
        }

        case 2: {
            cout << "\nYou selected The Sum That Stands Out\n";
            cout << "Enter array size: ";
            int n;
            cin >> n;
            int arr[n];
            cout << "Enter array elements: ";
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }
            int index = SumthatStandsOut(arr, n);
            if (index != -1)
                cout << "Index with equal left and right sum: " << index << "\n";
            else
                cout << "No such index found\n";
            break;
        }

        case 3: {
            cout << "\nYou selected Flip the Switch\n";
            cout << "Enter array size: ";
            int n;
            cin >> n;
            int arr[n];
            cout << "Enter array elements (0s and 1s only): ";
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }
            int minFlips = FlipSwitch(arr, n);
            cout << "Minimum number of flips required: " << minFlips << "\n";
            break;
        }

        case 4: {
            cout << "\nYou selected Odd one Out\n";
            cout << "Enter array size: ";
            int n;
            cin >> n;
            vector<int> arr(n);
            cout << "Enter array elements: ";
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }
            int singleElement = findSingleElement(arr);
            if (singleElement != -1)
                cout << "The odd one out is: " << singleElement << "\n";
            else
                cout << "No odd one out found\n";
            break;
        }

        case 5: {
            cout << "\nYou selected Smart Pair Finder\n";
            cout << "Enter array size: ";
            int size;
            cin >> size;
            vector<int> numbers(size);
            cout << "Enter array elements: ";
            for (int i = 0; i < size; i++) {
                cin >> numbers[i];
            }
            cout << "Enter target sum: ";
            int k;
            cin >> k;
            bool check = hasPairWithSum(numbers, k);
            if (check)
                cout << "Found a pair with the given sum.\n";
            else
                cout << "No pair found with the given sum.\n";
            break;
        }

        case 6: {
            cout << "\nYou selected The Minimalist Painter\n";
            cout << "Enter number of walls: ";
            int wallCount;
            cin >> wallCount;
            vector<int> paintingTimes(wallCount);
            cout << "Enter painting times for each wall: ";
            for (int i = 0; i < wallCount; i++) {
                cin >> paintingTimes[i];
            }
            int minTime = minPaintingTime(paintingTimes);
            cout << "Minimum painting time required: " << minTime << "\n";
            break;
        }

        default:
            cout << "Invalid Choice\n";
    }

    return 0;
}
