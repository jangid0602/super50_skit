/**
 * @filename - Task2.cpp
 * @description - The Staircase Architect
 * @author - Ayushi Shukla
 */

#include <iostream>
using namespace std;
int stairCase(int steps)
{
   if (steps == 0 || steps == 1)
      return 1;
   return stairCase(steps - 1) + stairCase(steps - 2);
}
int main()
{
   int steps;
   cout << "Enter the number of steps : ";
   cin >> steps;
   cout << "Number of ways to climb the staircase is : " << stairCase(steps) << endl;
   return 0;
}
