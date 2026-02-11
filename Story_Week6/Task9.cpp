/**
 * @filename: Task9.cpp
 * @description: Minimum Cost Path in Weighted Grid
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

class MinimumCostPathFinder
{
public:
    int findMinimumCost(vector<vector<int>> &grid)
    {
        int rows = grid.size();
        int columns = grid[0].size();

        // Special case: single cell
        if (rows == 1 && columns == 1)
            return grid[0][0];

        vector<vector<int>> minimumCost(
            rows, vector<int>(columns, INT_MAX));

        minimumCost[0][0] = grid[0][0];

        // Min-heap: (currentCost, row, col)
        priority_queue<
            vector<int>,
            vector<vector<int>>,
            greater<vector<int>>>
            minHeap;

        minHeap.push({grid[0][0], 0, 0});

        int directionRow[4] = {-1, 1, 0, 0};
        int directionCol[4] = {0, 0, -1, 1};

        while (!minHeap.empty())
        {
            int currentCost = minHeap.top()[0];
            int currentRow = minHeap.top()[1];
            int currentCol = minHeap.top()[2];
            minHeap.pop();

            if (currentRow == rows - 1 &&
                currentCol == columns - 1)
                return currentCost;

            for (int i = 0; i < 4; i++)
            {
                int nextRow = currentRow + directionRow[i];
                int nextCol = currentCol + directionCol[i];

                if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < columns)
                {
                    int newCost =
                        currentCost + grid[nextRow][nextCol];

                    if (newCost < minimumCost[nextRow][nextCol])
                    {
                        minimumCost[nextRow][nextCol] = newCost;
                        minHeap.push(
                            {newCost, nextRow, nextCol});
                    }
                }
            }
        }

        return -1; // should not happen
    }
};

int main()
{
    int rows, columns;
    cout << "Enter rows and columns: ";
    cin >> rows >> columns;

    vector<vector<int>> grid(rows,
                             vector<int>(columns));

    cout << "Enter grid values:\n";
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < columns; j++)
            cin >> grid[i][j];

    MinimumCostPathFinder finder;
    cout << "Minimum Cost Path: "
         << finder.findMinimumCost(grid);

    return 0;
}