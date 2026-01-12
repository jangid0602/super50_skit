/**
 * @filename - Task-6.cpp
 * @description - The Perfect Team Assembly
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

void generateSubsets(int index, vector<string> &arr,
                     vector<string> &current,
                     vector<vector<string>> &result)
{
    // base case
    if (index == arr.size())
    {
        result.push_back(current);
        return;
    }

    // exclude current element
    generateSubsets(index + 1, arr, current, result);

    // include current element
    current.push_back(arr[index]);
    generateSubsets(index + 1, arr, current, result);
    current.pop_back(); // backtrack
}

int main()
{
    int n;
    cin >> n;

    vector<string> devs(n);
    for (int i = 0; i < n; i++)
    {
        cin >> devs[i];

        vector<vector<string>> result;
        vector<string> current;

        generateSubsets(0, devs, current, result);

        cout << "[";
        for (int i = 0; i < result.size(); i++)
        {
            cout << "[";
            for (int j = 0; j < result[i].size(); j++)
            {
                cout << "\"" << result[i][j] << "\"";
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
}
