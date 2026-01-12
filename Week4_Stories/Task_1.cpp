/**
 * @filename - Task-1.cpp
 * @description - The Russian Doll Mystery
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

string findKey(int size)
{
    if (size == 1)
    {
        return "Key Found";
    }

    return findKey(size - 1);
}

int main()
{
    int dollSize;
    cin >> dollSize;

    cout << findKey(dollSize);
    return 0;
}
