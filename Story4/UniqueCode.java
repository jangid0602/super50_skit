package Oneup.Story5;

import java.util.List;

public class UniqueCode{

    static void generate(int[] arr, boolean[] used, String code) {

        // If code length equals array length, print it
        if (code.length() == arr.length) {
            System.out.println(code);
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i])
                continue;

            used[i] = true;
            generate(arr, used, code + arr[i]);
            used[i] = false; // backtrack
        }
    }
    public void findCombinations(int[] arr, int budget, int index,
                                 List<Integer> current) {

        // If target achieved
        if ( budget == 0) {
            System.out.println(current);
            return;
        }

        // If target becomes negative or index out of bounds
        if ( budget < 0 || index == arr.length)
            return;

        // Choice 1: Include current element
        current.add(arr[index]);
        findCombinations(arr, budget - arr[index], index + 1, current);

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: Exclude current element
        findCombinations(arr,  budget, index + 1, current);
    }
}
