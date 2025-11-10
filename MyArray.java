import java.util.*;

public class MyArray {
    public static int findFarthestCity(int[] energyCost, int initialEnergy) {
        if (energyCost == null || energyCost.length == 0) return -1;
        int remainingEnergy = initialEnergy;
        for (int i = 0; i < energyCost.length; i++) {
            remainingEnergy -= energyCost[i];
            if (remainingEnergy < 0) return i - 1;
        }
        return energyCost.length - 1;
    }

    public static int findBalancedIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            long leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) leftSum += nums[j];
            for (int j = i + 1; j < nums.length; j++) rightSum += nums[j];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    public static int findMinimumFlips(int[] nums) {
        if (nums == null) return -1;
        int countZeros = 0, countOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZeros++;
            else if (nums[i] == 1) countOnes++;
            else return -1;
        }
        return Math.min(countZeros, countOnes);
    }

    public static int findUniqueElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            boolean unique = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    unique = false;
                    break;
                }
            }
            if (unique) return nums[i];
        }
        return -1;
    }

    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = (long) nums[i] + (long) nums[j];
                if (sum == target) return true;
            }
        }
        return false;
    }

    public static int getMinimumPaintingTime(int[] times) {
        if (times == null || times.length == 0) return 0;
        if (times.length == 1) return times[0];
        long total = 0;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            total += times[i];
            if (times[i] > maxTime) maxTime = times[i];
        }
        long other = total - maxTime;
        long answer = Math.max((long) maxTime, other);
        return (int) answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1, 0, 0, 1, 1};
        int[] times = {4, 2, 3, 7};
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Farthest City");
            System.out.println("2. Balanced Index");
            System.out.println("3. Minimum Flips");
            System.out.println("4. Unique Element");
            System.out.println("5. Pair with Sum");
            System.out.println("6. Minimum Painting Time");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number between 0-6.");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Farthest city index: " + findFarthestCity(nums, 10));
                    break;
                case 2:
                    System.out.println("Balanced index: " + findBalancedIndex(nums));
                    break;
                case 3:
                    System.out.println("Minimum flips: " + findMinimumFlips(nums));
                    break;
                case 4:
                    System.out.println("Unique element: " + findUniqueElement(nums));
                    break;
                case 5:
                    System.out.print("Enter target sum: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid number!");
                        sc.next();
                        break;
                    }
                    int target = sc.nextInt();
                    System.out.println("Pair exists: " + hasPairWithSum(nums, target));
                    break;
                case 6:
                    System.out.println("Minimum total painting time: " + getMinimumPaintingTime(times));
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter between 0-6.");
            }
        }
        sc.close();
    }
}
