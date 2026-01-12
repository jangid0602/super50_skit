/**
 * @filename - Task-5.cpp
 * @description - The Maze Runner
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

bool solve(int i, int j, vector<vector<int>> &maze, int n)
{

    if (i == n - 1 && j == n - 1 && maze[i][j] == 1)
        return true;

    if (i < n && j < n && maze[i][j] == 1)
    {

        if (solve(i, j + 1, maze, n))
            return true;

        if (solve(i + 1, j, maze, n))
            return true;
    }
    return false;
}

int main()
{
    int n;
    cin >> n;

    vector<vector<int>> maze(n, vector<int>(n));

    // input maze
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> maze[i][j];
        }
    }

    if (maze[0][0] == 0)
    {
        cout << "False";
        return 0;
    }

    cout << (solve(0, 0, maze, n) ? "True" : "False");
    return 0;
}
