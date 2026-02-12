/**
 * @filename - Story5.cpp
 * @description -  THE Concert Seat Manager
 * @author - Fatimi Bee
 */
#include<iostream>
#include<vector>
#include<map>
using namespace std;

int main(){
    map<string,string>seatMap;
    while(true){
        string seatCode;
        string customerID;
        // enter seat number and customer id

        cout<<"Enter customer ID for seat : ";
        getline(cin,customerID);

        cout<<"Enter seat id (or 'q' to quit): ";
        getline(cin,seatCode);

        if(seatCode == "q"){
            cout<<"Exiting the seat manager."<<endl;
            break;
        }
        
         if (seatMap.find(seatCode) != seatMap.end()) {
            cout << "Duplicate detected! Seat " << seatCode 
                 << " is already booked by " << seatMap[seatCode] << "." << endl;
            cout << "Returning -1 as first duplicate seat request." << endl;
            return -1;  // First duplicate detected
        } else {
            seatMap[seatCode] = customerID; 
            cout << "Seat " << seatCode << " booked successfully for " << customerID << "." << endl;
        }
    }

    cout << "No duplicate seat request detected." << endl;
    return 0;
}
