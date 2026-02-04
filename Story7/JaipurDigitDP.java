import java.util.Scanner;
/*
discription: This program counts numbers between L and R such that the sum of digits is a prime number (mod 10^9+7).
author: Aman Jeet Singh
*/

public class JaipurDigitDP {

    static final int MOD = 1000000007;
    static final int MAX_SUM = 162;
    static boolean[] isPrime = new boolean[MAX_SUM + 1];

    static void sieve() {
        for (int i = 2; i <= MAX_SUM; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX_SUM; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_SUM; j += i) isPrime[j] = false;
            }
        }
    }

    static int[] toDigits(String s) {
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            d[i] = s.charAt(i) - '0';
        }
        return d;
    }

    static long countUpTo(int[] digits) {
        int len = digits.length;
        long[][][] dp = new long[len + 1][2][MAX_SUM + 1];
        dp[0][1][0] = 1;
        for (int pos = 0; pos < len; pos++) {
            for (int tight = 0; tight <= 1; tight++) {
                for (int sum = 0; sum <= MAX_SUM; sum++) {
                    if (dp[pos][tight][sum] == 0) continue;
                    int up = (tight == 1) ? digits[pos] : 9;
                    for (int dig = 0; dig <= up; dig++) {
                        int newSum = sum + dig;
                        if (newSum > MAX_SUM) continue;
                        int newTight = (tight == 1 && dig == up) ? 1 : 0;
                        dp[pos + 1][newTight][newSum] = (dp[pos + 1][newTight][newSum] + dp[pos][tight][sum]) % MOD;
                    }
                }
            }
        }
        long total = 0;
        for (int t = 0; t <= 1; t++) {
            for (int s = 2; s <= MAX_SUM; s++) {
                if (isPrime[s]) {
                    total = (total + dp[len][t][s]) % MOD;
                }
            }
        }
        return total;
    }

    static String decrement(String s) {
        int[] d = toDigits(s);
        int i = d.length - 1;
        while (i >= 0 && d[i] == 0) {
            d[i] = 9;
            i--;
        }
        if (i < 0) return "0";
        d[i]--;
        if (d[0] == 0 && d.length > 1) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            while (start < d.length && d[start] == 0) start++;
            for (int j = start; j < d.length; j++) sb.append(d[j]);
            return sb.length() == 0 ? "0" : sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < d.length; j++) sb.append(d[j]);
        return sb.toString();
    }

    static long countInRange(String left, String right) {
        String leftMinus = decrement(left);
        long toRight = countUpTo(toDigits(right));
        long toLeft = countUpTo(toDigits(leftMinus));
        return (toRight - toLeft + MOD) % MOD;
    }

    public static void main(String[] args) {
        sieve();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter L and R (as strings, up to 10^18): ");
        String left = scan.next();
        String right = scan.next();

        System.out.println();
        System.out.println("L: " + left + ", R: " + right);
        System.out.println("Count (digit sum prime) mod 10^9+7: " + countInRange(left, right));
        scan.close();
    }
}
