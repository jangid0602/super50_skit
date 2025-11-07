#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    int arraySize;
    cout << "Enter size of array: ";
    cin >> arraySize;

    vector<int> postTypes(arraySize);
    cout << "Enter elements of array (either 1, 2, or 0): ";
    for (int i = 0; i < arraySize; i++) {
        cin >> postTypes[i];
    }

    unordered_map<int, int> firstOccurrence;
    firstOccurrence[0] = -1;

    int prefixSum = 0;
    int maxSubarrayLength = 0;

    for (int i = 0; i < arraySize; i++) {
        if (postTypes[i] == 1) {
            prefixSum += 1;
        } else if (postTypes[i] == 2) {
            prefixSum -= 1;
        }

        if (firstOccurrence.find(prefixSum) != firstOccurrence.end()) {
            maxSubarrayLength = max(maxSubarrayLength, i - firstOccurrence[prefixSum]);
        } else {
            firstOccurrence[prefixSum] = i;
        }
    }

    cout << "Length of the longest contiguous subarray is: " << maxSubarrayLength << endl;
    return 0;
}
