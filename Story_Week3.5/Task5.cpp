/* @file: Task3.cpp
@Description: The Concert Seat Manager
@Author: Ayushi Shukla */
#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;
int main()
{
    int requests;
    cout << "Enter number of seat requests: ";
    cin >> requests;
    unordered_set<int> bookedSeats;
    string customerID;
    int seatNumber;
    for (int i = 0; i < requests; i++)
    {
        cin >> customerID >> seatNumber;
        // Check if the seat is already booked
        if (bookedSeats.count(seatNumber))
        {
            cout << customerID;
            return 0;
        }
        bookedSeats.insert(seatNumber);
        cout << "Seat " << seatNumber << " successfully booked for " << customerID << "." << endl;
    }
    cout << -1; // No duplicate seat request found
    return 0;
}