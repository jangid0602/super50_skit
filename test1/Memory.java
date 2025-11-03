package Java.openupvs.test1;

public class Memory {
    private int objectMemory;
    public static int total_memory=0;
    // public Memory()
    // {
    //     total_memory=total_memory+10;



    // }
    public void createObject()
    {
        total_memory=total_memory+10;
    }
    public int show()
    {
        return total_memory;
    }
    public void free()
    {
        total_memory=total_memory-10;
    }
}
