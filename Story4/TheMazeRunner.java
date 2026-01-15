/**
 
 * Description- A mouse is in a $N \times N$ grid maze. It starts at $(0,0)$ and needs 
to reach $(N-1, N-1)$. The mouse can only move Down or Right. Some 
cells are blocked (0) and some are open (1). Find if a path exists.
 * Author - Naval
 */
import java.util.Scanner;

public class TheMazeRunner {

    public static boolean isPathExists(int[][] maze, int n) {
        return backtrack(maze, 0, 0, n);
    }

    private static boolean backtrack(int[][] maze, int row, int col, int n) {
        if (row >= n || col >= n || maze[row][col] == 0) {
            return false;
        }
        if (row == n - 1 && col == n - 1) {
            return true;
        }
        return backtrack(maze, row, col + 1, n) ||
                backtrack(maze, row + 1, col, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maze size (N): ");
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        System.out.println("Enter maze (0 = blocked, 1 = open):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }


        boolean result = isPathExists(maze, n);
        System.out.println("Path exists: " + result);

        sc.close();
    }
}


