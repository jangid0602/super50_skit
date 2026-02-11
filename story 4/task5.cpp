/**
 * @filename - Task5.cpp
 * @description -  The Maze Runner (Backtracking)
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;

bool findPath(vector<vector<int>>& grid, int row, int col, vector<vector<int>>& visited) {
    int totalRows = grid.size();
    int totalCols = grid[0].size();

    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || 
        grid[row][col] == 0 || visited[row][col]) {
        return false;
    }

    visited[row][col] = 1;

    if (row == totalRows - 1 && col == totalCols - 1) return true;

    if (findPath(grid, row + 1, col, visited)) return true;
    if (findPath(grid, row, col + 1, visited)) return true;

    visited[row][col] = 0;
    return false;
}

int main() {
    int rows, cols;
    cout << "Enter rows of matrix: ";
    cin >> rows;
    cout << "Enter columns of matrix: ";
    cin >> cols;

    vector<vector<int>> grid(rows, vector<int>(cols));
    vector<vector<int>> visited(rows, vector<int>(cols, 0));

    cout << "Enter elements of matrix (0 or 1) of size " << rows << "X" << cols << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> grid[i][j];
        }
    }

    if (findPath(grid, 0, 0, visited)) {
        cout << "Path exists\n";
    } else {
        cout << "Path doesn't exist\n";
    }

    return 0;
}
