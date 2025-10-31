/**
 * @filename    - Story6.cpp
 * @description - The Minimalist Painter
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
using namespace std;

int MinimalistPainter(vector<int>& time) {
    int total = 0, maxVal = 0;
    for (int t : time) {
        total += t;
        if (t > maxVal) maxVal = t;
    }
    return total - maxVal;
}

int main() {
    int n;
    cout << "Enter number of walls: ";
    cin >> n;
    vector<int> time(n);
    cout << "Enter painting times: ";
    for (int i = 0; i < n; i++) cin >> time[i];
    cout << "Minimum total time after skipping one wall: " 
         << MinimalistPainter(time) << endl;
}
