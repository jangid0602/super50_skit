package Oneup.Assignment4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean k = true; // For infinite loop

        while (k) {
            System.out.println("""
                                 Choose an operation
                                 1. The Efficient Traveler 
                                 2. The Sum That Stands Out 
                                 3. Flip the Switch 
                                 4. The Odd One Out 
                                 5. Smart Pair Finder 
                                 6. The Minimalist Painter
                                 7. Exit
                                 Enter your choice (1-7): """);

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.print("Enter number of elements: ");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            array.add(sc.nextInt());
                        }
                        System.out.print("Enter initial Energy: ");
                        int Energy = sc.nextInt();

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("Farthest city index reachable: " + arr.getfarthestcity(Energy));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            array.add(sc.nextInt());
                        }

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("The index where sum stands out is :" + arr.getequalsum());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements in (1 or 0):");
                        for (int i = 0; i < size; i++) {
                            int userinput = sc.nextInt();
                            if (userinput == 1 || userinput == 0) {
                                array.add(userinput);
                            } else {
                                System.out.println("Enter only 0 or 1");
                                i--; // retry same index
                            }
                        }

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("Minimum number of flips required to make all elements equal: " + arr.getminimumflips());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            array.add(sc.nextInt());
                        }

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("The Odd One is :" + arr.getoddoneout());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 5:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.print("Enter number of elements: ");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            array.add(sc.nextInt());
                        }

                        System.out.print("Enter the sum (k): ");
                        int targetSum = sc.nextInt();

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("Smart Pair is: " + arr.pairfinder(targetSum));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 6:
                    try {
                        ArrayList<Integer> array = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int size = sc.nextInt();

                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            array.add(sc.nextInt());
                        }

                        ArrayOperations arr = new ArrayOperations(array);
                        System.out.println("The minimum total time after skipping one wall is: " + arr.getminimumtime());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        sc.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    k = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1–7.");
                    break;
            }
        }
        sc.close();
    }
}
