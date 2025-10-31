/**
 * @filename - Story4.cpp
 * @description - The Odd One Out 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int f(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());  // Sort the array

        // Compare pairs
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];  // This one doesn’t have a pair
            }
        }

        // If all pairs matched till the end, the last element is single
        return arr[n - 1];
    }
};

int main() {
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    cout << "Enter elements of array: ";
    vector<int> arr(size);
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    Solution obj;
    int ans = obj.f(arr);

    cout << "Single element in array is: " << ans << endl;
    return 0;
}
