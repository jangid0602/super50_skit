/**
 * @filename - Task2.cpp
 * @description -   Find the Safest Path in a City
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

class SafestPathFinder
{
public:
    int findSafestPath(
        int totalCities,
        vector<vector<int>> &edges,
        int startCity,
        int endCity)
    {
        // Step 1: Create adjacency list
        vector<vector<pair<int, int>>> adjacencyList(totalCities);

        for (int i = 0; i < edges.size(); i++)
        {
            int cityA = edges[i][0];
            int cityB = edges[i][1];
            int risk = edges[i][2];

            adjacencyList[cityA].push_back({cityB, risk});
            adjacencyList[cityB].push_back({cityA, risk});
        }

        // Step 2: Store minimum possible risk to reach each city
        vector<int> minimumRisk(totalCities, INT_MAX);
        minimumRisk[startCity] = 0;

        // Min-heap based on risk
        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>>
            minHeap;

        minHeap.push({0, startCity});

        // Step 3: Modified Dijkstra
        while (!minHeap.empty())
        {
            int currentRisk = minHeap.top().first;
            int currentCity = minHeap.top().second;
            minHeap.pop();

            if (currentCity == endCity)
                return currentRisk;

            for (auto neighbor : adjacencyList[currentCity])
            {
                int nextCity = neighbor.first;
                int edgeRisk = neighbor.second;

                int pathRisk = max(currentRisk, edgeRisk);

                if (pathRisk < minimumRisk[nextCity])
                {
                    minimumRisk[nextCity] = pathRisk;
                    minHeap.push({pathRisk, nextCity});
                }
            }
        }

        return -1; // destination unreachable
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(3));
    cout << "Enter edges (city1 city2 risk):\n";
    for (int i = 0; i < totalEdges; i++)
    {
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];
    }

    int startCity, endCity;
    cout << "Enter start and end city: ";
    cin >> startCity >> endCity;

    int totalCities = 0;
    for (auto e : edges)
        totalCities = max(totalCities, max(e[0], e[1]) + 1);

    SafestPathFinder finder;
    cout << "Safest Path Risk: "
         << finder.findSafestPath(totalCities, edges, startCity, endCity);

    return 0;
}