/**
 * @file Memory.java
 * @description This class simulates memory allocation and deallocation. It keeps track of the total allocated memory and provides methods to allocate, free, and display the allocated memory.
 * @author - Aman jeet Singh
 */
public class Memory {
    static int allocated;
    void allocate(int size) {
        allocated += size;
    }
    void free(int size) {
        if (size > allocated) {
            System.out.println("!!!\nCannot free more memory than allocated.\n!!!");
            return;
        }
        allocated -= size;
    }
    void show() {
        System.out.println("Allocated memory: " + allocated + " bytes");
    }
    
}
