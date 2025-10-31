public class MathFunctions {

    
    double power(double base, int exponent) {
        double result = 1.0;
        int exp = Math.abs(exponent);

        while (exp > 0) {
            if ((exp & 1) == 1)  
                result *= base;
            base *= base;
            exp >>= 1;  
        }

        
        return (exponent < 0) ? 1.0 / result : result;
    }

    
    double squareRoot(double number) {
        if (number < 0) {
            System.out.println("Invalid input: negative number");
            return -1;
        }

        if (number == 0 || number == 1)
            return number;

        double guess = number;
        double epsilon = 1e-6;

        while (Math.abs(guess * guess - number) > epsilon) {
            guess = (guess + number / guess) / 2.0;
        }

        return guess;
    }
}   