// public class MyString {
//     String str;

//     MyString(String s) {
//         this.str = s;
//     }

//     // 1. Append
//     void append(String newStr) {
//         str = str + newStr;
//     }

//     // 2. Count Words
//     int countWords() {
//         int count = 0;
//         boolean inWord = false;
//         for (int i = 0; i < str.length(); i++) {
//             if (str.toCharArray()[i] != ' ' && !inWord) {
//                 inWord = true;
//                 count++;
//             } else if (str.toCharArray()[i] == ' ') {
//                 inWord = false;
//             }
//         }
//         return count;
//     }

//     // 3. Replace (without using replace or charAt)
//     void replace(char oldChar, char newChar) {
//         char[] arr = str.toCharArray();
//         String result = "";
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == oldChar)
//                 result = result + newChar;
//             else
//                 result = result + arr[i];
//         }
//         str = result;
//     }

//     // 4. Palindrome
//     boolean isPalindrome() {
//         char[] arr = str.toCharArray();
//         int i = 0, j = arr.length - 1;
//         while (i < j) {
//             if (arr[i] != arr[j])
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }

//     // 5. Splice (manual substring)
//     String splice(int start, int end) {
//         char[] arr = str.toCharArray();
//         String res = "";
//         for (int i = start; i < end && i < arr.length; i++) {
//             res = res + arr[i];
//         }
//         return res;
//     }

