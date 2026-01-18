import java.util.Scanner;

/**
 * @Filename-MazeRunner.java
 * @Description-Checks if a path exists in a maze using backtracking
 * @Author-Aditya Virmani
 */
public class MazeRunner {

    static boolean isPathExists(int[][] maze, int row, int column, int size) {

        if (row < 0 || column < 0 || row >= size || column >= size || maze[row][column] == 0)
            return false;

        if (row == size - 1 && column == size - 1)
            return true;

        maze[row][column] = 0;

        if (isPathExists(maze, row, column + 1, size))
            return true;

        if (isPathExists(maze, row + 1, column, size))
            return true;

        return false;
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int size = 0;

        while (true) {
            try {
                System.out.print("Enter maze size (N): ");
                size = userInput.nextInt();

                if (size <= 0) {
                    System.out.println("Size must be positive!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter integer value.");
                userInput.nextLine();
            }
        }

        int[][] maze = new int[size][size];

        System.out.println("Enter maze values (1 = open, 0 = blocked):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                while (true) {
                    try {
                        maze[i][j] = userInput.nextInt();
                        if (maze[i][j] != 0 && maze[i][j] != 1) {
                            System.out.println("Enter only 0 or 1!");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input! Enter 0 or 1.");
                        userInput.nextLine();
                    }
                }
            }
        }

        if (maze[0][0] == 0) {
            System.out.println("Output: False");
        } else {
            boolean pathExists = isPathExists(maze, 0, 0, size);
            System.out.println("Output: " + pathExists);
        }

        userInput.close();
    }
}
