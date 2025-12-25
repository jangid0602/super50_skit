/* @file: Task3.cpp
@Description: The Weather Station Data Aggregator
@Author: Ayushi Shukla */
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int days;
    cout << "Enter number of days: ";
    cin >> days;
    if (days == 0)
    {
        cout << "No data to process";
        return 0;
    }
    vector<double> temperatures(days);
    cout << "Enter temperatures: ";
    for (int i = 0; i < days; i++)
    {
        cin >> temperatures[i];
    }
    int recordDays = 1; // First day is always a record
    double maximumTemperature = temperatures[0];
    for (int i = 1; i < days; i++)
    {
        if (temperatures[i] > maximumTemperature)
        {
            recordDays++;
            maximumTemperature = temperatures[i];
        }
    }
    cout << "Number of record-breaking days: " << recordDays;
}