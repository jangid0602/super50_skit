
/**
 * @Filename- MazeRunner.java
 * @Description- In this we check that if a rat can move out of the maze if he can only go right and down
 * @Author- Arman Agrawal
 */




public class MazeRunner {

    public static boolean isPathExists(int[][] maze, int row, int col) {
        int size = maze.length;

        if (row == size - 1 && col == size - 1) {
            return true;
        }

        if (row >= size || col >= size || maze[row][col] == 0) {
            return false;
        }

        return isPathExists(maze, row + 1, col)
            || isPathExists(maze, row, col + 1);
    }
}
