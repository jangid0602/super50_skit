/**
 * @filename - Task-1.cpp
 * @description -  The Cosmic Courier Challenge
 * @author - Diya Garg 
 */
#include<iostream>
#include<vector>
#include<climits>
using namespace std;

int findSecondLargest(vector<int>& travelTimes) {
    if(travelTimes.size() == 1){
        return travelTimes[0];
    }

    int largestTime = INT_MIN;
    int secondLargestTime = INT_MIN;

    for(int i = 0; i < travelTimes.size(); i++){
        if(largestTime < travelTimes[i]){
            secondLargestTime = largestTime;
            largestTime = travelTimes[i];
        }
        if(travelTimes[i] < largestTime && travelTimes[i] > secondLargestTime){
            secondLargestTime = travelTimes[i];
        }
    }
    return secondLargestTime;
}

int main(){
    int arraySize;
    cout << "Enter size of array :";
    cin >> arraySize;

    vector<int> travelTimes(arraySize);
    cout << "Enter a list of route travel times:\n";
    for(int i = 0; i < arraySize; i++){
        cin >> travelTimes[i];
    }

    cout << "The minimum possible deadline is:" 
         << findSecondLargest(travelTimes) << endl;

    return 0;
}
