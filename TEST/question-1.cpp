#include <iostream>
using namespace std;

class Memory {
public:
    static int total_memory; 
    int memory_used;         

    
    Memory(int x) {
        memory_used = x;
        total_memory += x;
    }

    // Function to free this object's memory
    void free() {
        total_memory -= memory_used;
        memory_used = 0;
    }

    // Static function to show total memory
    static void show() {
        cout << "Total Memory: " << total_memory << endl;
    }
};

// Initialize static variable
int Memory::total_memory = 0;

int main() {
    int memory1, memory2, release;
    
    cout << "Enter first memory size: ";
    cin >> memory1;
    Memory obj1(memory1); // allocate mem1

    cout << "Enter second memory size: ";
    cin >> memory2;
    Memory obj2(memory2); // allocate mem2

    // Show total memory after allocation
    Memory::show();

    cout << "Enter memory to release (1 for obj1, 2 for obj2): ";
    cin >> release;

    if (release == 1)
        obj1.free();
    else if (release == 2)
        obj2.free();

    // Show total memory after free
    Memory::show();

    return 0;
}
