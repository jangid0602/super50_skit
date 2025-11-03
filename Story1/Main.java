import java.util.Scanner;

/**
 * Main runner for Array Operations Console using MyArray utilities.
 */
public class Main {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        int arraySize = 0;

        System.out.println(" Welcome to the Array Operations Console!");
        System.out.println("============================================\n");

        // Input loop for getting a valid array size
        while (true) {
            System.out.print(" Enter the size of the array: ");
            String sizeInput = consoleInput.nextLine();
            try {
                arraySize = Integer.parseInt(sizeInput);
                if (arraySize <= 0) {
                    System.out.println(" Size must be positive. Try again.\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter digits only.\n");
            }
        }

        // Initialize MyArray object
        MyArray arrayObject = new MyArray(arraySize);
        arrayObject.elements = new int[arraySize];

        System.out.println("\n Now, let's fill your array!");
        for (int elementIndex = 0; elementIndex < arraySize; elementIndex++) {
            while (true) {
                System.out.print(" Enter array element at index " + elementIndex + ": ");
                String elementInput = consoleInput.nextLine();
                try {
                    int elementValue = Integer.parseInt(elementInput);
                    arrayObject.elements[elementIndex] = elementValue;
                    System.out.println(" Stored " + elementValue + " at index " + elementIndex);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(" Invalid input! Please enter digits only.\n");
                }
            }
        }

        System.out.println("\n Array entered successfully!");
        System.out.println("============================================");

        String[] arrayMenuOperations = {
            "The Efficient Traveller",
            "The Sum That Stands Out",
            "Flip the Switch",
            "The Odd One Out",
            "Smart Pair Finder",
            "The Minimalist Painter",
            "Change the array"
        };

        boolean programActive = true;
        while (programActive) {
            System.out.println("\n======= ARRAY OPERATIONS MENU =======");
            for (int i = 0; i < arrayMenuOperations.length; i++) {
                System.out.println((i + 1) + "️⃣  " + arrayMenuOperations[i]);
            }
            System.out.println("0️  Terminate Program");
            System.out.println("========================================");
            System.out.print(" Enter your choice: ");

            int menuChoice;
            try {
                menuChoice = Integer.parseInt(consoleInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number between 0 and 7.\n");
                continue;
            }

            System.out.println("----------------------------------------");

            switch (menuChoice) {
                case 1:
                    System.out.println(" You chose: " + arrayMenuOperations[0]);
                    System.out.print(" Enter initial energy: ");
                    try {
                        int initialEnergy = Integer.parseInt(consoleInput.nextLine());
                        int finalPosition = arrayObject.theEfficientTraveller(initialEnergy);
                        System.out.println("Final position reached: " + finalPosition);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid input! Please enter a number.");
                    }
                    break;

                case 2:
                    System.out.println(" You chose: " + arrayMenuOperations[1]);
                    int standoutIndex = arrayObject.getTheSumThatStandsOut();
                    System.out.println(" Index with equal prefix/suffix sum: " + standoutIndex);
                    break;

                case 3:
                    System.out.println(" You chose: " + arrayMenuOperations[2]);
                    int minimalFlips = arrayObject.flipTheSwitch();
                    System.out.println(" Total switches to flip: " + minimalFlips);
                    break;

                case 4:
                    System.out.println(" You chose: " + arrayMenuOperations[3]);
                    int uniqueElement = arrayObject.getTheOddOneOut();
                    if (uniqueElement == -1) {
                        System.out.println("No odd one out found.");
                    } else {
                        System.out.println(" The odd one out is: " + uniqueElement);
                    }
                    break;

                case 5:
                    System.out.println(" You chose: " + arrayMenuOperations[4]);
                    System.out.print(" Enter target value for pair finding: ");
                    try {
                        int targetPairSum = Integer.parseInt(consoleInput.nextLine());
                        boolean hasPair = arrayObject.getThePair(targetPairSum);
                        if (hasPair)
                            System.out.println(" Pair found that sums to target!");
                        else
                            System.out.println(" No valid pair found.");
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid input! Please enter a valid number.");
                    }
                    break;

                case 6:
                    System.out.println(" You chose: " + arrayMenuOperations[5]);
                    int minimalTime = arrayObject.getMinimumTime();
                    System.out.println("⏱ Minimum time required: " + minimalTime);
                    break;

                case 7:
                    System.out.println(" You chose: " + arrayMenuOperations[6]);
                    System.out.println(" Let's update your array!");
                    for (int elementIndex = 0; elementIndex < arraySize; elementIndex++) {
                        while (true) {
                            System.out.print(" Enter new element at index " + elementIndex + ": ");
                            String newValueInput = consoleInput.nextLine();
                            try {
                                int updatedElement = Integer.parseInt(newValueInput);
                                arrayObject.elements[elementIndex] = updatedElement;
                                System.out.println(" Updated index " + elementIndex + " with " + updatedElement);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println(" Invalid input! Please enter digits only.");
                            }
                        }
                    }
                    System.out.println(" Array updated successfully!");
                    break;

                case 0:
                    System.out.println(" Terminating program... Thank you for using the Array Console!");
                    System.out.println("============================================");
                    programActive = false;
                    break;

                default:
                    System.out.println(" Invalid choice! Please select between 0 and 7.");
            }

            if (programActive) {
                System.out.println("\nReturning to main menu...\n");
            }
        }

        consoleInput.close();
    }
}
