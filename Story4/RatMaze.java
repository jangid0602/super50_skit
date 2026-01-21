package Oneup.Story5;

import java.util.*;

public class RatMaze {

    static void solve(int[][] maze, int x, int y, int n,
                      boolean[][] visited, String path, List<String> result) {

        // If destination reached
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        // Mark visited
        visited[x][y] = true;

        // D (Down)
        if (x + 1 < n && maze[x + 1][y] == 1 && !visited[x + 1][y])
            solve(maze, x + 1, y, n, visited, path + "D", result);

        // L (Left)
        if (y - 1 >= 0 && maze[x][y - 1] == 1 && !visited[x][y - 1])
            solve(maze, x, y - 1, n, visited, path + "L", result);

        // R (Right)
        if (y + 1 < n && maze[x][y + 1] == 1 && !visited[x][y + 1])
            solve(maze, x, y + 1, n, visited, path + "R", result);

        // U (Up)
        if (x - 1 >= 0 && maze[x - 1][y] == 1 && !visited[x - 1][y])
            solve(maze, x - 1, y, n, visited, path + "U", result);

        // Backtrack
        visited[x][y] = false;
    }

}
