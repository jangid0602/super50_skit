/**
 * @filename - Story1.cpp
 * @description - The Efficient Traveler 
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int EfficientEnergyCalculation(vector<int>& energy, int initialEnergy) {
    int n = energy.size();
    int counted_city = 0;
    for (int i = 0; i < n; i++) {
        if (initialEnergy > 0 && initialEnergy >= energy[i]) {
            counted_city++;
            initialEnergy -= energy[i];
        } else {
            break;
        }
    }
    return counted_city;
}

// Main function
int main() {
    // input
    int n;
    vector<int> energy;
    cout << "Enter number of cities: ";
    cin>>n;
    cout << "Enter energy values: ";
    for (int i = 0; i < n; i++) 
    {   
        int val;
        cin>>val;
        energy.push_back(val);
    }
    cout << "Enter initial energy: ";
    int initialEnergy;
    cin>>initialEnergy;

    // Function calll and output
    cout << "Maximum cities that can be visited: "
        << EfficientEnergyCalculation(energy, initialEnergy) << endl;
}