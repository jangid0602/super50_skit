/*
Author: Eshan Rathore
Description: This is the main file for Phase 1 Challenge
Questions Attempted: All Except Question 4
*/

public static int[] validateArray(int[] arr) {
    Scanner scanner = new Scanner(System.in);
        int size;
        
        // Get valid array size
        do {
            System.out.print("Enter array size (1-" + Integer.MAX_VALUE + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
            size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Array size must be greater than 0.");
            }
        } while (size <= 0);
        
        int[] result = new int[size];
        
        // Get array elements
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
            result[i] = scanner.nextInt();
        }
        
        return result;
}

public class main {
    public static void main(String[] args) {
        System.out.println("Phase 1 Challenge");














    }
}