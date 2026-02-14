/**
 * @filename - Task1.cpp
 * @description -  The Russian Doll Mystery
 * @author - Ayushi Shukla
 */

#include <iostream>
using namespace std;

void findKey(int dollSize, bool hasKey)
{
    // Base case: smallest doll
    if (dollSize == 1)
    {
        if (hasKey)
        {
            cout << "Key Found";
        }
        else
        {
            cout << "Key Not Found";
        }
        return;
    }

    // Recursive call to open smaller doll
    cout << "Opening Doll " << dollSize << endl;
    findKey(dollSize - 1, hasKey);
}

int main()
{
    int startingDollSize;
    bool keyInSmallestDoll;

    cout << "Enter the size of the outermost doll: ";
    cin >> startingDollSize;

    cout << "Is the key in the smallest doll? (1 for Yes, 0 for No): ";
    cin >> keyInSmallestDoll;

    findKey(startingDollSize, keyInSmallestDoll);

    return 0;
}