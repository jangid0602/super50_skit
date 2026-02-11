// @filename-Task4.cpp
// @Description: This program calculates the maximum number of pairs in an array whose sum equals a target value.
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class PairCalculator
{
public:
    // Function to calculate maximum number of pairs with given target sum
    int calculateMaximumPairs(const vector<int> &numbers, int targetSum)
    {
        unordered_map<int, int> unpairedFrequencies; // To store frequencies of unpaired numbers
        int totalPairs = 0;

        for (int currentNumber : numbers)
        {
            int complement = targetSum - currentNumber;

            // Check if complement is available to form a pair
            if (unpairedFrequencies[complement] > 0)
            {
                totalPairs++;                      // Increment pair count
                unpairedFrequencies[complement]--; // Decrement the frequency of the complement
            }
            else
            {
                unpairedFrequencies[currentNumber]++; // Store current number as unpaired
            }
        }

        return totalPairs;
    }
};

int main()
{
    int arraySize, targetSum;

    cout << "Enter the size of the array: ";
    cin >> arraySize;

    vector<int> numbers(arraySize);
    cout << "Enter the array elements: ";
    for (int i = 0; i < arraySize; i++)
    {
        cin >> numbers[i];
    }

    cout << "Enter the target sum: ";
    cin >> targetSum;

    PairCalculator calculator;
    int maximumPairs = calculator.calculateMaximumPairs(numbers, targetSum);

    cout << "Maximum number of pairs with sum " << targetSum << " = " << maximumPairs << endl;

    return 0;
}
