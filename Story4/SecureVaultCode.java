
/**
 
 * Description- A vault requires a 3-digit code using the numbers {1, 2, 3} without
 repetition. Use backtracking to find all possible unique codes that can
 be formed using these digits.
 * Author -Mayank Rathore
 */
import java.util.ArrayList;


public class SecureVaultCode {
    static ArrayList<String> result = new ArrayList<>();

    static void permute(int[] nums, boolean[] used, String code) {

        // base case: code length = 3
        if (code.length() == nums.length) {
            result.add(code);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            permute(nums, used, code + nums[i]);
            used[i] = false;
        }
    }
    public static void main(String[] args) {

        Input input=new Input();
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter digit " + (i + 1) + ": ");
            digits[i] = input.inputInteger();
        }

        boolean[] used = new boolean[3];

        permute(digits, used, "");

        System.out.println("\nAll possible vault codes:");
        System.out.println(result);


    }

}
