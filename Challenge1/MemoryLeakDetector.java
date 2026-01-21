package Challenge1;
import java.util.Scanner;

public class MemoryLeakDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Memory memory = new Memory(0);

        while (sc.hasNext()) {
            String command = sc.next();

            if (command.equalsIgnoreCase("ALLOCATE")) {
                int size = sc.nextInt();
                if(size<=0) System.out.println("Zero or negative memory cannot be allocated");
                else memory.allocate(size);
            } 
            else if (command.equalsIgnoreCase("FREE")) {
                int size = sc.nextInt();
                if(size>memory.memoryTaken) System.out.println("Cannot free more than allocated memory");
                else memory.free(size);
            } 
            else if (command.equalsIgnoreCase("SHOW")) {
                Memory.showTotalMemory();
            }else{
                System.out.println("Invalid command ..");
            }
        }
        sc.close();
    }
}

