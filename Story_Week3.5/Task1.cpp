/* @file: Task3.cpp
@Description: The Cosmic Courier Challenge
@Author: Ayushi Shukla */
#include <iostream>
#include <climits>
#include <vector>
using namespace std;
int main()
{
    int totalRoutes;
    cout << "Enter number of routes: ";
    cin >> totalRoutes;
    // Handle case when there are no routes
    if (totalRoutes == 0)
    {
        cout << "No routes available";
        return 0;
    }
    vector<int> distances(totalRoutes);
    cout << "Enter distances of routes: ";
    for (int i = 0; i < totalRoutes; i++)
    {
        cin >> distances[i];
    }
    int maximum1 = INT_MIN;
    int maximum2 = INT_MIN;
    int countMax = 0; // to count occurrences of the longest distance
    for (int i = 0; i < totalRoutes; i++)
    {
        if (distances[i] > maximum1)
        {
            maximum2 = maximum1;
            maximum1 = distances[i];
            countMax = 1; //
        }
        // Handle case where current distance equals the maximum distance
        else if (distances[i] == maximum1)
        {
            countMax++;
        }
        // Handle case for second maximum
        else if (distances[i] > maximum2)
        {
            maximum2 = distances[i];
        }
    }

    if (countMax > 1)
    {
        cout << "Second longest route distance: " << maximum1;
    }
    else
    {
        if (maximum2 == INT_MIN)
        {
            cout << "Second longest route distance: No second longest route";
        }
        else
        {
            cout << "Second longest route distance: " << maximum2;
        }
    }
}
