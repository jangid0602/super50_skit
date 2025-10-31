
import java.util.Scanner;

/**
 * @Filename-Main.java
 * @Description-This is the entry point for menu driven program for operations
 *                   on array
 * @Author-Aditya Virmani
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        while (true) {
            System.out.println("Enter size of the array (positive integer):");
            if (input.hasNextInt()) {
                size = input.nextInt();
                if (size > 0)
                    break;
                else
                    System.out.println("Size must be greater than 0. Try again.");
            } else {
                System.out.println("Enter Integer only");
                input.next();
            }
        }
        int[] inputArray = new int[size];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            if (input.hasNextInt())
                inputArray[i] = input.nextInt();
            else {
                System.out.println("Enter Integer only");
                input.next();
                i--;
            }
        }
        input.nextLine();
        MyArray array = new MyArray(inputArray, size);
        int choice = -1;
        do {
            System.out.println(
                    "\nEnter your choice:\n" +
                            "1. The Efficient Traveller\n" +
                            "2. The sum that stands out\n" +
                            "3. Flip the Switch\n" +
                            "4. The Odd One Out \n" +
                            "5. Smart Pair Finder \n" +
                            "6. The Minimalist Painter \n" +
                            "0. Exit");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Invalid Choice Please Enter a valid Choice");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter initial energy");
                    int initialEnergy = input.nextInt();
                    int answer = array.efficientTraveller(initialEnergy);
                    System.out.println(answer == -1 ? "Array is not valid for this operation" : "Answer is:" + answer);
                    break;

                case 2:
                    System.out.println("Running Sum Stands Out...");
                    int index = array.sumStandsOut();
                    System.out.println(index == -1 ? "No such index found" : "Resultant index is:" + index);
                    break;

                case 3:
                    int minOperation = array.flipTheSwitch();
                    System.out.println(minOperation == -1 ? "Array is not valid for this operation"
                            : "Minimum operation to make all elements equal is:" + minOperation);
                    break;

                case 4:
                    OddOneResult result = array.oddOneOut();
                    System.out.println(result.isValid == false ? "Array not valid for this operation"
                            : "Single element present in array is: " + result.element);
                    break;

                case 5:
                    System.out.println("Enter target sum");
                    int target = input.nextInt();
                    boolean exist = array.smartPairFinder(target);
                    System.out.println(exist == true ? "Pair exists" : "Pair does not exists");
                    break;

                case 6:
                    int minTime = array.minimalistPainter();
                    System.out
                            .println(minTime == -1 ? "Array is not valid for this operation as time cannot be negative"
                                    : "Minimum total time is:" + minTime);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Not a valid choice");
                    break;
            }

        } while (choice != 0);

        input.close();
    }
}