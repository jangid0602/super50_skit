import java.util.Scanner;

/**
 * Checks if a valid path exists from top-left to bottom-right corner of a maze.
 * Can only move right or down. 1 = open cell, 0 = blocked cell.
 * 
 * @author Aman Jeet Singh
 */
public class MazeRunner {

    /**
     * Recursively checks if a path exists from current position to destination.
     * 
     * @param mazeGrid The 2D maze grid (1 = open, 0 = blocked)
     * @param currentRow Current row position
     * @param currentColumn Current column position
     * @param mazeSize Size of the square maze
     * @return true if path exists, false otherwise
     */
    public static boolean isPathExists(int[][] mazeGrid, int currentRow, int currentColumn, int mazeSize) {
        // Base case: out of bounds or blocked cell
        if (currentRow < 0 || currentColumn < 0 || currentRow >= mazeSize || 
            currentColumn >= mazeSize || mazeGrid[currentRow][currentColumn] == 0) {
            return false;
        }

        // Base case: reached destination (bottom-right corner)
        if (currentRow == mazeSize - 1 && currentColumn == mazeSize - 1) {
            return true;
        }

        // Mark current cell as visited to avoid cycles
        mazeGrid[currentRow][currentColumn] = 0;

        // Try moving right
        if (isPathExists(mazeGrid, currentRow, currentColumn + 1, mazeSize)) {
            return true;
        }

        // Try moving down
        if (isPathExists(mazeGrid, currentRow + 1, currentColumn, mazeSize)) {
            return true;
        }

        // No path found from current position
        return false;
    }

    /**
     * Main method to interact with user and check if path exists.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int mazeSize = 0;

        // Input validation: get maze size
        while (true) {
            try {
                System.out.print("Enter maze size (N): ");
                mazeSize = inputScanner.nextInt();

                if (mazeSize <= 0) {
                    System.out.println("Size must be positive!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Enter integer value.");
                inputScanner.nextLine();
            }
        }

        int[][] mazeGrid = new int[mazeSize][mazeSize];

        // Collect maze configuration from user
        System.out.println("Enter maze values (1 = open, 0 = blocked):");
        for (int rowIndex = 0; rowIndex < mazeSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < mazeSize; columnIndex++) {
                while (true) {
                    try {
                        mazeGrid[rowIndex][columnIndex] = inputScanner.nextInt();
                        if (mazeGrid[rowIndex][columnIndex] != 0 && mazeGrid[rowIndex][columnIndex] != 1) {
                            System.out.println("Enter only 0 or 1!");
                            continue;
                        }
                        break;
                    } catch (Exception inputException) {
                        System.out.println("Invalid input! Enter 0 or 1.");
                        inputScanner.nextLine();
                    }
                }
            }
        }

        // Check if starting position is blocked
        if (mazeGrid[0][0] == 0) {
            System.out.println("Output: False");
        } else {
            boolean pathExists = isPathExists(mazeGrid, 0, 0, mazeSize);
            System.out.println("Output: " + pathExists);
        }

        inputScanner.close();
    }
}
