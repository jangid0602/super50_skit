/**
 * @filename - story3.cpp
 * @description - Minimal Tech Stack Swap
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
int tabulation(string &currentStack, string &desiredStack, int m, int n, int insertionCost, int deletionCost, int upgradeCost)
{
    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
    for (int i = 0; i <= m; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            if (i == 0)
            {
                dp[i][j] = j * insertionCost;
            }
            if (j == 0)
            {
                dp[i][j] = i * deletionCost;
            }
            if (i > 0 && j > 0)
            {
                if (currentStack[i - 1] == desiredStack[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = min({dp[i - 1][j] + deletionCost, dp[i][j - 1] + insertionCost, dp[i - 1][j - 1] + upgradeCost});
                }
            }
        }
    }
    return dp[m][n];
}
int main()
{
    string currentStack, desiredStack;
    cout << "Enter current tech stack : ";
    cin >> currentStack;
    cout << "Enter desired tech stack : ";
    cin >> desiredStack;
    int insertionCost, deletionCost, upgradeCost;
    cout << "Enter insertion cost , deletion cost , upgrade cost : ";
    cin >> insertionCost >> deletionCost >> upgradeCost;
    int m = currentStack.length();
    int n = desiredStack.length();
    cout << "Minimum Cost is : " << tabulation(currentStack, desiredStack, m, n, insertionCost, deletionCost, upgradeCost);
    return 0;
}