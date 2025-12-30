/**
 * @filename - Task-6.cpp
 * @description - The Weather Station Data Aggregator 
 * @author - Disha Toshniwal 
 */
#include<iostream>
#include<vector>
using namespace std;

int main(){
    int arraySize;
    cout << "Enter size :";
    cin >> arraySize;

    vector<int> temperatureReadings(arraySize);
    cout << "Enter elements of array :";
    for(int index = 0; index < arraySize; index++){
        cin >> temperatureReadings[index];
    }

    int previousReading = temperatureReadings[0];
    int increasingCount = 1;

    for(int index = 1; index < arraySize; index++){
        if(temperatureReadings[index] > previousReading){
            previousReading = temperatureReadings[index];
            increasingCount++;
        }
    }

    cout << increasingCount;  
    return 0; 
}
