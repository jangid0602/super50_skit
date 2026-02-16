/**
 * @filename - task2.cpp
 * @description - Codeup mentorsip  matching
 * @author - Diya Garg
 */
#include <bits/stdc++.h>
using namespace std;

int totalMentors;
vector<vector<int>> compatibilityScore;
vector<int> dp;

int getMaxCompatibility(int mask)
{
    // If all mentors are used, no more students left
    if (mask == (1 << totalMentors) - 1)
        return 0;

    // If already computed
    if (dp[mask] != -1)
        return dp[mask];

    int studentIndex = __builtin_popcount(mask); // which student to assign now
    int bestScore = 0;

    // Try assigning each unused mentor
    for (int mentor = 0; mentor < totalMentors; mentor++)
    {
        if ((mask & (1 << mentor)) == 0)
        { // mentor not used
            int newMask = mask | (1 << mentor);

            int currentScore =
                compatibilityScore[studentIndex][mentor] +
                getMaxCompatibility(newMask);

            bestScore = max(bestScore, currentScore);
        }
    }

    return dp[mask] = bestScore;
}

int main()
{
    cout << "Enter number of mentors/students: ";
    cin >> totalMentors;

    compatibilityScore.resize(totalMentors,
                              vector<int>(totalMentors));

    for (int i = 0; i < totalMentors; i++)
    {
        cout << "Enter compatiblity scores for student " << i + 1 << ": ";
        for (int j = 0; j < totalMentors; j++)
        {
            cin >> compatibilityScore[i][j];
        }
    }

    dp.assign(1 << totalMentors, -1);

    cout << getMaxCompatibility(0) << endl;
    return 0;
}