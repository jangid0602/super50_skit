import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Filename-TheSpyCipher.java
 * @Description-This program identifies the extra character that was added to an original
 *                   string to create a scrambled version. It uses a HashMap to maintain
 *                   character frequency counts, first counting all characters in the scrambled
 *                   string, then subtracting counts from the original string. The character
 *                   with a remaining count of 1 is identified as the extra character added
 *                   to the original string.
 * @Author- Aman Jeet Singh
 */
public class TheSpyCipher {
    public static char compare(String original, String scrambled) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : scrambled.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (char ch : original.toCharArray()) {
            frequency.put(ch, frequency.get(ch) - 1);
        }
        char extra = '\0';
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                extra = entry.getKey();
                break;
            }
        }
        return extra;
    }

    /**
     * Safely reads a non-empty string from the scanner, prompting user until valid input is provided.
     */
    private static String readString(Scanner scanner) {
        String input = scanner.next().trim();
        while (input.isEmpty()) {
            System.out.println("Invalid input! Please enter a non-empty string.");
            input = scanner.next().trim();
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original string: ");
        String original = readString(scanner);
        System.out.print("Enter the scrambled string: ");
        String scrambled = readString(scanner);

        char extra = compare(original, scrambled);
        // According to third test case in the question, adding condition to output: if
        // there is no extra character added

        System.out.println(extra != '\0' ? "The extra character that is added to original string is: " + extra
                : "No extra character found");
        scanner.close();
    }
}