/**
* @filename-Mystring.java
* @description-This will perform most of string operation
* @author - Ishanvi Agarwal
*/
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        MyString myStr = new MyString(input);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. Max Repeating Character");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
            System.out.println("11. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter string to append:");
                    String appendStr = sc.nextLine();
                    myStr.append(appendStr);
                    System.out.println("After append: " + myStr.str);
                    break;

                case 2:
                    System.out.println("Word Count: " + myStr.countWords());
                    break;

                case 3:
                    System.out.println("Enter old character:");
                    char oldChar = sc.next().charAt(0);
                    System.out.println("Enter new character:");
                    char newChar = sc.next().charAt(0);
                    myStr.replace(oldChar, newChar);
                    System.out.println("After replace: " + myStr.str);
                    break;

                case 4:
                    if (myStr.isPalindrome())
                        System.out.println("String is Palindrome");
                    else
                        System.out.println("String is not Palindrome");
                    break;

                case 5:
                    System.out.println("Enter start index:");
                    int start = sc.nextInt();
                    System.out.println("Enter end index:");
                    int end = sc.nextInt();
                    System.out.println("Spliced String: " + myStr.splice(start, end));
                    break;

                case 6:
                    System.out.println("Enter delimiter character:");
                    char delim = sc.next().charAt(0);
                    myStr.split(delim);
                    break;

                case 7:
                    System.out.println("Max Repeating Character: " + myStr.maxRepeatingCharacter());
                    break;

                case 8:
                    myStr.sort();
                    System.out.println("After sorting: " + myStr.str);
                    break;

                case 9:
                    myStr.shift();
                    System.out.println("After shift: " + myStr.str);
                    break;

                case 10:
                    myStr.reverse();
                    System.out.println("After reverse: " + myStr.str);
                    break;

                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}