/**
 * @filename - Story6.cpp
 * @description - The Minimalist Painter
 * @author - Fatimi Bee 
 */
#include <iostream>
#include <vector>
using namespace std;

int minimalistPainter(vector<int>& time) {
    int size = time.size();
    if (size <= 1) return 0;
    int totalTime = 0, maximumTime = 0;
    for (int value : time) {
        totalTime += value;
        maximumTime = max(maximumTime, value);
    }
    return totalTime - maximumTime;
}

// Mainn function
int main(){
    // Input
    vector<int> time;
    cout << "Enter number of walls: ";
    int size ;
    cin>>size;

    cout << "Enter painting times: ";
    for (int i = 0; i < size; i++) 
    {
        int timeValue;
        cin>>timeValue;
        time.push_back(timeValue);
    }
    // Function call and output
    cout << "Minimum time to paint all (skipping one): "
            << minimalistPainter(time) << endl;
}