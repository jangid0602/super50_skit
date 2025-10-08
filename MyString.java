public class MyString {
    String str;

    MyString(String s) {
        this.str = s;
    }

    // 1. Append
    void append(String newStr) {
        str = str + newStr;
    }

    // 2. Count Words
    int countWords() { 
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.toCharArray()[i] != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (str.toCharArray()[i] == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    // 3. Replace (without using replace or charAt)
    void replace(char oldChar, char newChar) {
        char[] arr = str.toCharArray();
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldChar)
                result = result + newChar;
            else
                result = result + arr[i];
        }
        str = result;
    }

    // 4. Palindrome
    boolean isPalindrome() {
        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 5. Splice (manual substring)
    String splice(int start, int end) {
        char[] arr = str.toCharArray();
        String res = "";
        for (int i = start; i < end && i < arr.length; i++) {
            res = res + arr[i];
        }
        return res;
    }

    // 6. Split
    void split(char delim) {
        char[] arr = str.toCharArray();
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == delim) {
                System.out.println(temp);
                temp = "";
            } else {
                temp = temp + arr[i];
            }
        }
        System.out.println(temp); // last part
    }

    // 7. Max Repeating Character
    char maxRepeatingCharacter() {
        char[] arr = str.toCharArray();
        int maxCount = 0;
        char maxChar = ' ';
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = arr[i];
            }
        }
        return maxChar;
    }

    // 8. Sort (Bubble sort)
    void sort() {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
        }
    }

    // 9. Shift (move first char to last)
    void shift() {
        if (str.length() <= 1)
            return;
        char[] arr = str.toCharArray();
        String shifted = "";
        for (int i = 1; i < arr.length; i++) {
            shifted = shifted + arr[i];
        }
        shifted = shifted + arr[0];
        str = shifted;
    }

    // 10. Reverse
    void reverse() {
        char[] arr = str.toCharArray();
        String rev = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            rev = rev + arr[i];
        }
        str = rev;
    }
}