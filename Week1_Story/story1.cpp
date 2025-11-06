/**
 * @filename - Story1.cpp
 * @description - The Efficient Traveler 
 * @author - Fatimi Bee 
 */

#include <iostream>
#include <vector>
using namespace std;

int efficientEnergyCalculation(vector<int>& energy, int initialEnergy) {
    int n = energy.size();
    int countedCity = 0;
    for (int i = 0; i < n; i++) {
        if (initialEnergy > 0 && initialEnergy >= energy[i]) {
            countedCity++;
            initialEnergy -= energy[i];
        } else {
            break;
        }
    }
    return countedCity;
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
        int value;
        cin>>value;
        energy.push_back(value);
    }
    cout << "Enter initial energy: ";
    int initialEnergy;
    cin>>initialEnergy;

    // Function calll and output
    cout << "Maximum cities that can be visited: "
        << efficientEnergyCalculation(energy, initialEnergy) << endl;
}