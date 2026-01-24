import java.util.*;

/**
 * @Filename- MinimumCostPathInGrid.java
 * @Description- This is to find the minimum cost path from top-left to bottom-right
 * @Author- Aman Jeet Singh
 */
public class MinimumCostPathInGrid {

    private static final int[] ROW_DIR = {1, -1, 0, 0};
    private static final int[] COL_DIR = {0, 0, 1, -1};

    public static int minCostPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] minimumCost = new int[rows][cols];
        for (int[] row : minimumCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minimumHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minimumCost[0][0] = grid[0][0];
        minimumHeap.offer(new int[]{grid[0][0], 0, 0});

        while (!minimumHeap.isEmpty()) {
            int[] state = minimumHeap.poll();
            int currentCost = state[0];
            int row = state[1];
            int col = state[2];

            if (row == rows - 1 && col == cols - 1) {
                return currentCost;
            }

            if (currentCost > minimumCost[row][col]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + ROW_DIR[i];
                int newCol = col + COL_DIR[i];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    int newCost = currentCost + grid[newRow][newCol];

                    if (newCost < minimumCost[newRow][newCol]) {
                        minimumCost[newRow][newCol] = newCost;
                        minimumHeap.offer(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int rows = InputUtil.getInt("Enter number of rows: ");
        int cols = InputUtil.getInt("Enter number of columns: ");

        int[][] grid = new int[rows][cols];

        System.out.println("Enter grid values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = InputUtil.getInt("grid[" + i + "][" + j + "]: ");
            }
        }

        int result = minCostPath(grid);
        System.out.println("Minimum Cost Path: " + result);
    }
}
