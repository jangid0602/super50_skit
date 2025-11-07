// @filename-Task5.cpp
// @Description: Finds the length of the longest contiguous subarray with equal number of red (1) and blue (2) elements, ignoring neutral (0) in length.
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class BalancedSubarrayFinder
{
public:
    int findLongestBalancedSubarray(const vector<int> &nums)
    {
        unordered_map<int, int> firstOccurrence; // prefixSum -> first index
        firstOccurrence[0] = -1;

        int prefixSum = 0;
        int maxLength = 0;

        // Count of 1s and 2s encountered so far
        int countRedBlue = 0;

        // To store count of 1s and 2s up to each index
        vector<int> countSoFar(nums.size(), 0);

        for (size_t i = 0; i < nums.size(); i++)
        {
            if (nums[i] == 1)
                prefixSum += 1;
            else if (nums[i] == 2)
                prefixSum -= 1;

            countRedBlue += (nums[i] == 1 || nums[i] == 2) ? 1 : 0;
            countSoFar[i] = countRedBlue;

            if (firstOccurrence.find(prefixSum) != firstOccurrence.end())
            {
                int startIndex = firstOccurrence[prefixSum];
                int subarrayLength;
                if (startIndex == -1)
                    subarrayLength = countSoFar[i];
                else
                    subarrayLength = countSoFar[i] - countSoFar[startIndex];

                maxLength = max(maxLength, subarrayLength);
            }
            else
            {
                firstOccurrence[prefixSum] = i;
            }
        }

        return maxLength;
    }
};

int main()
{
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter elements of array (0, 1, 2): ";
    for (int i = 0; i < n; i++)
        cin >> nums[i];

    BalancedSubarrayFinder finder;
    int longestLength = finder.findLongestBalancedSubarray(nums);

    cout << "Length of the longest balanced subarray (ignoring neutral in length): " << longestLength << endl;

    return 0;
}
