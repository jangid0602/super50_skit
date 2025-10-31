/**
 * @filename    - Story4.cpp
 * @description - The Odd One Out
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int OddOneOut(vector<int>& element) {
    sort(element.begin(), element.end());
    for (int i = 0; i < element.size();) {
        int count = 1;
        while (i + 1 < element.size() && element[i] == element[i + 1]) {
            count++; i++;
        }
        if (count == 1) return element[i];
        i++;
    }
    return -1;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<int> elements(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> elements[i];
    cout << "The odd one out is: " << OddOneOut(elements) << endl;
}
