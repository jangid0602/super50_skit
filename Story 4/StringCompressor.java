/**
 * <p>This class solves  The String Tiling Challenge  using recursion (merging the string). </p>
 *
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public class StringCompressor {

    static String compress(String inputString) {

        if (inputString.length() == 0)
            return "";

        char current = inputString.charAt(0);
        int count = 0;
        int index = 0;

        while (index < inputString.length() && inputString.charAt(index) == current) {
            count++;
            index++;
        }

        return count + "" + current + compress(inputString.substring(index));
    }

    public static void main(String[] args) {
        Scanner scannerobj = new Scanner(System.in);
        System.out.println("Enter the input string");
        String inputString = scannerobj.next();
        System.out.println(compress(inputString));
    }
}
