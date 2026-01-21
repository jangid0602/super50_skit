/**
* @Filename - Main.java
* @Description - This program lists and executes different tasks from the first story.
* @Author - Nancy Jain
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        boolean running = true;
        System.out.print("Enter array size: ");

        int size;      // if size of array is negative or equal to zero.
        do{
            size = readInt(scanner);
            if(size<=0){
                System.out.println("Array size must be positive. try Again!");
            }
        } while(size<=0);

        int[] array = new int[size];
        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            array[i] = readInt(scanner);
        }
        Tasks task = new Tasks(array, size);
        do {
            System.out.println("\nChoose a task:");
            System.out.println("1. The Efficient Traveler");
            System.out.println("2. The Sum That Stands Out");
            System.out.println("3. Flip the Switch");
            System.out.println("4. The Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. The Minimalist Painter");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    System.out.println("Enter initial energy :");
                    int initialEnergy = readInt(scanner);
                    System.out.println(" The farthest city index reachable without running out of energy : "+task.getEfficientTraveler(initialEnergy));
                    break;
                case 2:
                    int index = task.getSumThatStandsOut();
                    if(index != -1){
                        System.out.println(" The first index where the prefix sum equals the suffix sum is :" + index);
                    }else{
                        System.out.println("Index does not exist where the prefix sum equals the suffix sum");
                    }
                    break;
                case 3:
                    System.out.println("Enter array containing 0 and 1 only of length " + size);
                    int [] arr = new int[size];
                    for(int i=0;i<size;i++){
                        arr[i] = readInt(scanner);
                    }
                    System.out.println("The minimum number of flips required to make all elements equal is : "+task.getFlippedSwitch(arr));
                    break;
                case 4:
                    System.out.println("The Odd One Out Element is : "+task.getOddOneOut());
                    break;
                case 5:
                    System.out.println("Enter target to find pair ");
                    int target = readInt(scanner);
                    if(task.getSmartPair(target)) 
                        System.out.println("There exists a pair (i,j) such that their sum is equal to target.");
                    else 
                        System.out.println("Sorry! no pair exist to match the target sum. ");
                    break;
                case 6:
                    System.out.println("The minimum total time taken by skipping one wall is : " + task.getMinimalistPainter());
                    break;
                case 7:
                    System.out.print("Do you want to quit? (y/n): ");
                    char confirmQuit;
                    while(true){
                        String input = scanner.next().trim().toLowerCase();
                        if(input.equals("y") || input.equals("n")){
                            confirmQuit = input.charAt(0);
                            break;
                        }else{
                            System.out.println("Invalid input! Please enter y or n:");
                        }
                    }
                        if (confirmQuit == 'y') {
                            running = false;
                            System.out.println("Exiting...");
                    }
                    break;
                default:
                    System.out.println("Wrong choice! Try again.");
                    break;
            }

        } while (running);
    }
}
    private static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine(); // consume rest of line
                return val;
            } else {
                String bad = sc.nextLine(); // consume the invalid token/line
                System.out.println("Invalid entry: \"" + bad + "\" is not an integer. Please enter an integer value.");
            }
        }
    }
}
