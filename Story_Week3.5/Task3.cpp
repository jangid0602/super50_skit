/* @file: Task3.cpp
@Description: The Factory Floor Robot
@Author: Ayushi Shukla */

#include <iostream>
#include <vector>
using namespace std;
int main()
{
    // Input number of items
    int items;
    cout << "Enter number of items:";
    cin >> items;
    // Input weights of items
    vector<int> weights(items);
    cout << "enter weight of items: ";
    for (int i = 0; i < items; i++)
    {
        cin >> weights[i];
    }
    cout << "Output labels: ";
    for (int i = 0; i < items; i++)
    {
        if (weights[i] % 15 == 0)
        {
            cout << "Hazardous ";
        }
        else if (weights[i] % 3 == 0)
        {
            cout << "Heavy ";
        }
        else if (weights[i] % 5 == 0)
        {
            cout << "Fragile ";
        }
        else
        {
            cout << weights[i] << " "; // print weight if none of the conditions match
        }
    }
}