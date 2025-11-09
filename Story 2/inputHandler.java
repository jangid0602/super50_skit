/**
 * <p>Abstract Class that can handle both integer and string array inputs.</p>
 * <p>Provides input methods for numeric and textual data in one structure.</p>
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public abstract class inputHandler extends problemSolver {

    public int[] nums;
    public String[] strings;
    public int sizeOfNums;
    public int numberOfStrings;

    /**
     * Handles integer array input from the user.
     */
    public void inputIntArray() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the size of the integer array:");
        if (scannerObj.hasNextInt()) {
            sizeOfNums = scannerObj.nextInt();
        } else {
            System.out.println("Enter valid size (only integers allowed!!)");
            System.out.println("Exiting...");
            System.exit(1);
        }

        nums = new int[sizeOfNums];
        System.out.println("Enter integer elements:");
        for (int index = 0; index < sizeOfNums; index++) {
            if (scannerObj.hasNextInt()) {
                nums[index] = scannerObj.nextInt();
            } else {
                System.out.println("Enter valid element (only integers allowed)");
                System.out.println("Exiting...");
                System.exit(1);
            }
        }
    }

    /**
     * Handles string array input from the user.
     */
    public void inputStringArray() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the number of strings:");

        if (scannerObj.hasNextInt()) {
            numberOfStrings = scannerObj.nextInt();
            scannerObj.nextLine(); // consume newline
        } else {
            System.out.println("Enter valid number (only integers allowed!!)");
            System.out.println("Exiting...");
            System.exit(1);
        }

        strings = new String[numberOfStrings];
        System.out.println("Enter the strings:");
        for (int index = 0; index < numberOfStrings; index++) {
            if (scannerObj.hasNextLine()) {
                strings[index] = scannerObj.nextLine().trim();
            } else {
                System.out.println("Enter valid string input");
                System.out.println("Exiting...");
                System.exit(1);
            }
        }
    }

    /**
     * Default inputArray implementation — should be overridden by subclasses.
     */
    @Override
    public abstract void inputArray();

    /**
     * Problem-solving method — implemented in child classes.
     */
    @Override
    public abstract void solver();
}
