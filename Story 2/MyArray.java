package Oneup;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyArray {
    public List<Integer> array; // store array as an instance variable
    private Scanner sc = new Scanner(System.in);

    // Constructor
    public MyArray() {
         this.array = new ArrayList<>();
    }
    public MyArray(Scanner sc) {
    this.sc = sc;
}

    // Method to take array input safely
    public void inputArray() {
     this.array = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int n = 0;

    // Loop until valid array size is entered
    while (true) {
        System.out.print("Enter the array size: ");
        try {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("❌ Please enter a positive integer greater than 0.");
                continue;
            }
            break; // valid size -> exit loop
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid size! Please enter an integer.");
            sc.nextLine(); // clear invalid input
        }
    }

    // Input array elements
    array.clear();
    System.out.println("Enter " + n + " elements of array:");

    int count = 0;
    while (count < n) {
        try {
            int value = sc.nextInt();
            array.add(value);
            count++;
        } catch (InputMismatchException e) {
            System.out.println("⚠️ Invalid input! Please enter a valid number:");
            sc.nextLine(); // clear invalid input
        }
    }

    System.out.println("✅ Array entered successfully!");
    System.out.println("\nYou have entered the array:");
    System.out.println("Array contents: " + array);

    
}

       
    
       
    

    // Method to confirm or re-enter array
    public boolean getArrayConfirmation() {
        // System.out.println("\nYou have entered the array:");
        // System.out.println("Array contents: " + array);

        int ch = 0;
        while (true) {
            System.out.println("""
                ---------------------------
                Enter 1 to continue
                Enter 2 to re-enter the array
                ---------------------------
                """);

            try {
                System.out.print("Enter your choice: ");
                ch = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("❌ Invalid input! Please enter 1 or 2.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            if (ch == 1) {
                return false; // user wants to continue
            } else if (ch == 2) {
                return true;  // user wants to re-enter
            } else {
                System.out.println("⚠️ Invalid choice! Try again.\n");
            }
        }
    }
}
