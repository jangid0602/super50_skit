
import java.util.Scanner; 
    class StringOperations {
        private String text;
        public StringOperations(String text) {
            this.text = text;
        }
        // Append
        public void append(String newString) {
            char[] oldArr = text.toCharArray();
            char[] newArr = newString.toCharArray();
            char[] result = new char[oldArr.length + newArr.length];

            int index = 0;
            for(int i =0; i < oldArr.length; i++) {
                result[index++] = oldArr[i];
            }
                for(int i =0; i < newArr.length; i++) {
                    result[index++] = newArr[i];
                }
                    text = new String(result);
                    System.out.println("Updated String: " + text);
                
                // 2. Count Words(count spaces)
                public int countWords() {
                    int count = 0;
                    boolean inWord = false;
                    for (int i = 0; i < text.length(); i++) {
                       char c = text.charAt(i);
                       if(c != ' ' && !inWord) {
                           inWord = true;
                           count++;
                       } else if (c == ' ') {
                           inWord = false;
                       }
                    }
                    System.out.println("Word Count:" + count);
                }
                // 3. Replace old substring with new substring
                public void replace(String oldStr, String newStr) {
                    char[] oldArr = oldStr.toCharArray();
                    char[] newArr = newStr.toCharArray();
                    char[] src = text.toCharArray();
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < src.length; i++) {
                        boolean match = false;
                        if (i + oldArr.length <= src.length) {  
                            match = true;
                            for (int j = 0; j < oldArr.length; j++) {
                                if (src[i + j] != oldArr[j]) {
                                    match = false;
                                    break;
                                }
                            }
                        }
                        if(match){
                            for(int j = 0; j < newArr.length; j++) {
                                result.append(newArr[j]);
                                i += oldArr.length - 1;
                            }
                            else {
                                result.append(src[i]);
                                i++;
                            }
                        }
                        text = result.toString();
                        System.out.println("Updated String: " + text);
                    }
                    // 4. Palindrome Check
                    public boolean isPalindrome() {
                        char[] arr = text.toLowerCase().toCharArray();
                        boolean isPal = true;
                        int i =0 , j = arr.length -1;
                        while (i < j) {
                            if (arr[i] == ' ') {
                                i++;
                                continue;
                            }                                
                           if(arr[j] == ' ') {
                               j--;
                               continue;
                           }
                            if(arr[i] != arr[j]) {
                                 isPal = false;
                                 break;
                            }
                            i++;
                            j--;
                        }
                    if(isPal) {
                        System.out.println("yes,The string is a palindrome.");
                    } else {
                        System.out.println("No ,The string is not a palindrome.");
                    }
                    // 5.Splice (manual substring)
                    public void splice(int start, int end) {
                        if (start < 0 || end > text.length() || start >= end) {
                            System.out.println("Invalid range!");
                            return;
                        }
                        char[] arr = text.toCharArray();
                        String result = "";
                        for (int i = start; i < end; i++) {
                            result+=(arr[i]);
                        }
                        System.out.println("Spliced String: " + result);
                    }
                    // 6. Split(manual split)
                    public void split(char delimiter) {
                        char[] arr = text.toCharArray();
                        String temp = "";
                        for (int i = 0; i < arr.length; i++) {
                            if(arr[i] == delimiter) {
                                if(!temp.isEmpty()) {
                                    System.out.println(temp);
                                    temp = "";
                                }
                                
                            } else {
                                temp += arr[i];
                            }
                        }
                        if(!temp.isEmpty()) {
                            System.out.println(temp);
                        }
                        // 7 Max Repeating character
                        public void maxRepeatingChar() {
                            char[] arr = text.toCharArray(); 
                            int[] freq = new int[256];
                            for (int i = 0; i < arr.length; i++) {
                                freq[arr[i]]++;
                            }
                            int max = 0;
                            char maxChar = ' ';
                            for (int i = 0; i < 256; i++) {
                                if(freq[i] > max) {
                                    max = freq[i];
                                    maxChar = (char)i;
                                }
                            }
                            System.out.println("Max Repeating Character: " + maxChar);
                    }
                    // 8. Sort(manual bubble sort)
                    public void sort() {
                        char[] arr = text.toCharArray();
                        for (int i = 0; i < arr.length - 1; i++) {
                            for (int j = 0; j < arr.length - i - 1; j++) {
                                if (arr[j] > arr[j + 1]) {
                                    char temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                }
                            }
                        }
                        String sorted = "";
                        for (char c : arr) {
                            sorted += c;
                            System.out.println("Sorted String: " + sorted);
                        }
                        // 9. Shift(manual rotation)
                        public void shift(int n){
                            char[] arr = text.toCharArray();
                            int len = arr.length;
                            n = n % len;
                            char[] shifted = new char[len];
                            int index = 0;

                            for (int i = len - n; i < len; i++) {
                                shifted[index++] = arr[i];
                            }
                            for (int i = 0; i < n; i++) {
                                shifted[index++] = arr[i];
                            }
                            text = new String(shifted);
                            System.out.println("Shifted String: " + text);
                        }
                        // 10. Reverse
                        public void reverse() {
                            char[] arr = text.toCharArray();
                            int i = 0, right = arr.length - 1;
                            while (i < j) {
                                char temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                                i++;
                                j--;
                            }
                            text = new String(arr);
                            System.out.println("Reversed String: " + text);
                        }
                    }
                    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String initial = sc.nextLine();
        StringOperations s = new StringOperations(initial);

        while (true) {
            System.out.println("\nAvailable Operations:");
            System.out.println("1. Append");
            System.out.println("2. CountWords");
            System.out.println("3. Replace");
            System.out.println("4. isPalindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. MaxRepeatingCharacter");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String newStr = sc.nextLine();
                    s.append(newStr);
                    break;
                 case 2:
                    s.countWords();
                    break;
                case 3:
                    System.out.print("Enter substring to replace: ");
                    String oldStr = sc.nextLine();
                    System.out.print("Enter new substring: ");
                    String newSub = sc.nextLine();
                    s.replace(oldStr, newSub);
                    break;
                case 4:
                    s.isPalindrome();
                    break;
                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();
                    s.splice(start, end);
                    break;
                case 6:
                    System.out.print("Enter delimiter (use space for words): ");
                    String delimiter = sc.nextLine();
                    if (delimiter.isEmpty()) delimiter = " ";
                    s.split(delimiter);
                    break;
                case 7:
                    s.maxRepeatingCharacter();
                    break;
                case 8:
                    s.sort();
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                     s.shift(n);
                    break;
                case 10:
                    s.reverse();
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}