/**
 * @filename    - Story1.cpp
 * @description - The Efficient Traveler
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
using namespace std;

int EfficientTraveler(vector<int>& nums, int initialEnergy) {
    int energy = initialEnergy, farthest = -1;
    for (int i = 0; i < nums.size(); i++) {
        energy -= nums[i];
        if (energy < 0) break;
        farthest = i;
    }
    return farthest;
}

int main() {
    int n, energy;
    cout << "Enter number of cities: ";
    cin >> n;
    vector<int> nums(n);
    cout << "Enter energy costs: ";
    for (int i = 0; i < n; i++) cin >> nums[i];
    cout << "Enter initial energy: ";
    cin >> energy;
    cout << "Farthest city reachable: " << EfficientTraveler(nums, energy) << endl;
}
