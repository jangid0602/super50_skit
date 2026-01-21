/**
 * @filename - Task-6.cpp
 * @description - Weather Station Data Aggregator
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
using namespace std;

int countRecordDays(vector<int>& temperatures) {
    if (temperatures.size() == 0) return 0;

    int recordCount = 1;
    int maximumTemperature = temperatures[0];

    for (int index = 1; index < temperatures.size(); index++) {
        if (temperatures[index] > maximumTemperature) {
            recordCount++;
            maximumTemperature = temperatures[index];
        }
    }

    return recordCount;
}

int main() {
    vector<int> temperatures = {15, 22, 15, 30, 28, 31};
    cout << countRecordDays(temperatures) << endl;
    return 0;
}

