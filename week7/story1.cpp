/**
 * @filename - story1.cpp
 * @description - Startup revenue Maxima
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;
int memoization(vector<int> &revenue, int days, int index, vector<int> &dp)
{
    if (index >= days)
        return 0;
    if (dp[index] != -1)
        return dp[index];

    int rest = memoization(revenue, days, index + 1, dp);
    int work = memoization(revenue, days, index + 2, dp) + (((index + 1) % 7 == 0) ? 2 * revenue[index] : revenue[index]);

    return dp[index] = max(rest, work);
}
int main()
{
    int days;
    cout << "Enter number of days: ";
    cin >> days;
    vector<int> revenue(days);
    cout << "Enter revenue for " << days << " days: ";
    for (int i = 0; i < days; i++)
    {
        cin >> revenue[i];
    }
    vector<int> dp(days, -1);
    cout << "Maximum revenue is : " << memoization(revenue, days, 0, dp);
    return 0;
}