/***
 * <p>Abstract Class which will be handling the array ie. allow user to enter size and element in the array</p>
 * @Author- Aaditya Jain
 */


import java.util.Scanner;

public abstract class arrayHandler extends problemSolver {
    public int[] nums;
    int sizeOfNums;

    public void inputArray() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        if(scannerObj.hasNextInt())
        sizeOfNums = scannerObj.nextInt();
        else {
            System.out.println("Enter valid size(only integer Allowed!!)");
            System.out.println("Exiting....");
            System.exit(1);
        }
        nums = new int[sizeOfNums];
        System.out.println("Enter your elements");
        for (int index = 0; index < sizeOfNums; index++) {
            if(scannerObj.hasNextInt())
            {
                nums[index] = scannerObj.nextInt();
            }
            else {
                System.out.println("Enter valid element (Only integers allowed)");
                System.out.println("Exiting...");
                System.exit(1);
            }

        }

    }

}
