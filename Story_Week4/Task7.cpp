/**
 * @filename - Task7.cpp
 * @description - The Secure Vault Code (permutation and backtracking)
 * @author - Ayushi Shukla
 */

//  Input: [1, 2, 3]
// Output: [123, 132, 213, 231, 312, 321]

#include <iostream>
#include <vector>
using namespace std;
void generatePermutations(vector<int> &arr, int index)
{
    // base case
    if (index >= arr.size())
    {
        for (int i = 0; i < arr.size(); i++)
        {
            cout << arr[i];
        }
        cout << endl;
        return;
    }

    for (int i = index; i < arr.size(); i++)
    {
        swap(arr[index], arr[i]);
        generatePermutations(arr, index + 1);
        // backtrack
        swap(arr[index], arr[i]);
    }
}

int main()
{
    int size;
    cout << "Enter the size of array: ";
    cin >> size;
    cout << "Enter the elements of array: ";
    vector<int> arr(size);
    for (int i = 0; i < size; i++)
    {
        cin >> arr[i];
    }
    cout << "The possible permutations are: " << endl;
    generatePermutations(arr, 0);
    return 0;
}