/**
 * @filename - Story3.cpp
 * @description - Flip the Switch
 * @author - Fatimi Bee 
 */
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int flips(vector<int>& switches) {
    int zeros = 0, ones = 0;
    for (int val : switches) {
        if (val == 0)
            zeros++;
        else
            ones++;
    }
    return min(zeros, ones);
}



// Mainn function
int main()
{
    // Input 

    vector<int> switches;
    cout << "Enter number of binary values: ";
    int size ;
    cin>>size;

    cout << "Enter 0s and 1s: ";
    for (int i = 0; i < size; i++) {
        int value;
        cin>>value;
        switches.push_back(value);
    }
    // Function call and output
    cout << "Minimum flips required: " << flips(switches) << endl;
    
}