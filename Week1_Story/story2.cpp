/**
 * @filename - Story2.cpp
 * @description - The Sum That Stands Out
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int suffix_prefix(vector<int>& arr) {
    int size= arr.size();
    vector<int> prefix_sum(size, 0);
    vector<int> suffix_sum(size, 0);

    for (int i = 1; i < size; i++) prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1];
    for (int i = size - 2; i >= 0; i--) suffix_sum[i] = suffix_sum[i + 1] + arr[i + 1];

    for (int i = 0; i < size; i++)
        if (prefix_sum[i] == suffix_sum[i]) return i;

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

    int index = suffix_prefix(arr);
    if (index != -1)
        cout << "Index where prefix = suffix: " << index << endl;
    else
        cout << "No such index found.\n";
}