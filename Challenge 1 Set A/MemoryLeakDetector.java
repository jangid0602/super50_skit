import java.util.*; 

public class MemoryLeakDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Memory> memoryList = new ArrayList<>();

        do {
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            if (parts[0].equals("ALLOCATE")) {
                int x = Integer.parseInt(parts[1]);
                memoryList.add(new Memory(x));
            } 
            else if (parts[0].equals("FREE")) {
                int x = Integer.parseInt(parts[1]);
                // Find the first Memory object with matching size and free it
                for (int i = 0; i < memoryList.size(); i++) {
                    Memory mem = memoryList.get(i);
                    if (mem.getMemory() == x) {
                        mem.free();
                        memoryList.remove(i);
                        break;
                    }
                }
            } 
            else if (parts[0].equals("SHOW")) {
                System.out.println(Memory.getTotalMemory());
            }

        } while (scanner.hasNextLine());
        scanner.close();
    }
}
