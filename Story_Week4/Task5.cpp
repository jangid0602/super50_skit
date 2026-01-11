/**
 * @filename - Task5.cpp
 * @description - The Maze Runner(backtracking)
 * @author - Ayushi Shukla
 */


#include <iostream>
using namespace std;
bool isSafe(int maze[][10], int x, int y, int n) {
    // check if x and y are within bounds and cell is open (1)
    return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
}
bool solveMazeUtil(int maze[][10], int x, int y, int n, int sol[][10]) {
    // base case: reached destination
    if (x == n - 1 && y == n - 1) {
        sol[x][y] = 1;
        return true;
    }

    // check if maze[x][y] is valid
    if (isSafe(maze, x, y, n)) {
        // mark x,y as part of solution path
        sol[x][y] = 1;

        // move forward in x direction
        if (solveMazeUtil(maze, x + 1, y, n, sol))
            return true;

        // if moving in x direction doesn't give solution then move down in y direction
        if (solveMazeUtil(maze, x, y + 1, n, sol))
            return true;

        // if none of the above movements work then BACKTRACK: unmark x,y as part of solution path
        sol[x][y] = 0;
        return false;
    }
    return false;
}
bool solveMaze(int maze[][10], int n) {
    int sol[10][10] = {0}; // solution matrix initialized to 0

    if (!solveMazeUtil(maze, 0, 0, n, sol)) {
        return false; // no solution exists
    }

    return true; // solution found
}
int main() {
    int n;
    cout << "Enter size of maze (n x n): ";
    cin >> n;

    int maze[10][10];
    cout << "Enter the maze (1 for open cell, 0 for blocked cell):\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> maze[i][j];
        }
    }

    if (solveMaze(maze, n)) {
        cout << "Path to exit exists!" << endl;
    } else {
        cout << "No path to exit exists." << endl;
    }

    return 0;
}
