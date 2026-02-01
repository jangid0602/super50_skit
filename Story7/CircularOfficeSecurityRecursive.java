import java.util.Arrays;

/**
 * @Filename- CircularOfficeSecurityRecursive.java
 * @Description- In this we want to pick cabins to audit, but you cannot audit two adjacent cabins. Since it's
a circle, the first and last cabins are also adjacent.
 * @Author- Arman Agrawal
 */



public class CircularOfficeSecurityRecursive {

    static int[] cabinValues;
    static int[] memo;
    static int startIndex;

    static int solveLinear(int currentIndex) {

        if (currentIndex < startIndex) {
            return 0;
        }

        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }

        int takeCurrent =
                cabinValues[currentIndex]
                + solveLinear(currentIndex - 2);

        int skipCurrent =
                solveLinear(currentIndex - 1);

        memo[currentIndex] =
                Math.max(takeCurrent, skipCurrent);

        return memo[currentIndex];
    }

    static int maximizeAuditValueCircular(int[] values) {

        int numberOfCabins = values.length;
        cabinValues = values;

        if (numberOfCabins == 1) {
            return cabinValues[0];
        }

        if (numberOfCabins == 2) {
            return Math.max(cabinValues[0], cabinValues[1]);
        }

        startIndex = 0;
        memo = new int[numberOfCabins];
        Arrays.fill(memo, -1);
        int excludeLast =
                solveLinear(numberOfCabins - 2);

        startIndex = 1;
        memo = new int[numberOfCabins];
        Arrays.fill(memo, -1);
        int excludeFirst =
                solveLinear(numberOfCabins - 1);

        return Math.max(excludeLast, excludeFirst);
    }

    public static void main(String[] args) {

        System.out.print("Enter number of cabins: ");
        int numberOfCabins = InputUtil.readInt();

        int[] values = new int[numberOfCabins];

        System.out.println("Enter cabin values:");
        for (int i = 0; i < numberOfCabins; i++) {
            values[i] = InputUtil.readInt();
        }

        int result = maximizeAuditValueCircular(values);

        System.out.println(
                "Maximum audited value: " + result
        );
    }
}
