import java.util.*;

class Memory {
    static int total_memory;

    Memory() {
        total_memory = 0;
    }

    Memory(int total_memory) {
        this.total_memory += total_memory;
    }

    void show() {
        System.out.println("the total_allocated memory is:" + total_memory);
    }

    void free() {
        total_memory = 0;
    }
}

class Challenge1setaques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println("enter value:");
            int memory = sc.nextInt();
        } else {
            System.out.println("enter correct value");
        }
        Memory m = new Memory(10);
        m.show();
        m.free();
        m.show();

    }
}