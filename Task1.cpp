/*
 * @filename - Task1.cpp
 * @description - This program performs count of subarray.
 * @author - Aditi Agrawal
 */

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter element " << i + 1 << ": ";
        cin >> arr[i];
    }

    int target;
    cout << "Enter target sum: ";
    cin >> target;

    int count = 0;

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += arr[j];   
            if (sum == target) {
                count++;  
            }
        }
    }

    cout << "Number of subarrays with sum " << target << " = " << count << endl;

    return 0;
}
