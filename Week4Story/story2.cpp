/**
 * @filename - Story2.cpp
 * @description -  Fibonnaci style recursion
 * @author - Fatimi Bee
 */

#include <iostream>

using namespace std;

void countWays(int n, int &count)
{

    if (n == 0)
    {
        count++;
        return;
    }
    if (n < 0)
    {
        return;
    }

    countWays(n - 1, count);
    countWays(n - 2, count);
}
int main()
{

    int stairs;
    cout << "Enter number of stairs: ";
    cin >> stairs;

    int count = 0;
    countWays(stairs, count);
    cout << "Number of ways to climb stairs: " << count << endl;
}