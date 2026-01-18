import java.util.Scanner;


/**
 * @filename - RussianDoll.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Doll {
    int size;
    boolean hasKey;
    Doll inner; 

    Doll(int size, boolean hasKey) {
        this.size = size;
        this.hasKey = hasKey;
        this.inner = null;
    }
}

public class RussianDoll {

    
    static void findKey(Doll doll) {
        System.out.println("Opening doll of size: " + doll.size);

        // Base case
        if (doll.hasKey) {
            System.out.println("🎉 Key Found!");
            return;
        }

        // Recursive call
        findKey(doll.inner);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of dolls: ");
        int n = sc.nextInt();

        Doll prev = null;
        Doll smallest = null;

        // Create dolls from smallest to largest
        for (int i = 1; i <= n; i++) {
            boolean hasKey = (i == 1); // smallest doll has the key
            Doll current = new Doll(i, hasKey);

            if (prev != null) {
                current.inner = prev;
            }
            prev = current;
            if (i == n) {
                smallest = current;
            }
        }

        System.out.println("\nStarting to search for the key...\n");
        findKey(smallest);

        sc.close();
    }
}
