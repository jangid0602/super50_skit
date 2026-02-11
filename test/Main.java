package Oneup.Assignment2;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Memory m = null; // Declare outside switch to keep it accessible
        int choice;

        while (true) {
            System.out.println("\n=== MEMORY MANAGEMENT MENU ===");
            System.out.println("1. Allocate Memory");
            System.out.println("2. Check Used Memory");
            System.out.println("3. Free Memory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter memory size to allocate: ");
                    int size = sc.nextInt();
                    m = new Memory(size);
                    System.out.println(size + " units of memory allocated.");
                    break;

                case 2:
                    if (m != null)
                        System.out.println("Current used memory: " + m.getallocatedmemory() + " units");
                    else
                        System.out.println("No memory allocated yet!");
                    break;

                case 3:
                    if (m != null) {
                        System.out.print("Enter memory size to free: ");
                        int y = sc.nextInt();
                        m.free(y);
                    } else {
                        System.out.println("No memory allocated yet!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        }
    }
}
