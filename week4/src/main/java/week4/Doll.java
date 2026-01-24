/**
 * A class representing the Russian Dolls structured to form a nested Doll
 * layout
 *
 * @author Bhavya Jain
 * @date 7 Jan 2025
 */

public class Doll {

    private final int size;
    private final Doll innerDoll;
    private final boolean hasKey;

    // Constructor for non-smallest dolls
    public Doll(int size, Doll innerDoll) {
        this.size = size;
        this.innerDoll = innerDoll;
        this.hasKey = false;
    }

    // Constructor for smallest doll
    public Doll(int size, boolean hasKey) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = null;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public Doll getInnerDoll() {
        return innerDoll;
    }

    public int getSize() {
        return size;
    }

    // Open the doll
    public void open() {
        // System.out.println("Opening doll of size " + size);
        // Maybe some other actions are performed
    }
}
