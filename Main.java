
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Filename - Main.java
 * Description - Find longest stable path
 * Author - Nancy Jain
 * Date - 21/01/2026
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("OPERATIONS :");
            System.out.println("1. The FLOOR IS LAVA");
            System.out.println("2. ENCRYPTED PALINDROME");
            System.out.println("3. MIRROR WORD");
            System.out.println("4. OXYGEN TANK SCRUBBER");
            System.out.println("5. NODE SWAP BY VALUE");
            System.out.println("6. Quit");
            System.out.println("Enter your choice (1-6): ");

            int choice = readInt(scanner);

            switch (choice) {

                case 1 -> {
                    int[] heights = {10,20,22,23,30};
                    int count = LavaFloor.path(heights , 2);
                    System.out.println(count);
                    break;
                }

                case 2 -> {
                    String word = "vutuv";
                    System.out.println(EncryptedPalindrome.isPalindrome(word));
                    break;
                }

                case 3 -> {
                    String word = "bod";
                    System.out.println(MirrorWord.Mirror(word));
                    break;
                    
                }

                case 4 -> {
                    break;
                }

                case 5 -> {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);
                    int number = 2;
                    LinkedList<Integer> result = new LinkedList<>();
                    NodeSwap.Swap(list, number);
                }

                case 6 -> {
                    System.out.println("Do you want to exit? Press 1 for Yes, 0 for No:");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println("Exiting...");
                        running = false;
                    }
                }
            }
        }
        scanner.close();
    }
    private static int readInt(Scanner sc) {
        while(true) {
            if(sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                String bad = sc.nextLine();
                System.out.println("Invalid Input: \""+ bad +"\" is not an Integer. Try again.");
            }
        }
    }

    }
