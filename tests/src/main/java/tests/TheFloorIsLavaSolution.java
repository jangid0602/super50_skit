import java.util.Scanner;

public class TheFloorIsLavaSolution {
    private static int getLongestStablePath(int[] heights, int k) {
        int len = heights.length;
        if (len == 1) return 1;
        int[] differences = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            differences[i] = heights[i + 1] - heights[i];
        }
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        for (int difference : differences) {
            if (difference <= k) count++;
            else {
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in heights: ");
        int n = scanner.nextInt();
        int[] heights = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        System.out.print("Enter value of k: ");
        int k = scanner.nextInt();
        int longestPath = getLongestStablePath(heights, k);
        System.out.println("Longest path is " + longestPath);
    }
}


// Node swap
// Oxygen Tank
// 32