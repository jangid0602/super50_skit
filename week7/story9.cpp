/**
 * @filename - story9.cpp
 * @description - the Circular Office Security
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;

int solveRange(int startIndex, int endIndex, vector<int> &cabinValues, vector<int> &memoDP)
{
    if (startIndex > endIndex)
        return 0;

    if (memoDP[startIndex] != -1)
        return memoDP[startIndex];

    int takeCurrentCabin = cabinValues[startIndex] +
                           solveRange(startIndex + 2, endIndex, cabinValues, memoDP);

    int skipCurrentCabin =
        solveRange(startIndex + 1, endIndex, cabinValues, memoDP);

    return memoDP[startIndex] = max(takeCurrentCabin, skipCurrentCabin);
}

int main()
{
    int numberOfCabins;
    cout << "Enter number of cabins: ";
    cin >> numberOfCabins;

    vector<int> cabinValues(numberOfCabins);
    cout << "Enter value of each cabin: ";
    for (int i = 0; i < numberOfCabins; i++)
    {
        cin >> cabinValues[i];
    }

    if (numberOfCabins == 1)
    {
        cout << "Maximum value that can be audited: " << cabinValues[0];
        return 0;
    }

    vector<int> memoCase1(numberOfCabins, -1);
    vector<int> memoCase2(numberOfCabins, -1);

    int maximumAuditedValue = max(
        solveRange(0, numberOfCabins - 2, cabinValues, memoCase1),
        solveRange(1, numberOfCabins - 1, cabinValues, memoCase2));

    cout << "Maximum value that can be audited: " << maximumAuditedValue;
    return 0;
}
