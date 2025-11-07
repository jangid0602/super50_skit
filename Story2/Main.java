import java.util.*;

/**
 * @filename - Main.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Main {

    static int getValidIntInput(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); 
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Myarray obj = new Myarray();
        Mystring obj1 = new Mystring();

        int choice;
        do {
            System.out.println(
                    "\n===== MENU =====\n" +
                            "1. Trendsetter Score\n" +
                            "2. Encoded String Check\n" +
                            "3.  E-Commerce Funnel Analysis\n"+
                            "4. Pair Matching\n" +
                            "5. Color Balance\n" +
                            "6. Non-Overlapping Replace\n" +
                            "7. Log File Compaction\n" +
                            "8. SKU Normalisation\n" +
                            "9. Chat Message Redaction\n" +
                            "10. Resume Keyword Match\n" +
                            "11. Exit\n");

            choice = getValidIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1: {
                    int size = getValidIntInput(scanner, "Enter size of array: ");
                    int[] arr1 = new int[size];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < size; i++)
                        arr1[i] = getValidIntInput(scanner, "Element " + (i + 1) + ": ");
                    int k = getValidIntInput(scanner, "Enter k: ");
                    System.out.println("Trendsetter Score: " + obj.TrendsetterScore(arr1, k));
                    break;
                }

                case 2: {
                    System.out.print("Enter first string: ");
                    String s1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = scanner.nextLine();
                    System.out.println("Encoded result: " + obj1.encoded(s1, s2));
                    break;
                }

                case 3: {
                    int n1 = getValidIntInput(scanner, "Enter number of actions: ");
                    String[] v1 = new String[n1];
                    System.out.println("Enter actions:");
                    for (int i = 0; i < n1; i++)
                        v1[i] = scanner.nextLine();
                    System.out.println("Most Frequent path: "+obj.FunnelAnalysis(v1));
                    break;
                }

                case 4: {
                    int size = getValidIntInput(scanner, "Enter size of array: ");
                    int[] arr2 = new int[size];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < size; i++)
                        arr2[i] = getValidIntInput(scanner, "Element " + (i + 1) + ": ");
                    int k = getValidIntInput(scanner, "Enter k: ");
                    System.out.println("Pair Matching: " + obj.pairMaching(arr2, k));
                    break;
                }

                case 5: {
                    int size = getValidIntInput(scanner, "Enter size of array: ");
                    int[] arr3 = new int[size];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < size; i++)
                        arr3[i] = getValidIntInput(scanner, "Element " + (i + 1) + ": ");
                    System.out.println("Color Balance: " + obj.colorBalance(arr3));
                    break;
                }

                case 6: {
                    System.out.print("Enter main string: ");
                    String str = scanner.nextLine();
                    System.out.print("Enter string to find: ");
                    String find_String = scanner.nextLine();
                    System.out.print("Enter string to replace with: ");
                    String replace_String = scanner.nextLine();
                    System.out.println("After replacement: " +
                            obj1.nonOverlappingReplace(str, find_String, replace_String));
                    break;
                }

                case 7: {
                    System.out.print("Enter log string: ");
                    String logs = scanner.nextLine();
                    System.out.println("Compacted Logs: " + obj1.logCompaction(logs));
                    break;
                }

                case 8: {
                    System.out.print("Enter SKU string: ");
                    String str = scanner.nextLine();
                    System.out.println("SKU Normalisation: " + obj1.SKUnormalisation(str));
                    break;
                }

                case 9: {
                    System.out.print("Enter chat message: ");
                    String str = scanner.nextLine();
                    int n = getValidIntInput(scanner, "Enter number of banned words: ");
                    String[] bannedWords = new String[n];
                    System.out.println("Enter banned words:");
                    for (int i = 0; i < n; i++)
                        bannedWords[i] = scanner.nextLine();
                    System.out.println("Redacted Message: " +
                            obj1.chatMessageRedaction(str, bannedWords));
                    break;
                }

                case 10: {
                    int n1 = getValidIntInput(scanner, "Enter number of resume words: ");
                    String[] v1 = new String[n1];
                    System.out.println("Enter resume keywords:");
                    for (int i = 0; i < n1; i++)
                        v1[i] = scanner.nextLine();

                    int n2 = getValidIntInput(scanner, "Enter number of job description words: ");
                    String[] v2 = new String[n2];
                    System.out.println("Enter job keywords:");
                    for (int i = 0; i < n2; i++)
                        v2[i] = scanner.nextLine();

                    System.out.println("Keyword Match Score: " + obj.resumeKeyword(v1, v2));
                    break;
                }

                case 11:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 10);

        scanner.close();
    }
}
