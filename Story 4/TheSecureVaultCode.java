/**
 * <p>This class solves The Secure Vault Code  problem using recursion and backtracking (combination Sum)</p>
 *
 * @Author- Aaditya Jain
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheSecureVaultCode {

    static void backtrack(int[] digits, boolean[] used,
                          StringBuilder current, List<String> result) {

        if (current.length() == digits.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (used[i]) continue;
            used[i] = true;
            current.append(digits[i]);

            backtrack(digits, used, current, result);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        Scanner scannerobj = new Scanner(System.in);

        System.out.print("Enter number of digits: ");
        int size = scannerobj.nextInt();

        int[] digits = new int[size];

        System.out.println("Enter the digits:");
        for (int i = 0; i < size; i++) {
            digits[i] = scannerobj.nextInt();
        }

        boolean[] used = new boolean[size];
        List<String> result = new ArrayList<>();

        backtrack(digits, used, new StringBuilder(), result);

        System.out.println("All possible unique vault codes:");
        System.out.println(result);

        scannerobj.close();
    }
}
