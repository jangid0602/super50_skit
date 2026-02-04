import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
discription: This program finds the length of the longest subsequence such that the difference between any two adjacent elements is exactly K.
author: Aman Jeet Singh
*/

public class PlacementMarathon {

    static int maxSubsequenceLength(int size, int diff, int[] skills) {
        Map<Integer, Integer> lenUp = new HashMap<>();
        Map<Integer, Integer> lenDown = new HashMap<>();
        int best = 1;

        for (int i = 0; i < size; i++) {
            int val = skills[i];

            if (diff == 0) {
                int prev = lenUp.getOrDefault(val, 0);
                int newLen = 1 + prev;
                lenUp.put(val, newLen);
                best = Math.max(best, newLen);
            } else {
                int prevUp = lenUp.getOrDefault(val - diff, 0);
                int newUp = 1 + prevUp;
                lenUp.put(val, Math.max(lenUp.getOrDefault(val, 0), newUp));

                int prevDown = lenDown.getOrDefault(val + diff, 0);
                int newDown = 1 + prevDown;
                lenDown.put(val, Math.max(lenDown.getOrDefault(val, 0), newDown));

                best = Math.max(best, Math.max(newUp, newDown));
            }
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of students N: ");
        int size = scan.nextInt();
        System.out.print("Enter required difference K: ");
        int diff = scan.nextInt();
        int[] skills = new int[size];
        System.out.print("Enter skill levels (space separated): ");
        for (int i = 0; i < size; i++) {
            skills[i] = scan.nextInt();
        }

        System.out.println();
        System.out.println("N: " + size + ", K: " + diff);
        System.out.print("Array A: ");
        for (int i = 0; i < size; i++) {
            System.out.print(skills[i]);
            if (i < size - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("Maximum subsequence length: " + maxSubsequenceLength(size, diff, skills));
        scan.close();
    }
}
