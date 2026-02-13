/**
 * @filename - story1.cpp
 * @description - Cheapest flight within K stops
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int findCheapestFlightWithinKStops(
    int numberOfCities,
    int sourceCity,
    int destinationCity,
    int maxStops,
    vector<vector<pair<int, int>>> &adjacencyList)
{

    priority_queue<
        vector<int>,
        vector<vector<int>>,
        greater<>>
        minHeap;

    minHeap.push({0, sourceCity, 0});

    vector<vector<int>> minimumCost(
        numberOfCities,
        vector<int>(maxStops + 2, INT_MAX));

    minimumCost[sourceCity][0] = 0;

    while (!minHeap.empty())
    {
        auto currentState = minHeap.top();
        minHeap.pop();

        int currentCost = currentState[0];
        int currentCity = currentState[1];
        int stopsUsed = currentState[2];

        if (currentCity == destinationCity)
            return currentCost;

        if (stopsUsed > maxStops)
            continue;

        for (auto &flight : adjacencyList[currentCity])
        {
            int nextCity = flight.first;
            int flightCost = flight.second;

            if (currentCost + flightCost <
                minimumCost[nextCity][stopsUsed + 1])
            {
                minimumCost[nextCity][stopsUsed + 1] =
                    currentCost + flightCost;

                minHeap.push({minimumCost[nextCity][stopsUsed + 1],
                              nextCity,
                              stopsUsed + 1});
            }
        }
    }

    return -1;
}

int main()
{
    int numberOfCities;
    cout << "Enter number of cities: ";
    cin >> numberOfCities;

    int numberOfFlights;
    cout << "Enter number of flights: ";
    cin >> numberOfFlights;

    vector<vector<pair<int, int>>> adjacencyList(numberOfCities);

    cout << "Enter flights (from to price):\n";
    for (int i = 0; i < numberOfFlights; i++)
    {
        int fromCity, toCity, price;
        cin >> fromCity >> toCity >> price;
        adjacencyList[fromCity].push_back({toCity, price});
    }

    int sourceCity, destinationCity, maxStops;
    cout << "Enter source, destination, max stops: ";
    cin >> sourceCity >> destinationCity >> maxStops;

    int cheapestPrice =
        findCheapestFlightWithinKStops(
            numberOfCities,
            sourceCity,
            destinationCity,
            maxStops,
            adjacencyList);

    if (cheapestPrice == -1)
        cout << "No valid route found\n";
    else
        cout << "Cheapest price: " << cheapestPrice << endl;

    return 0;
}
