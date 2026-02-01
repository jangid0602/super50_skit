/**
 * @filename - Task10.cpp
 * @description - The Palindromic Deployment
 * @author - Ayushi Shukla
 */
#include <iostream>
#include <vector>
using namespace std;

int lps(int leftIndex, int rightIndex,
        vector<vector<int>> dp,
        string inputString)
{

    if (leftIndex > rightIndex)
        return 0;
    if (leftIndex == rightIndex)
        return 1;

    if (dp[leftIndex][rightIndex] != -1)
        return dp[leftIndex][rightIndex];

    if (inputString[leftIndex] == inputString[rightIndex])
    {
        return dp[leftIndex][rightIndex] =
                   2 + lps(leftIndex + 1,
                           rightIndex - 1,
                           dp,
                           inputString);
    }
    else
    {
        return dp[leftIndex][rightIndex] =
                   max(lps(leftIndex + 1,
                           rightIndex,
                           dp,
                           inputString),
                       lps(leftIndex,
                           rightIndex - 1,
                           dp,
                           inputString));
    }
}

int main()
{
    string inputString;
    cout << "Enter the string: ";
    cin >> inputString;

    int stringLength = inputString.length();

    vector<vector<int>> dp(stringLength + 1,
                           vector<int>(stringLength + 1, -1));

    int minimumDeletions =
        stringLength - lps(0, stringLength - 1,
                           dp, inputString);

    cout << "Minimum number of deletions to make the string palindrome: "
         << minimumDeletions;

    return 0;
}