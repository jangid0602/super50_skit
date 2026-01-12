/**
 * @filename - Task-9.cpp
 * @description - Combination Sum
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

void findCombinations(int index, vector<int> &prices, int target,
                      vector<int> &current, vector<vector<int>> &result)
{
    if (target == 0)
    {
        result.push_back(current);
        return;
    }

    if (index == prices.size() || target < 0)
        return;

    current.push_back(prices[index]);
    findCombinations(index, prices, target - prices[index], current, result);
    current.pop_back();

    findCombinations(index + 1, prices, target, current, result);
}

int main()
{
    int n;
    cin >> n;

    vector<int> prices(n);
    for (int i = 0; i < n; i++)
        cin >> prices[i];

    int budget;
    cin >> budget;

    vector<vector<int>> result;
    vector<int> current;

    findCombinations(0, prices, budget, current, result);

    cout << "[";
    for (int i = 0; i < result.size(); i++)
    {
        cout << "[";
        for (int j = 0; j < result[i].size(); j++)
        {
            cout << result[i][j];
            if (j + 1 < result[i].size())
                cout << ", ";
        }
        cout << "]";
        if (i + 1 < result.size())
            cout << ", ";
    }
    cout << "]";

    return 0;
}
