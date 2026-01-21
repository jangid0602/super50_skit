#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class LongestStablePathSolver
{
public:
    int longestStablePath(vector<int> &heights, int k)
    {
        if (heights.empty())
            return 0;
        int max_len = 1;
        int curr = 1;
        for (int i = 1; i < heights.size(); ++i)
        {
            if (abs(heights[i] - heights[i - 1]) <= k)
            {
                ++curr;
            }
            else
            {
                curr = 1;
            }
            if (curr > max_len)
                max_len = curr;
        }
        return max_len;
    }
};

int main()
{
    LongestStablePathSolver solver;

    vector<int> heights1 = {1, 2, 5, 8};
    cout << "Test case 1 : " << solver.longestStablePath(heights1, 3) << "\n";

    vector<int> heights2 = {10, 20, 22, 23, 30};
    cout << "Test case 2 : " << solver.longestStablePath(heights2, 2) << "\n";

    vector<int> heights3 = {5, 15, 25};
    cout << "Test case 3 : " << solver.longestStablePath(heights3, 5) << "\n";
}