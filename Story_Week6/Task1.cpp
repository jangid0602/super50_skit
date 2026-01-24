/**
 * @filename - Task1.cpp
 * @description -   Cheapest Flight Within K Stops
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

class FlightRoute
{
public:
    int destinationCity;
    int ticketPrice;

    FlightRoute(int destination, int price)
    {
        destinationCity = destination;
        ticketPrice = price;
    }
};

class CheapestFlightFinder
{
public:
    int findMinimumCost(
        int totalCities,
        vector<vector<int>> &flightData,
        int sourceCity,
        int destinationCity,
        int maxStops)
    {
        // Step 1: Create adjacency list
        vector<vector<FlightRoute>> adjacencyList(totalCities);

        for (int i = 0; i < flightData.size(); i++)
        {
            int fromCity = flightData[i][0];
            int toCity = flightData[i][1];
            int price = flightData[i][2];

            adjacencyList[fromCity].push_back(
                FlightRoute(toCity, price));
        }

        // Step 2: Store minimum cost to reach each city
        vector<int> minimumCost(totalCities, INT_MAX);
        minimumCost[sourceCity] = 0;

        // Queue stores (currentCity, costSoFar)
        queue<pair<int, int>> nodeQueue;
        nodeQueue.push(make_pair(sourceCity, 0));

        int currentStops = 0;

        // Step 3: BFS traversal (each level = one stop)
        while (!nodeQueue.empty() && currentStops <= maxStops)
        {
            int levelSize = nodeQueue.size();
            vector<int> tempCost = minimumCost;

            for (int i = 0; i < levelSize; i++)
            {
                int currentCity = nodeQueue.front().first;
                int costSoFar = nodeQueue.front().second;
                nodeQueue.pop();

                for (int j = 0; j < adjacencyList[currentCity].size(); j++)
                {
                    int nextCity = adjacencyList[currentCity][j].destinationCity;
                    int flightPrice = adjacencyList[currentCity][j].ticketPrice;

                    int newCost = costSoFar + flightPrice;

                    if (newCost < tempCost[nextCity])
                    {
                        tempCost[nextCity] = newCost;
                        nodeQueue.push(make_pair(nextCity, newCost));
                    }
                }
            }

            minimumCost = tempCost;
            currentStops++;
        }

        if (minimumCost[destinationCity] == INT_MAX)
            return -1;

        return minimumCost[destinationCity];
    }
};

int main()
{
    int totalCities;
    int totalFlights;

    cout << "Enter number of cities and flights:\n";
    cin >> totalCities >> totalFlights;

    vector<vector<int>> flightData(totalFlights, vector<int>(3));
    cout << "Enter flight details (from to price):\n";
    for (int i = 0; i < totalFlights; i++)
    {
        cin >> flightData[i][0]
            >> flightData[i][1]
            >> flightData[i][2];
    }

    int sourceCity;
    int destinationCity;
    int maxStops;

    cout << "Enter source, destination and max stops:\n";
    cin >> sourceCity >> destinationCity >> maxStops;

    CheapestFlightFinder finder;
    int result = finder.findMinimumCost(
        totalCities,
        flightData,
        sourceCity,
        destinationCity,
        maxStops);

    cout << "\nCheapest Flight Cost: " << result << endl;

    return 0;
}