import java.util.List;
import java.util.ArrayList;


/**
 * @Filename- SecureVault.java
 * @Description- In this we check if a vault can open or not . A vault requires a 3-digit code using the numbers {1, 2, 3} without repetition
 * @Author- Arman Agrawal
 */



public class SecureVault {

    public static void generateCodes(
            int[] digits,
            boolean[] used,
            List<Integer> currentCode,
            List<List<Integer>> allCodes) {

        if (currentCode.size() == digits.length) {
            allCodes.add(new ArrayList<>(currentCode));
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentCode.add(digits[i]);

                generateCodes(digits, used, currentCode, allCodes);

                currentCode.remove(currentCode.size() - 1);
                used[i] = false;
            }
        }
    }
}
