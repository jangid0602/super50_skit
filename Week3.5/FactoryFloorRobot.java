import java.util.Scanner;

/**
 * @Filename-FactoryFloorRobot.java
 * @Description-It processes a list of weights and outputs a corresponding list
 *                 of labels.
 * @Author-Aditya Virmani
 */
public class FactoryFloorRobot {
    public static String[] assignLabel(int[] weights, int items) {
        String[] labels = new String[items];
        for (int i = 0; i < items; i++) {
            if (weights[i] % 15 == 0)
                labels[i] = "Hazardous";
            else if (weights[i] % 3 == 0)
                labels[i] = "Heavy";
            else if (weights[i] % 5 == 0)
                labels[i] = "Fragile";
            else
                labels[i] = String.valueOf(weights[i]);
        }
        return labels;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of items");

        // Taking integer input with the help of InputHelper class
        int items = InputHelper.readInt(scanner);
        int[] weights = new int[items];

        // Taking input: weights of all items
        System.out.println("Enter weights of all itmes");
        for (int i = 0; i < items; i++) {
            weights[i] = InputHelper.readInt(scanner);
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
