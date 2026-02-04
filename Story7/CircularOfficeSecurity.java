import java.util.Scanner;
/*
discription: This program selects cabins in a circle (no two adjacent, including first and last) to maximize total value audited.
author: Aman Jeet Singh
*/

public class CircularOfficeSecurity {

    static long maxLinear(long[] value, int start, int end) {
        if (start > end) return 0;
        int len = end - start + 1;
        if (len == 1) return value[start];
        long prevTwo = 0;
        long prevOne = value[start];
        for (int i = start + 1; i <= end; i++) {
            long take = value[i] + prevTwo;
            long skip = prevOne;
            long curr = Math.max(take, skip);
            prevTwo = prevOne;
            prevOne = curr;
        }
        return prevOne;
    }

    static long maxAuditValue(int size, long[] value) {
        if (size == 1) return value[0];
        long skipFirst = maxLinear(value, 1, size - 1);
        long skipLast = maxLinear(value, 0, size - 2);
        return Math.max(skipFirst, skipLast);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of cabins N: ");
        int size = scan.nextInt();
        long[] value = new long[size];
        System.out.print("Enter value per cabin (space separated): ");
        for (int i = 0; i < size; i++) {
            value[i] = scan.nextLong();
        }

        System.out.println();
        System.out.println("N: " + size);
        System.out.print("V: ");
        for (int i = 0; i < size; i++) {
            System.out.print(value[i]);
            if (i < size - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("Maximum audit value: " + maxAuditValue(size, value));
        scan.close();
    }
}
