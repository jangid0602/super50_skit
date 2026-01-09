/**
 * Filename- Mazerunner.java
 * Description- A mouse is in a $N \times N$ grid maze. It starts at $(0,0)$ and needs 
to reach $(N-1, N-1)$. The mouse can only move Down or Right. Some 
cells are blocked (0) and some are open (1). Find if a path exists.
 * Author - Nancy Jain
 * Date - 07/01/2026
 */
package tasks;

public class MazeRunner {
    public static boolean path(int[][] maze){
        int size = maze.length;
        return solve(maze, 0, 0, size);
    }
    public static boolean solve(int[][] maze, int i, int j , int size){
        if( i < 0 || j < 0 || i >= size || j >= size || maze[i][j]==0) return false;
        if( i == size - 1 && j == size - 1) return true;
        maze[i][j] = 0;
        if(solve(maze , i , j+1, size) || solve(maze , i+1 , j , size)) return true;

        maze[i][j]=1;
        return false; 
    }
}
