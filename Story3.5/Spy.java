import java.util.Scanner;

/**
 * @filename - ListPartition.java
 * @description - task is to identify and return that extra character.
 * @author - Anushka Kumawat
 **/

class Solve {
    String original;
    String scrambled;

    Solve(String original, String scrambled) {
        this.original = original;
        this.scrambled = scrambled;
    }

    char Cipher() {
        int n = original.length();
        int m = scrambled.length();

        if (m != n + 1)
            return '-';

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans ^= original.charAt(i);
        }
        for (int i = 0; i < m; i++) {
            ans ^= scrambled.charAt(i);
        }

        return (char) ans;
    }
}

public class Spy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter original string");
        String original = scanner.nextLine();

        System.out.println("Enter scrambled string");
        String scrambled = scanner.nextLine();

        Solve s = new Solve(original, scrambled);
        char ans = s.Cipher();
        System.out.println(ans == '-' ? "Invalid input" : ans);

        scanner.close();
    }
}
