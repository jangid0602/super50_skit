import java.util.*;
/**
 * @Filename- GridShortestPath.java
 * @Description- This is to find the minimum cost path from top-left to bottom-right.
 * @Author- Kripendra
 */
public class GridShortestPath {
    public static int minCostPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int[][] dist = new int[rows][cols];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Starting point
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});

        // Direction vectors for 4-way movement
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];


            if (r == rows - 1 && c == cols - 1) return cost;


            if (cost > dist[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check boundaries
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int nextCost = cost + grid[nr][nc];
                    if (nextCost < dist[nr][nc]) {
                        dist[nr][nc] = nextCost;
                        pq.offer(new int[]{nr, nc, nextCost});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Input input = new Input();

        System.out.print("Enter number of rows: ");
        int r = input.inputInteger();
        System.out.print("Enter number of columns: ");
        int c = input.inputInteger();

        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Cost for cell [" + i + "][" + j + "]: ");
                grid[i][j] = input.inputInteger();
            }
        }

        int result = minCostPath(grid);
        System.out.println("Minimum cost to reach bottom-right: " + result);
    }
}