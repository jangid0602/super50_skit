import java.util.Scanner;

/**
 * @Filename-FactoryFloorRobot.java
 * @Description-This program processes a list of item weights and assigns appropriate
 *                   labels based on divisibility rules for factory floor automation. Items
 *                   divisible by 15 are labeled "Hazardous", items divisible by 3 are labeled
 *                   "Heavy", items divisible by 5 are labeled "Fragile", and all other items
 *                   display their numeric weight value as the label.
 * @Author- Aman Jeet Singh
 */
public class FactoryFloorRobot {
    public static String[] assignLabel(int[] weights, int items) {
        String[] labels = new String[items];
        for (int i = 0; i < items; i++) {
            if (weights[i] % 15 == 0) {
                labels[i] = "Hazardous";
            } else if (weights[i] % 3 == 0) {
                labels[i] = "Heavy";
            } else if (weights[i] % 5 == 0) {
                labels[i] = "Fragile";
            } else {
                labels[i] = String.valueOf(weights[i]);
            }
        }
        return labels;
    }

    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int items = readInt(scanner);
        int[] weights = new int[items];

        // Taking input: weights of all items
        System.out.println("Enter weights of all items:");
        for (int i = 0; i < items; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            weights[i] = readInt(scanner);
        }
        String[] labels = assignLabel(weights, items);

        // Output
        System.out.println("Assigned labels are:");
        for (int i = 0; i < items; i++) {
            System.out.print(labels[i] + " ");
        }
        scanner.close();
    }
}