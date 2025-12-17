/**
 * @filename - Task-5.cpp
 * @description - The Concert Seat Manager 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <unordered_set>
#include <string>
using namespace std;

int main() {
    int totalSeatRequests;
    cout << "Enter total Requests ";
    cin >> totalSeatRequests;

    unordered_set<int> allocatedSeats;

    for (int requestIndex = 0; requestIndex < totalSeatRequests; requestIndex++) {
        string customerId;
        int requestedSeatNumber;
        cout << "Enter Customer id and seatNumber :";
        cin >> customerId >> requestedSeatNumber;

        // Check if seat has already been assigned
        if (allocatedSeats.find(requestedSeatNumber) != allocatedSeats.end()) {
            cout << customerId;
            return 0;
        }

        // Assign seat
        allocatedSeats.insert(requestedSeatNumber);
    }

    // No duplicate seat request found
    cout << -1;
    return 0;
}
