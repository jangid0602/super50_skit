public class Maze {

    static boolean isPath(int[][] maze, int row, int col) {
        int n = maze.length;

        // Base Case: reached destination
        if (row == n - 1 && col == n - 1 && maze[row][col] == 1) {
            return true;
        }

        // Check bounds and blocked cells
        if (row >= n || col >= n || maze[row][col] == 0) {
            return false;
        }

        // Move Right
        if (isPath(maze, row, col + 1)) {
            return true;
        }

        // Move Down
        if (isPath(maze, row + 1, col)) {
            return true;
        }

        // Backtrack
        return false;
    }
}
