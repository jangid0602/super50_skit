
/**
* @filename-Mystring.java
* @description-This will perform most of string operation
* @author - Ishanvi Agarwal
*/
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an initial string: ");
        String input = scanner.nextLine();

        MyString myStr = new MyString(input);

        int choice;
        do {
            System.out.println("\n===== STRING OPERATIONS MENU =====");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace Character");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Splice (Substring)");
            System.out.println("6. Split by Delimiter");
            System.out.println("7. Max Repeating Character");
            System.out.println("8. Sort Characters");
            System.out.println("9. Shift First Character to Last");
            System.out.println("10. Reverse String");
            System.out.println("11. Display Current String");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String toAppend = scanner.nextLine();
                    myStr.append(toAppend);
                    System.out.println("Updated string: " + myStr.text);
                    break;

                case 2:
                    System.out.println("Word Count: " + myStr.countWords());
                    break;

                case 3:
                    System.out.print("Enter old character: ");
                    char oldChar = scanner.next().charAt(0);
                    System.out.print("Enter new character: ");
                    char newChar = scanner.next().charAt(0);
                    myStr.replace(oldChar, newChar);
                    System.out.println("Updated string: " + myStr.text);
                    break;

                case 4:
                    boolean result = myStr.isPalindrome();
                    System.out.println("Is Palindrome? " + result);
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end index: ");
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Spliced string: " + myStr.splice(start, end));
                    break;

                case 6:
                    System.out.print("Enter delimiter character: ");
                    char delimiter = scanner.next().charAt(0);
                    System.out.println("Split parts:");
                    myStr.split(delimiter);
                    break;

                case 7:
                    System.out.println("Max Repeating Character: " + myStr.maxRepeatingCharacter());
                    break;

                case 8:
                    myStr.sort();
                    System.out.println("After Sorting: " + myStr.text);
                    break;

                case 9:
                    myStr.shift();
                    System.out.println("After Shift: " + myStr.text);
                    break;

                case 10:
                    myStr.reverse();
                    System.out.println("After Reverse: " + myStr.text);
                    break;

                case 11:
                    System.out.println("Current String: " + myStr.text);
                    break;

                case 0:
                    System.out.println("Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
