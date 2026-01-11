import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @Filename-SecureVaultCode.java
 * @Description-Generates all unique vault codes using backtracking
 * @Author-Aditya Virmani
 */
public class SecureVaultCode {

    static void generatePermutations(int index, List<List<Integer>> allCodes, List<Integer> digits) {

        if (index == digits.size()) {
            allCodes.add(new ArrayList<>(digits));
            return;
        }

        HashSet<Integer> usedDigits = new HashSet<>();

        for (int i = index; i < digits.size(); i++) {

            if (usedDigits.contains(digits.get(i)))
                continue;

            usedDigits.add(digits.get(i));

            swap(digits, i, index);
            generatePermutations(index + 1, allCodes, digits);
            swap(digits, i, index);
        }
    }

    static void swap(List<Integer> list, int i, int j) {
        int swapVariable = list.get(i);
        list.set(i, list.get(j));
        list.set(j, swapVariable);
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int numberOfDigits = 0;

        while (true) {
            try {
                System.out.print("Enter number of digits: ");
                numberOfDigits = userInput.nextInt();

                if (numberOfDigits <= 0) {
                    System.out.println("Number must be positive!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter an integer.");
                userInput.nextLine();
            }
        }

        List<Integer> digits = new ArrayList<>();

        System.out.println("Enter digits:");
        for (int i = 0; i < numberOfDigits; i++) {
            int digit;
            while (true) {
                try {
                    digit = userInput.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Enter an integer.");
                    userInput.nextLine();
                }
            }
            digits.add(digit);
        }

        List<List<Integer>> allCodes = new ArrayList<>();

        generatePermutations(0, allCodes, digits);

        System.out.println("\nAll Possible Unique Vault Codes:");
        for (List<Integer> code : allCodes) {
            for (int digit : code) {
                System.out.print(digit);
            }
            System.out.print(" ");
        }

        userInput.close();
    }
}
