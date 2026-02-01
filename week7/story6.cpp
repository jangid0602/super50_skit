/**
 * @filename - story6.cpp
 * @description - Ad Placement
 * @author - Fatimi Bee
 */

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int totalTime, numberOfAds;

    cout << "Enter total video time (T in seconds): ";
    cin >> totalTime;

    cout << "Enter number of ads (M): ";
    cin >> numberOfAds;

    vector<pair<int, int>> adList(numberOfAds);

    cout << "Enter each ad's duration and profit:\n";
    cout << "Format: duration profit\n";

    for (int i = 0; i < numberOfAds; i++)
    {
        cout << "Ad " << i + 1 << ": ";
        cin >> adList[i].first >> adList[i].second;
    }

    vector<int> maxProfitDP(totalTime + 1, 0);

    for (auto &ad : adList)
    {
        int adDuration = ad.first;
        int initialProfit = ad.second;

        int currentProfit = initialProfit;

        while (currentProfit > 0)
        {

            for (int timeUsed = totalTime; timeUsed >= adDuration; timeUsed--)
            {
                maxProfitDP[timeUsed] = max(
                    maxProfitDP[timeUsed],
                    maxProfitDP[timeUsed - adDuration] + currentProfit);
            }

            currentProfit = currentProfit / 2;
        }
    }

    cout << "\nMaximum profit that can be earned: "
         << maxProfitDP[totalTime] << endl;

    return 0;
}
