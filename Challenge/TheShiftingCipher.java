import java.util.Scanner;

public class TheShiftingCipher {

    private static String shiftString(String input, int k) {
        StringBuilder ans = new StringBuilder();
        k = k % 26;
        for(char ch : input.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                char shifted = (char) ((ch - 'A' + k) % 26 + 'A');
                ans.append(shifted);
            }
            else if(Character.isLowerCase(ch)) {
                char shifted = (char) ((ch - 'a' + k) % 26 + 'a');
                ans.append(shifted);
            }
            else
                ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        String ans = shiftString(input, k);
        System.out.println("Result: " + ans);
    }
}