//     // 6. Split
//     void split(char delim) {
//         char[] arr = str.toCharArray();
//         String temp = "";
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == delim) {
//                 System.out.println(temp);
//                 temp = "";
//             } else {
//                 temp = temp + arr[i];
//             }
//         }
//         System.out.println(temp); // last part
//     }

//     // 7. Max Repeating Character
//     char maxRepeatingCharacter() {
//         char[] arr = str.toCharArray();
//         int maxCount = 0;
//         char maxChar = ' ';
//         for (int i = 0; i < arr.length; i++) {
//             int count = 0;
//             for (int j = 0; j < arr.length; j++) {
//                 if (arr[i] == arr[j])
//                     count++;
//             }
//             if (count > maxCount) {
//                 maxCount = count;
//                 maxChar = arr[i];
//             }
//         }
//         return maxChar;
//     }

//     // 8. Sort (Bubble sort)
//     void sort() {
//         char[] arr = str.toCharArray();
//         for (int i = 0; i < arr.length - 1; i++) {
//             for (int j = 0; j < arr.length - i - 1; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     char temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }
//             }
//         }
//         str = "";
//         for (int i = 0; i < arr.length; i++) {
//             str = str + arr[i];
//         }
//     }

//     // 9. Shift (move first char to last)
//     void shift() {
//         if (str.length() <= 1)
//             return;
//         char[] arr = str.toCharArray();
//         String shifted = "";
//         for (int i = 1; i < arr.length; i++) {
//             shifted = shifted + arr[i];
//         }
//         shifted = shifted + arr[0];
//         str = shifted;
//     }

//     // 10. Reverse
//     void reverse() {
//         char[] arr = str.toCharArray();
//         String rev = "";
//         for (int i = arr.length - 1; i >= 0; i--) {
//             rev = rev + arr[i];
//         }
//         str = rev;
//     }
// }
public class MyString {
    // Instance variable to store the string value
    String text;

    // Constructor: Initializes the string
    MyString(String inputString) {
        this.text = inputString;
    }

    /**
     * 1. append()
     * Purpose: Adds another string to the end of the current string.
     * Logic: Converts both strings to character arrays, then merges them manually.
     */
    void append(String newString) {
        char[] newChars = newString.toCharArray();
        char[] originalChars = text.toCharArray();
        char[] combined = new char[originalChars.length + newChars.length];

        int index = 0;
        // Copy original string
        for (int i = 0; i < originalChars.length; i++) {
            combined[index++] = originalChars[i];
        }
        // Copy new string
        for (int i = 0; i < newChars.length; i++) {
            combined[index++] = newChars[i];
        }

        text = new String(combined);
    }

    /**
     * 2. countWords()
     * Purpose: Counts the number of words in the string.
     * Logic: A word is defined as a sequence of characters separated by spaces.
     * Uses a boolean flag to track when the code is inside a word.
     */
    int countWords() {
        int wordCount = 0;
        boolean insideWord = false;
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != ' ' && !insideWord) {
                insideWord = true;
                wordCount++;
            } else if (characters[i] == ' ') {
                insideWord = false;
            }
        }
        return wordCount;
    }

    /**
     * 3. replace()
     * Purpose: Replaces all occurrences of one character with another.
     * Logic: Loops through each character, if it matches oldCharacter, replaces it.
     * Does not use any built-in replace methods.
     */
    void replace(char oldCharacter, char newCharacter) {
        char[] characters = text.toCharArray();
        String resultString = "";

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == oldCharacter) {
                resultString = resultString + newCharacter;
            } else {
                resultString = resultString + characters[i];
            }
        }
        text = resultString;
    }

    /**
     * 4. isPalindrome()
     * Purpose: Checks if the string is a palindrome (reads the same backward and forward).
     * Logic: Compares characters from the start and end, moving toward the center.
     */
    boolean isPalindrome() {
        char[] characters = text.toCharArray();
        int leftIndex = 0;
        int rightIndex = characters.length - 1;

        while (leftIndex < rightIndex) {
            if (characters[leftIndex] != characters[rightIndex]) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    /**
     * 5. splice()
     * Purpose: Extracts a portion of the string between two indices.
     * Logic: Manually builds a substring from startIndex to endIndex.
     */
    String splice(int startIndex, int endIndex) {
        char[] characters = text.toCharArray();
        String subString = "";

        for (int i = startIndex; i < endIndex && i < characters.length; i++) {
            subString = subString + characters[i];
        }
        return subString;
    }

    /**
     * 6. split()
     * Purpose: Splits the string based on a given delimiter and prints each word.
     * Logic: Every time the delimiter appears, print the current word and reset it.
     */
    void split(char delimiter) {
        char[] characters = text.toCharArray();
        String part = "";

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == delimiter) {
                System.out.println(part);
                part = "";
            } else {
                part = part + characters[i];
            }
        }
        // Print the last part after the final delimiter
        System.out.println(part);
    }

    /**
     * 7. maxRepeatingCharacter()
     * Purpose: Finds the character that appears the most in the string.
     * Logic: For each character, counts how many times it appears and keeps track of the highest count.
     */
    char maxRepeatingCharacter() {
        char[] characters = text.toCharArray();
        int maximumCount = 0;
        char maximumCharacter = ' ';

        for (int i = 0; i < characters.length; i++) {
            int currentCount = 0;

            for (int j = 0; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    currentCount++;
                }
            }

            if (currentCount > maximumCount) {
                maximumCount = currentCount;
                maximumCharacter = characters[i];
            }
        }
        return maximumCharacter;
    }

    /**
     * 8. sort()
     * Purpose: Sorts the characters of the string in ascending order.
     * Logic: Implements the bubble sort algorithm manually.
     */
    void sort() {
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length - 1; i++) {
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (characters[j] > characters[j + 1]) {
                    char temporary = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temporary;
                }
            }
        }

        text = "";
        for (int i = 0; i < characters.length; i++) {
            text = text + characters[i];
        }
    }

    /**
     * 9. shift()
     * Purpose: Moves the first character of the string to the end.
     * Logic: Manually rebuilds the string starting from index 1, then adds the first character at the end.
     */
    void shift() {
        if (text.length() <= 1) {
            return;
        }

        char[] characters = text.toCharArray();
        String shiftedString = "";

        for (int i = 1; i < characters.length; i++) {
            shiftedString = shiftedString + characters[i];
        }
        shiftedString = shiftedString + characters[0];

        text = shiftedString;
    }

    /**
     * 10. reverse()
     * Purpose: Reverses the string.
     * Logic: Traverses the character array from the end and builds the reversed version.
     */
    void reverse() {
        char[] characters = text.toCharArray();
        String reversedString = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversedString = reversedString + characters[i];
        }

        text = reversedString;
    }
}
