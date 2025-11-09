/**
 * @filename - Story4.cpp
 * @description - Flip the Switch 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // Function to find minimum number of flips to make all 0s or all 1s
    int findMinFlips(vector<int>& arr) {
        int n = arr.size();
        int countZero = 0;  // count of 0s in the array
        int countOne = 0;   // count of 1s in the array

        // Count number of 0s and 1s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                countZero++;
            else
                countOne++;
        }

        // Minimum flips needed will be the smaller of the two counts
        if (countZero < countOne)
            return countZero;
        else
            return countOne;
    }
};

int main() {
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    vector<int> arr(size);
    cout << "Enter array elements (either 0 or 1): ";
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    Solution obj;
    int result = obj.findMinFlips(arr);

    cout << "Minimum number of flips required are: " << result << endl;

    return 0;
}
