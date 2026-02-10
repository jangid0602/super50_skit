/**
 * @filename - Task2.cpp
 * @description - Codeup mentorsip  matching
 * @author - Ayushi Shukla
 */
#include <bits/stdc++.h>
using namespace std;

int totalMentors;
vector<vector<int>> compatibilityScore;
vector<int> dp;

int getMaxCompatibility(int mask)
{
   
    if (mask == (1 << totalMentors) - 1)
        return 0;

    if (dp[mask] != -1)
        return dp[mask];

    int studentIndex = __builtin_popcount(mask); 
    int bestScore = 0;

    for (int mentor = 0; mentor < totalMentors; mentor++)
    {
        if ((mask & (1 << mentor)) == 0)
        { 
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