import java.util.*;

class Memory {
    private static int total_memory = 0;
    private int memory;

    public Memory(int x) {
        this.memory = x;
        total_memory += x;
    }

    public int getMemory() {
        return this.memory;
    }

    public void free() {
        total_memory -= this.memory;
        this.memory = 0;
    }

    public void allocate(){
        total_memory += this.memory; 
        this.memory = 0; 
    }

    public static int getTotalMemory() {
        return total_memory;
    }
}
