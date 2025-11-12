/**
 * <p>Abstract Class for handling integer arrays — allows user to enter array size and elements.</p>
 * @Author- Aaditya Jain
 */

import java.util.Scanner;

public abstract class arrayHandler extends problemSolver {
    public int[] nums;
    public int sizeOfNums;

    @Override
    public void inputArray() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        if (scannerObj.hasNextInt()) {
            sizeOfNums = scannerObj.nextInt();
        } else {
            System.out.println("Enter valid size (only integers allowed!!)");
            System.out.println("Exiting...");
            System.exit(1);
        }

        nums = new int[sizeOfNums];
        System.out.println("Enter the elements of the array:");
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
}
