/**
 * @filename - story2-4.cpp
 * @description -  Maximal Pair Matching 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int countMaxPairsWithTargetSum(vector<int>& numbers, int targetSum) {
    unordered_map<int, int> frequencyMap;
    int arraySize = numbers.size();
    int totalPairs = 0;

    for (int value : numbers) {
        int complement = targetSum - value;
        if (frequencyMap[complement] > 0) {
            totalPairs++;
            frequencyMap[complement]--;
        } else {
            frequencyMap[value]++;
        }
    }

    return totalPairs;
}

int main() {
    int arraySize;
    cout << "Enter size of array: ";
    cin >> arraySize;

    vector<int> numbers(arraySize);
    cout << "Enter elements of array: ";
    for (int i = 0; i < arraySize; i++) {
        cin >> numbers[i];
    }

    int targetSum;
    cout << "Enter target: ";
    cin >> targetSum;

    int maxPairs = countMaxPairsWithTargetSum(numbers, targetSum);
    cout << "Maximum number of pairs are: " << maxPairs << endl;

    return 0;
}
