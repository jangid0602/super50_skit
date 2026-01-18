

/**
 * @filename   : TheMazeRunner.cpp
 * @description: A mouse is in a times N grid maze. It starts at $(0,0)$ and needs to reach (N-1, N-1).
 *  The mouse can only move Down or Right. Some cells are blocked (0) and some are open (1). Find if a path exists using backtracking.
 * @author     : Ehtesham Nawaz
 */

// Input: [[1, 0], [1, 1]]
// Output: True

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> cache;
// added caching to bring exponential time complexit from O(2^n*n) to O(n*n);
bool isPathExists(int currentRow, int currentCol, vector<vector<int>> &grid)
{
    if (currentRow < 0 || currentCol < 0)
        return false;
    if (grid[currentRow][currentCol] == 0)
        return false;
    if (currentRow == 0 && currentCol == 0)
        return true;

    if (cache[currentRow][currentCol] != -1)
        return cache[currentRow][currentCol];

    int moveUp = isPathExists(currentRow - 1, currentCol, grid);
    int moveLeft = isPathExists(currentRow, currentCol - 1, grid);
    return cache[currentRow][currentCol] = moveLeft || moveUp;
}

int main()
{
    int sizeOfGrid = 2;
    vector<vector<int>> grid = {{1, 0}, {1, 1}};

    cache.resize(sizeOfGrid, vector<int>(sizeOfGrid, -1));

    cout << (isPathExists(1, 1, grid) ? "True" : "False");

    return 0;
}
