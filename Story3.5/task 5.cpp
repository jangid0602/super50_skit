/**
 * @filename - Task-5.cpp
 * @description - The Concert Seat Manager
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

string findDuplicateCustomer(vector<pair<string, int>>& requests) {
    vector<int> occupiedSeats;

    for (auto request : requests) {
        for (int seat : occupiedSeats) {
            if (seat == request.second) {
                return request.first;
            }
        }
        occupiedSeats.push_back(request.second);
    }

    return "-1";
}

int main() {
    vector<pair<string, int>> requests = {
        {"C1", 101}, {"C2", 105}, {"C3", 101}
    };

    cout << findDuplicateCustomer(requests) << endl;
    return 0;
}

