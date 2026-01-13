/**
 
 * Description- In a set of nested Russian dolls. Inside each doll is a smaller
 doll, until you reach the smallest one which contains a tiny golden key.
 Write a recursive function findKey(doll) that opens a doll, checks if it's
 the smallest, and if not, calls itself on the doll found inside.
 * Author - Mayank Rathore

 */
import java.util.Scanner;

class Doll {
    int size;
    boolean hasKey;
    Doll innerDoll;

    // Constructor
    Doll(int size, boolean hasKey, Doll innerDoll) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = innerDoll;
    }
}
public class TheRussianDollMystery {
    public static void findKey(Doll doll)
    {
        if (doll == null) {
            System.out.println("Key not Found");
            return;
        }
        System.out.println("Opening doll of size: " + doll.size);
        if (doll.hasKey) {
            System.out.println("Key found in doll of size: " + doll.size);
            return;
        }
        findKey(doll.innerDoll);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of dolls: ");
        Input input=new Input();
        int size= input.inputInteger();

        Doll inner = null;

        // Creating dolls from smallest to largest
        for (int i = 1; i <= size; i++) {
            boolean hasKey = (i == 1);
            inner = new Doll(i, hasKey, inner);
        }
        findKey(inner);

    }
}
