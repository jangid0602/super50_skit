/**
 * @filename - Story5.cpp
 * @description -  The Maze Runner
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
using namespace std;

bool findPath(vector<vector<int>> &maze, int startRow, int startCol, int endRow, int endCol)
{
    if (startRow < 0 || startCol < 0 || startRow > endRow || startCol > endCol || maze[startRow][startCol] == 0 || maze[endRow][endCol] == 0)
    {
        return false;
    }

    if (startRow == endRow && startCol == endCol)
    {
        return true;
    }

    // Move Down
    bool down = findPath(maze, startRow + 1, startCol, endRow, endCol);
    // Move right
    bool right = findPath(maze, startRow, startCol + 1, endRow, endCol);

    return down || right;
}
int main()
{
    int mazeSize;
    cout << "Enter the size of the maze: ";
    cin >> mazeSize;
    vector<vector<int>> maze(mazeSize, vector<int>(mazeSize));

    cout << "Only enter 0 for closed path and 1 for open path" << endl;
    for (int i = 0; i < mazeSize; i++)
    {
        for (int j = 0; j < mazeSize; j++)
        {
            cout << "Enter value for cell (" << i << "," << j << "): ";
            cin >> maze[i][j];
        }
    }
    cout << "maze looks like " << endl;
    for (int i = 0; i < mazeSize; i++)
    {
        for (int j = 0; j < mazeSize; j++)
        {
            cout << maze[i][j] << " ";
        }
        cout << endl;
    }

    cout << "Is there a path from start to end ? " << (findPath(maze, 0, 0, mazeSize - 1, mazeSize - 1) == true ? "True" : "False") << endl;
}