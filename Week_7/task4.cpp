/**
 * @filename - task4.cpp
 * @description - Placement marathon
 * @author - Diya Garg
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
using namespace std;

int tabulation(vector<int> &skillLevels, int students, int maximumDifference)
{
    unordered_map<int, int> dp;
    int ans = 1;

    for (int i = 0; i < students; i++)
    {
        int curr = skillLevels[i];
        int best = 1;

        if (dp.count(curr - maximumDifference))
            best = max(best, dp[curr - maximumDifference] + 1);

        if (dp.count(curr + maximumDifference))
            best = max(best, dp[curr + maximumDifference] + 1);

        dp[curr] = max(dp[curr], best);
        ans = max(ans, dp[curr]);
    }

    return ans;
}

int main()
{
    int students;
    cout << "Enter number of students : ";
    cin >> students;
    vector<int> skillLevels(students);
    cout << "Enter skill levels of students : " << endl;
    for (int i = 0; i < students; i++)
    {
        cout << "For student " << i + 1 << ": ";
        cin >> skillLevels[i];
    }
    int maximumDifference;
    cout << "Enter maximum difference allowed : ";
    cin >> maximumDifference;

    cout << "Result: " << tabulation(skillLevels, students, maximumDifference) << endl;
    return 0;
}