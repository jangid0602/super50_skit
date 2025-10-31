import java.util.Scanner;

class InputHelper{
    
    protected static final int MAX_ALLOWED_SIZE = 10000000;

    public static int getIntInput(Scanner userInput, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (userInput.hasNextInt()) {
                return userInput.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a valid integer.\n");
                userInput.next();
            }
        }
    }

}

public class Main extends InputHelper{

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int size = 0;

        do {
            size = getIntInput(userInput, "Enter number of elements: ");
            if (size <= 0) {
                System.out.println("Array size must be positive.\n");
            } else if (size > MAX_ALLOWED_SIZE) {
                System.out.println("Array size too large! Maximum allowed is " + MAX_ALLOWED_SIZE + ".\n");
                size = 0;
            }
        } while (size <= 0);

        int[] values = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            values[i] = getIntInput(userInput, "Enter Element " + (i + 1) + ": ");
        }

        MyArray array = new MyArray(values);
        int choice = 0;

        do {
            System.out.println("""
                    \n=== WEEK 1 STORIES ===
                    1. Efficient Traveler
                    2. The Sum That Stands Out
                    3. Flip the Switch
                    4. The Odd One Out
                    5. Smart Pair Finder
                    6. The Minimalist Painter
                    7. Exit
                    """);

            choice = getIntInput(userInput, "Enter your choice (1-7): ");

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice! Please select between 1 and 7.\n");
                continue;
            }

            int result;

            switch (choice) {
                case 1:
                    int energy;
                    do {
                        energy = getIntInput(userInput, "Enter initial energy: ");
                        if (energy <= 0)
                            System.out.println("Energy must be positive.\n");
                    } while (energy <= 0);

                    result = array.getEfficientTraveler(energy);
                    System.out.println(result == -1
                            ? "Invalid input for Efficient Traveler."
                            : "Farthest city index: " + result);
                    break;

                case 2:
                    result = array.getSumThatStandsOut();
                    System.out.println(result == -1
                            ? "No index found where prefix == suffix sum."
                            : "Index: " + result);
                    break;

                case 3:
                    result = array.flipTheSwitch();
                    System.out.println(result == -1
                            ? "Invalid input for Flip the Switch."
                            : "Minimum flips required: " + result);
                    break;

                case 4:
                    result = array.getOddOneOut();
                    System.out.println(result == Integer.MIN_VALUE
                            ? "Invalid input or not found."
                            : "Odd one out: " + result);
                    break;

                case 5:
                    int k = getIntInput(userInput, "Enter target k: ");
                    result = array.smartPairFinder(k);
                    System.out.println(result == -1
                            ? "Invalid input."
                            : result == 1 ? "Pair exists for target " + k
                                    : "No pair found for target " + k);
                    break;

                case 6:
                    result = array.minimalistPainter();
                    System.out.println(result == -1
                            ? "Invalid input for Minimalist Painter."
                            : "Minimum total painting time: " + result);
                    break;

                case 7:
                    System.out.println("Exiting program");
                    break;
            }

        } while (choice != 7);
    }
}
