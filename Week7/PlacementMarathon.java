import java.util.*;

/**
 * @Filename-PlacementMarathon.java
 * @Description-Finds the length of the longest subsequence such that the
 *                    difference between
 *                    adjacent elements is exactly K using DP with HashMap.
 * @Author-Aditya Virmani
 */

public class PlacementMarathon {

    public static int longestSubsequenceWithDifferenceK(int totalElements, int differenceK, int[] skillArray) {
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < totalElements; i++) {

            int currentSkill = skillArray[i];
            int previousSkill = currentSkill - differenceK;
            int currentLength = 1;
            if (dpMap.containsKey(previousSkill)) {
                currentLength = dpMap.get(previousSkill) + 1;
            }

            dpMap.put(currentSkill, currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of students: ");
            int totalElements = scanner.nextInt();

            System.out.print("Enter value of K: ");
            int differenceK = scanner.nextInt();

            int[] skillArray = new int[totalElements];

            System.out.println("Enter skill levels:");
            for (int i = 0; i < totalElements; i++) {
                skillArray[i] = scanner.nextInt();
            }

            int result = longestSubsequenceWithDifferenceK(totalElements, differenceK, skillArray);
            System.out.println("Maximum Length of Subsequence: " + result);

            scanner.close();

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values.");
        }
    }
}
