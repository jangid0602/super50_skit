/**
 * @filename - story9.cpp
 * @description - Minimum Weighted Path in grid
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

vector<int> row = {-1, 1, 0, 0};
vector<int> column = {0, 0, -1, 1};
int answer = INT_MAX;

void dfsSolution(vector<vector<int>> &grid, int gridSize, int startRow, int startColumn, vector<vector<bool>> &visit, int currentSum)
{
    visit[startRow][startColumn] = true;
    currentSum += grid[startRow][startColumn];

    if (startRow == gridSize - 1 && startColumn == gridSize - 1)
    {
        answer = min(currentSum, answer);
        visit[startRow][startColumn] = false;
        return;
    }
    for (int i = 0; i < 4; i++)
    {
        int nextRow = startRow + row[i];
        int nextColumn = startColumn + column[i];

        if (nextRow < 0 || nextColumn < 0 || nextRow >= gridSize || nextColumn >= gridSize || visit[nextRow][nextColumn])
        {
            continue;
        }
        dfsSolution(grid, gridSize, nextRow, nextColumn, visit, currentSum);
    }
    visit[startRow][startColumn] = false;
}
int main()
{
    int gridSize;
    cout << "Enter the gridSize : ";
    cin >> gridSize;

    vector<vector<int>> grid(gridSize, vector<int>(gridSize));
    for (int i = 0; i < gridSize; i++)
    {
        for (int j = 0; j < gridSize; j++)
        {
            cout << "Enter element at " << i + 1 << " row " << j + 1 << " column : ";
            cin >> grid[i][j];
        }
    }
    vector<vector<bool>> visit(gridSize, vector<bool>(gridSize, false));
    dfsSolution(grid, gridSize, 0, 0, visit, 0);
    cout << "Minimum cost path from top left corner to bottom right corner : " << answer << endl;
}