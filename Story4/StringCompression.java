

/**
 * @Filename- StringCompression.java
 * @Description- In this we need to "compress" it by counting consecutive characters
 * @Author- Arman Agrawal
 */





public class StringCompression {

    public static String compress(String input, int index) {
        if (index >= input.length()) return "";

        char currentChar = input.charAt(index);
        int count = 0;

        while (index < input.length() && input.charAt(index) == currentChar) {
            count++;
            index++;
        }

        return count + "" + currentChar + compress(input, index);
    }
}
    