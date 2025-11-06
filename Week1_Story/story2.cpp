/**
 * @filename - Story2.cpp
 * @description - The Sum That Stands Out
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <vector>
using namespace std;

int suffixPrefix(vector<int>& arr) {
    int size= arr.size();
    vector<int> prefixSum(size, 0);
    vector<int> suffixSum(size, 0);

    for (int i = 1; i < size; i++) prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
    for (int i = size - 2; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + arr[i + 1];

    for (int i = 0; i < size; i++)
        if (prefixSum[i] == suffixSum[i]) return i;

    return -1;
}

// Main function
int main()
{
    // Input
    vector<int> arr;
    cout << "Enter number of elements: ";
    int size ;
    cin>>size;

    cout << "Enter elements: ";
    for (int i = 0; i < size; i++) {
        int value;
        cin>>value;
        arr.push_back(value);

    }
    // Function call and output

    int index = suffixPrefix(arr);
    if (index != -1)
        cout << "Index where prefix = suffix: " << index << endl;
    else
        cout << "No such index found.\n";
}