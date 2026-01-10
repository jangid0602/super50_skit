/**
 * @filename   : StaircaseArchitect.cpp
 * @description: Calculate number of ways to climb stairs using recursion.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

int countWays(int n)
{
    // Base cases
    if (n == 0 || n == 1)
        return 1;

    int jumpOneStair = countWays(n - 1);
    int jumpTwoStair = countWays(n - 2);

    return jumpOneStair + jumpTwoStair;
}

int main()
{
    int NthStair = 3;
    cout << countWays(NthStair) << endl;
    return 0;
}
