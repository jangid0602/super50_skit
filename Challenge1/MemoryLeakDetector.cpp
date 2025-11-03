#include <iostream>
using namespace std;

class Memory {
public:
    static int total_memory;//Here we made this static so that it is shared among all objects
    int value;//Here each object will have its own size
    Memory(int x) {
        value= x;
        total_memory += x;
    }

    void free() {
        total_memory -= value;
        value= 0;
    }

    static void show() {//Static function can access only static members and also we want total_memory that is shared among al object and if it was non static function we had to create an object to call it.
        cout << "Total Memory: " << total_memory << endl;
    }
};

int Memory::total_memory = 0;

int main() {
    string command;
    Memory* obj[100];//Making array of pointers to Memory objects so we can create objects dynamically using new keyword and later free them using delete keyword. An actual Object array will take memory for all objects at once and we cannnot free individual objects.
    int count = 0;
    while (cin >> command) {
        if (command == "ALLOCATE") {
            int x;
            cin >> x;
            obj[count] = new Memory(x);
            count++;
        } 
        else if (command == "FREE") {
            int x;
            cin >> x;

            // find and free the first matching allocation
            for (int i = 0; i < count; i++) {//We are iterating through all the created objects to find the one with value x
                if (obj[i] != nullptr && obj[i]->value == x) {
                    obj[i]->free();
                    delete obj[i];
                    obj[i] = nullptr;
                    break;
                }
            }
        } 
        else if (command == "SHOW") {
            Memory::show();
        }
    }
    return 0;
}
