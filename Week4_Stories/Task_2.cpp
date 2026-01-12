/**
 * @filename - Task-2.cpp
 * @description - The Staircase Architect
 * @author - Diya Garg
 */

#include <iostream>
using namespace std;

int count(int n)
{
    if (n < 0)
    {
        return 0;
    }
    if (n == 0 || n == 1)
    {
        return 1;
    }
    return count(n - 1) + count(n - 2);
}

int main()
{
    int n;
    cout << "Enter the number of stairs: ";
    cin >> n;

    int result = count(n);
    cout << "Total distinct ways: " << result << endl;

    return 0;
}