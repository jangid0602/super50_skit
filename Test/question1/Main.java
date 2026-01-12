import java.util.Scanner;
/**
 * @file Main.java
 * @description This is the main class that provides a menu-driven interface for memory allocation and deallocation. It interacts with the Memory class to allocate, free, and display allocated memory.
 * @author - Aman jeet Singh
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Memory memory = new Memory();
        
        String choice;
        while (true) {
            System.out.println("1. Allocate Memory");
            System.out.println("2. Free Memory");
            System.out.println("3. Show Allocated Memory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                while (true) {
                    System.out.print("Enter size to allocate (in bytes): ");
                    String allocSize = scanner.nextLine();
                    Boolean isValid = true;
                    for(char c : allocSize.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        continue;
                    }
                    int allocSizeInt = Integer.parseInt(allocSize);
                    memory.allocate(allocSizeInt);
                    break;
                }
                break;
                case "2":
                while (true) {
                    System.out.print("Enter size to free (in bytes): ");
                    String freeSize = scanner.nextLine();
                    Boolean isValid = true;
                    for(char c : freeSize.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            isValid = false;    
                            break;
                        }
                    }
                    if (!isValid) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        continue;
                    }
                    int freeSizeInt = Integer.parseInt(freeSize);
                    memory.free(freeSizeInt);
                    break;
                }
                break;
                case "3":
                    memory.show();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        
    }
}