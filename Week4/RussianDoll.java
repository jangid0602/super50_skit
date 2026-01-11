import java.util.Scanner;

/**
 * @Filename-RussianDoll.java
 * @Description-Implements a recursive function that checks whether the smallest
 *                         doll has key or not
 * @Author-Aditya Virmani
 */
class Doll {
    int size;
    boolean hasKey;
    Doll innerDoll;

    Doll(int size, boolean hasKey) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = null;
    }
}

public class RussianDoll {

    public static void findKey(Doll doll) {
        if (doll == null) {
            System.out.println("Error: Doll does not exist!");
            return;
        }

        System.out.println("Opening Doll of size: " + doll.size);

        if (doll.hasKey) {
            System.out.println("Key Found!");
            return;
        }

        if (doll.innerDoll == null) {
            System.out.println("No more dolls inside and key not found!");
            return;
        }

        findKey(doll.innerDoll);
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int numberOfDoll = 0;
        boolean keyPresent = false;

        while (true) {
            try {
                System.out.print("Enter number of dolls: ");
                numberOfDoll = userInput.nextInt();

                if (numberOfDoll <= 0) {
                    System.out.println("Error: Number of dolls must be positive!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer value.");
                userInput.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Does the smallest doll have the key? (true/false): ");
                keyPresent = userInput.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter true or false.");
                userInput.nextLine();
            }
        }

        Doll current = new Doll(1, keyPresent);

        for (int i = 2; i <= numberOfDoll; i++) {
            Doll outer = new Doll(i, false);
            outer.innerDoll = current;
            current = outer;
        }

        findKey(current);
        userInput.close();
    }
}
