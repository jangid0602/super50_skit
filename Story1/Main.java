/**
 * @filename Main.java
 * This file serves as the main driver program for Assignment 4 of the OpenUpVS Java package.
 * It provides a menu-driven console interface for executing different algorithmic problems 
 * implemented in the Myarray class.
 * @author Priyanshu Joshi
 * @class Main
 * @description The Main class provides an interactive command-line interface to test 
 *              and demonstrate all methods of the Myarray class. It repeatedly prompts 
 *              the user for input until the exit option is selected.
 */

package codeupstory1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerobject = new Scanner(System.in);
        boolean k = true;// For infinite loop
        while (k) {
            System.out.println("""
                    Choose an operation
                    1. The Efficient Traveler
                    2. The Sum That Stands Out
                    3. Flip the Switch
                    4. The Odd One Out
                    5.  Smart Pair Finder
                    6.  The Minimalist Painter
                    7. Exit
                    Enter your choice (1-7): """);

            int choice = scannerobject.nextInt();
            scannerobject.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    try {
                        ArrayList<Integer> array1 = new ArrayList<>();
                        System.out.print("Enter number of elements: ");
                        int arraySize = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize + " elements:");
                        for (int i = 0; i < arraySize; i++) {
                            array1.add(scannerobject.nextInt());
                        }
                        System.out.print("Enter initial Energy: ");
                        int initialEnergy = scannerobject.nextInt();

                        Myarray myarray1 = new Myarray(array1, initialEnergy);
                        System.out.println("Farthest city index reachable: " + myarray1.efficientTraveler());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }

                case 2:
                    try {
                        ArrayList<Integer> array2 = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int arraySize2 = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize2 + " elements:");
                        for (int i = 0; i < arraySize2; i++) {
                            array2.add(scannerobject.nextInt());
                        }

                        Myarray myarray2 = new Myarray(array2);
                        System.out.println("The Sum That Stands Out is :" + myarray2.sumThatStandsOut());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }

                case 3:
                    try {
                        ArrayList<Integer> array3 = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int arraySize3 = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize3 + " elements in(1 or 0):");
                        int userinput;
                        for (int i = 0; i < arraySize3; i++) {
                            userinput = scannerobject.nextInt();
                            if (userinput == 1 || userinput == 0) {
                                array3.add(userinput);

                            } else {
                                System.out.println("Enter only 0 or 1");
                                break;
                            }

                        }

                        Myarray myarray3 = new Myarray(array3);
                        System.out.println(" minimum number of flips required to make all elements equal :"
                                + myarray3.flipTheSwitch());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }

                case 4:
                    try {
                        ArrayList<Integer> array4 = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int arraySize4 = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize4 + " elements:");
                        for (int i = 0; i < arraySize4; i++) {
                            array4.add(scannerobject.nextInt());
                        }

                        Myarray myarray4 = new Myarray(array4);
                        System.out.println(" The Odd One is :" + myarray4.oddOneOut());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }

                case 5:
                    try {
                        ArrayList<Integer> array5 = new ArrayList<>();
                        System.out.print("Enter number of elements: ");
                        int arraySize5 = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize5 + " elements:");
                        for (int i = 0; i < arraySize5; i++) {
                            array5.add(scannerobject.nextInt());
                        }

                        System.out.print("Enter the sum(k): ");
                        int targetSum = scannerobject.nextInt();

                        Myarray myarray5 = new Myarray(array5, targetSum);
                        System.out.println("Smart Pair is: " + myarray5.pairFinder());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }
                case 6:
                    try {
                        ArrayList<Integer> array6 = new ArrayList<>();
                        System.out.println("Enter number of elements:");
                        int arraySize6 = scannerobject.nextInt();

                        System.out.println("Enter " + arraySize6 + " elements:");
                        for (int i = 0; i < arraySize6; i++) {
                            array6.add(scannerobject.nextInt());
                        }

                        Myarray myarray6 = new Myarray(array6);
                        System.out.println(
                                " the minimum total time after skipping one wall is :" + myarray6.minimalistPainter());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter integers only.");
                        scannerobject.nextLine();
                        break;
                    }
                case 7:
                    System.out.println("Exiting program...");
                    scannerobject.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1-7.");

            }

        }
    }
}