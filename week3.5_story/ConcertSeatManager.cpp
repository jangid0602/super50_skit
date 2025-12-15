/**
 * @filename   : ConcertSeatManager.cpp
 * @description: Detect the first customer who requests a seat that has already been assigned.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;



string findFirstDuplicateSeat(const vector<pair<string, int>>& requests) {
  
   unordered_map<int,string>assignedSeats;

            for(auto [customerId,seatNumber]:requests){
                if(assignedSeats.find(seatNumber)!=assignedSeats.end()){
                    return customerId;
                }else{
                    assignedSeats[seatNumber]=customerId;

                }
            }

            return "-1";
}

int main() {
    int numberOfRequests;
    cin >> numberOfRequests;   

    vector<pair<string, int>> requests;
    for (int i = 0; i < numberOfRequests; i++) {
        string customerId;
        int seatNumber;
        cin >> customerId >> seatNumber;
        requests.push_back({customerId, seatNumber});
    }

    cout << findFirstDuplicateSeat(requests) << endl;

    return 0;
}
