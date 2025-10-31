/**
 * @filename - Story6.cpp
 * @description - The Minimalist Painter
 * @author - Fatimi Bee 
 */
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int MinimalistPainter(vector<int>& time) {
    int size = time.size();
    if (size <= 1) return 0;
    int total_time = 0, max_time = 0;
    for (int val : time) {
        total_time += val;
        max_time = max(max_time, val);
    }
    return total_time - max_time;
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
        int time_value;
        cin>>time_value;
        time.push_back(time_value);
    }
    // Function call and output
    cout << "Minimum time to paint all (skipping one): "
            << MinimalistPainter(time) << endl;
}