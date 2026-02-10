/**
 * @filename - Task-1.cpp
 * @description -  The Startup Revenue Maxima 
 * @author - Disha Toshniwal
 */
#include<iostream>
#include<vector>
using namespace std;

int solve(int currentIndex, vector<int>& values, vector<int>& memoDP){
    if(currentIndex < 0) return 0;

    if(memoDP[currentIndex] != -1) 
        return memoDP[currentIndex];

    int takeCurrent = 0;

    if(currentIndex % 7 == 0){
        takeCurrent = 2 * values[currentIndex] + 
                      solve(currentIndex - 2, values, memoDP);
    }
    else{
        takeCurrent = values[currentIndex] + 
                      solve(currentIndex - 2, values, memoDP);
    }

    int skipCurrent = solve(currentIndex - 1, values, memoDP);

    return memoDP[currentIndex] = max(takeCurrent, skipCurrent);
}

int main(){
    int numberOfElements;
    cout << "Enter number of elements in the array: ";
    cin >> numberOfElements;

    vector<int> arrayValues(numberOfElements);
    cout << "Enter the elements of the array: ";
    for(int i = 0; i < numberOfElements; i++){
        cin >> arrayValues[i];
    }

    vector<int> memoDP(numberOfElements + 1, -1);

    int maximumValue = solve(numberOfElements - 1, arrayValues, memoDP);

    cout << "Maximum value that can be obtained: " << maximumValue;

    return 0;
}
