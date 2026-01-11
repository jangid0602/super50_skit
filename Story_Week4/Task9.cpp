/**
 * @filename - Task9.cpp
 * @description - The Budget Calculator
 * @author - Ayushi Shukla
 */
#include <iostream>
#include <vector>
using namespace std;

void CombinationSum(int arr[], int size, int index, int budget, vector<int> &path)
{
    // exact budget match
    if (budget == 0)
    {
        cout << "[ ";
        for (int num : path)
            cout << num << " ";
        cout << "]" << endl;
        return;
    }

    // invalid case
    if (budget < 0 || index == size)
        return;

    // include current element (same index again)
    path.push_back(arr[index]);
    CombinationSum(arr, size, index, budget - arr[index], path);
    path.pop_back(); // backtrack

    // exclude current element (move to next)
    CombinationSum(arr, size, index + 1, budget, path);
}

int main()
{
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    int arr[size];
    cout << "Enter the numbers: ";
    for (int i = 0; i < size; i++)
        cin >> arr[i];

    int budget;
    cout << "Enter the budget: ";
    cin >> budget;

    vector<int> path;
    cout << "Combinations are:\n";
    CombinationSum(arr, size, 0, budget, path);

    return 0;
}
