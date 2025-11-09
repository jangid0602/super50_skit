/**
 * @filename - Story4.cpp
 * @description - The Efficient Traveler 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int function(vector<int>& energyCosts, int initialEnergy) {
        int n = energyCosts.size();   // total number of tasks/elements
        int completedTasks = 0;       // counter for how many tasks can be completed

        for (int i = 0; i < n; i++) {
            // If player still has non-negative energy, they can perform the task
            if (initialEnergy >= 0) {
                completedTasks++;                 // increment completed task count
                initialEnergy -= energyCosts[i];  // reduce remaining energy
            }
        }

        // Subtract 1 because the loop counts one extra task even when energy becomes negative
        return completedTasks - 1;
    }
};

int main() {
    int size;
    cout << "Enter size of array: ";
    cin >> size;

    vector<int> energyCosts(size);  // stores energy required for each task
    cout << "Enter energy costs for each task: ";
    for (int i = 0; i < size; i++) {
        cin >> energyCosts[i];
    }

    int initialEnergy;
    cout << "Enter initial energy: ";
    cin >> initialEnergy;

    Solution obj;
    int result = obj.function(energyCosts, initialEnergy);

    cout << "Number of tasks that can be completed: " << result;
    return 0;
}
