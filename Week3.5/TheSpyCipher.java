import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Filename-TheSpyCipher.java
 * @Description-This return the extra character that added to original string
 * @Author-Aditya Virmani
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the original string");
        String original = scanner.next();
        System.out.println("Enter the scrambled string");
        String scrambled = scanner.next();

        char extra = compare(original, scrambled);
        // According to third test case in the question, adding condition to output: if
        // there is no extra character added
        
        System.out.println(extra != '\0' ? "The extra charcter that is added to original string is: " + extra
                : "No extra character found");
        scanner.close();
    }
}
