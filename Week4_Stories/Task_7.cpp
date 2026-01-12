/**
 * @filename - Task-7.cpp
 * @description -  Permutation
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

void generatePermutations(vector<int> &nums, vector<bool> &used,
                          vector<int> &current, vector<int> &result)
{

    if (current.size() == nums.size())
    {
        int code = 0;
        for (int d : current)
        {
            code = code * 10 + d;
        }
        result.push_back(code);
        return;
    }

    for (int i = 0; i < nums.size(); i++)
    {
        if (!used[i])
        {
            used[i] = true;
            current.push_back(nums[i]);

            generatePermutations(nums, used, current, result);

            current.pop_back();
            used[i] = false;
        }
    }
}

int main()
{
    int n;
    cin >> n;

    vector<int> nums(n);
    for (int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    vector<bool> used(n, false);
    vector<int> current;
    vector<int> result;

    generatePermutations(nums, used, current, result);

    cout << "[";
    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i];
        if (i + 1 < result.size())
            cout << ", ";
    }
    cout << "]";

    return 0;
}
