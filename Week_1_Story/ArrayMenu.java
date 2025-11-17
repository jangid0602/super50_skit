/*
@filename - ArrayMenu.java
@description - Array methods menu
@author - Kavya Gupta
*/

package Assignment_4;
import java.util.Scanner;

public class ArrayMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Smart Pair Finder");
            System.out.println("2. Minimum Flips (Flip the Switch)");
            System.out.println("3. First Common Index (Sum That Stands Out)");
            System.out.println("4. Odd One Out");
            System.out.println("5. Minimum Painting Time");
            System.out.println("6. Farthest City Index (Efficient Traveler)");
            System.out.println("7. Exit");

          
            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next(); 
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int[] arr1 = takeArrayInput(sc);
                    MyArray obj1 = new MyArray(arr1);
                    int target = safeIntInput(sc, "Enter target value: ");
                    System.out.println("Smart Pair exists: " + obj1.getSmartPair(target));
                    break;

                case 2:
                    int[] arr2 = takeArrayInput(sc);
                    MyArray obj2 = new MyArray(arr2);
                    System.out.println("Minimum flips required: " + obj2.getMinimumFlips());
                    break;

                case 3:
                    int[] arr3 = takeArrayInput(sc);
                    MyArray obj3 = new MyArray(arr3);
                    System.out.println("First common index: " + obj3.getFirstCommonIndex());
                    break;

                case 4:
                    int[] arr4 = takeArrayInput(sc);
                    MyArray obj4 = new MyArray(arr4);
                    System.out.println("The odd one is: " + obj4.getTheOdd());
                    break;

                case 5:
                    int[] arr5 = takeArrayInput(sc);
                    MyArray obj5 = new MyArray(arr5);
                    System.out.println("Minimum painting time: " + obj5.getMinimumPaintingTime());
                    break;

                case 6:
                    int[] arr6 = takeArrayInput(sc);
                    MyArray obj6 = new MyArray(arr6);
                    int energy = safeIntInput(sc, "Enter initial energy: ");
                    System.out.println("Farthest city index reachable: " + obj6.getFarthestCityIndex(energy));
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }


    static int safeIntInput(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            sc.next(); 
            System.out.print(message);
        }
        return sc.nextInt();
    }

  
    static int[] takeArrayInput(Scanner sc) {
        int n = safeIntInput(sc, "Enter size of array: ");
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = safeIntInput(sc, "Element " + (i + 1) + ": ");
        }
        return arr;
    }
}
