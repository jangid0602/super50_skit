package util;

public class MathLib {

    // 2 divides (6k + 0), (6k + 2), (6k + 4), 3 divides (6k + 3)
    // leaving us with (6k+1) and (6k+5)
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; (long) i * i <= n; i += 6) if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
}
