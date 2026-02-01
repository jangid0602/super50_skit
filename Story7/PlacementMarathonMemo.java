import java.util.HashMap;


/**
 * @Filename- PlacementMarathonMemo.java
 * @Description- This is to find the length of the longest subsequence such
that the difference between any two adjacent elements in the subsequence is exactly K.

 * @Author- Arman Agrawal
 */





public class PlacementMarathonMemo {

    static int findLongestValidSubsequence(
            int differenceK,
            int[] numbers) {

        HashMap<Integer, Integer> longestEndingAtValue = new HashMap<>();
        int maximumLength = 0;

        for (int currentValue : numbers) {

            int lengthFromLeft =
                    longestEndingAtValue.getOrDefault(
                            currentValue - differenceK, 0);

            int lengthFromRight =
                    longestEndingAtValue.getOrDefault(
                            currentValue + differenceK, 0);

            int currentBestLength =
                    1 + Math.max(lengthFromLeft, lengthFromRight);

            longestEndingAtValue.put(currentValue, currentBestLength);

            maximumLength =
                    Math.max(maximumLength, currentBestLength);
        }

        return maximumLength;
    }

    public static void main(String[] args) {

        System.out.print("Enter number of elements: ");
        int numberOfElements = InputUtil.readInt();

        System.out.print("Enter difference k: ");
        int differenceK = InputUtil.readInt();

        int[] numbers = new int[numberOfElements];

        System.out.println("Enter elements:");
        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = InputUtil.readInt();
        }

        int result =
                findLongestValidSubsequence(
                        differenceK,
                        numbers
                );

        System.out.println(
                "Length of longest valid subsequence: " + result
        );
    }
}
