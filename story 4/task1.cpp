/**
 * @filename - Task1.cpp
 * @description - The Russian Doll Mystery (Recursion)
 * @author - Disha Toshniwal 
 */
#include <iostream>
using namespace std;

void findKey(int dollSize, bool hasKey)
{
    if (dollSize == 1)
    {
        cout << "Reached smallest doll..." << endl;
        cout << (hasKey ? "Key Found!" : "Key Not Found!");
        return;
    }

    cout << "Opening doll of size " << dollSize << "..." << endl;
    findKey(dollSize - 1, hasKey);
}

int main()
{
    int size;
    bool hasKey;

    cout << "Enter size of outer doll: ";
    cin >> size;

    cout << "Is key in smallest doll? (1 = Yes, 0 = No): ";
    cin >> hasKey;

    cout << "\n--- Searching ---\n";
    findKey(size, hasKey);

    return 0;
}
