/**

 * Description- Given a string, write a recursive function to "compress" it by counting
 consecutive characters. For example, "AAABBC" becomes "3A2B1C".
 * Author - Naval

 */
public class StringCompression {
    static String compress(String s, int index) {
        // Base case
        if (index == s.length()) {
            return "";
        }

        char currentChar = s.charAt(index);
        int count = 0;

        // Count consecutive characters
        while (index < s.length() && s.charAt(index) == currentChar) {
            count++;
            index++;
        }

        // Recursive call for remaining characters
        return count + "" + currentChar + compress(s, index);
    }

    public static void main(String[] args) {
        Input input=new Input();
        String word;

        word=input.inputWord();
        System.out.println(compress(word, 0)); // Output: 2A1B
    }
}

