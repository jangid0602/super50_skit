package Challenge1;

public class Memory {
    public int memoryTaken;
    private static int totalMemoryUsed = 0;
    public Memory(int memoryTaken){
        this.memoryTaken = memoryTaken;
        totalMemoryUsed+=memoryTaken;
    }
    public void allocate(int memory){
        this.memoryTaken+= memory;
        totalMemoryUsed+=memory;
    }
    public void free(int memory){
        this.memoryTaken-= memory;
        totalMemoryUsed-=memory;
    }
    public static void showTotalMemory() {
        System.out.println("Total Memory: " + totalMemoryUsed);
    }
}


    