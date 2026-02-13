/**
 * @filename - story7.cpp
 * @description - path with maximum average weight
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;
double maximumAveragePath = INT_MIN;
void dfsSolution(vector<vector<pair<int, int>>> &adjacencyList, int source, int destination, vector<bool> &visited, int currentPath, int pathLength)
{
    if (source == destination)
    {
        double average = (double)currentPath / pathLength;
        maximumAveragePath = max(maximumAveragePath, average);
        return;
    }
    visited[source] = true;
    for (auto &edge : adjacencyList[source])
    {
        if (!visited[edge.first])
        {
            dfsSolution(adjacencyList, edge.first, destination, visited, currentPath + edge.second, pathLength + 1);
        }
    }
    visited[source] = false;
}
int main()
{
    int nodes;
    int edges;
    cout << "Enter number of nodes : ";
    cin >> nodes;
    cout << "Enter number of edges in graph : ";
    cin >> edges;
    vector<vector<pair<int, int>>> adjacencyList(nodes);
    cout << "Enter source and destination with weight (source, destination, weight) source and destination nodes should be between 0 and " << nodes - 1 << ": " << endl;
    for (int i = 0; i < edges; i++)
    {
        int source, destination, weight;
        cout << "Enter for " << i + 1 << " th edge";
        cin >> source >> destination >> weight;
        adjacencyList[source].push_back({destination, weight});
    }

    int source, destination;
    cout << "Enter source node: ";
    cin >> source;
    cout << "Enter destination node: ";
    cin >> destination;

    vector<bool> visited(nodes, false);
    dfsSolution(adjacencyList, source, destination, visited, 0, 0);

    cout << "Maximum average path weight: " << maximumAveragePath << endl;

    return 0;
}