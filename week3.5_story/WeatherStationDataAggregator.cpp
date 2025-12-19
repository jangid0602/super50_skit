/**
 * @filename   : WeatherStationDataAggregator.cpp
 * @description: Count how many days set a new temperature record .
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;



int countRecordDays(const vector<int>& temperatures) {

    int maximumTempTillPreviousDay=INT_MIN;
    int recordDays=0;

    for(auto currentTemperature:temperatures ){

            if(currentTemperature>maximumTempTillPreviousDay){
                    recordDays+=1;
                    maximumTempTillPreviousDay=currentTemperature;
            }
    }
   
    return recordDays;
}



int main() {
    int numberOfDays;
    cin >> numberOfDays;   

    vector<int> temperatures(numberOfDays);
    for (int i = 0; i < numberOfDays; i++) {
        cin >> temperatures[i];
    }

    cout << countRecordDays(temperatures) << endl;

    return 0;
}
