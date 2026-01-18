import java.util.Scanner;

/**
 * @filename - MazeRunner.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Solution {
    boolean findPath(int[][] maze, int i, int j, int n) {

        if (i == n - 1 && j == n - 1 && maze[i][j] == 1) {
            return true;
        }
        if (i < n && j < n && maze[i][j] == 1) {

            if (findPath(maze, i + 1, j, n)) {
                return true;
            }
            if (findPath(maze, i, j + 1, n)) {
                return true;
            }
        }

        return false;
    }
}

public class MazeRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();

        System.out.print("Enter size N: ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter the maze (1 for open, 0 for blocked):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        boolean result = s.findPath(maze, 0, 0, n);

        if (result)
            System.out.println("True");
        else
            System.out.println("False");

        sc.close();
    }
}
