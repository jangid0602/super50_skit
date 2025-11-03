package Test1;

public class MyMemory {
    private int total_memory = 0;

    MyMemory() {
        this.total_memory += 0;
    }

    void allocate(int allocate_memory) {
        if (allocate_memory <= 0) {
            System.out.println("Allocation not pssible. Memory must be a positive integer.");
        }
        this.total_memory += allocate_memory;
    }

    void free(int remove_memory) {

        if (total_memory == 0 || total_memory < remove_memory) {
            System.out.println("Deallocation not possible!");
            return;
        }

        total_memory = total_memory - remove_memory;
    }

    int show() {
        return total_memory;
    }
}
