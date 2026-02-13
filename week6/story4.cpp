/**
 * @filename - story4.cpp
 * @description - Dijekstra using adjacency matrix
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

vector<int> findShortestDistanceUsingDijkstra(
    vector<vector<int>> &adjacencyMatrix,
    int numberOfNodes,
    int sourceNode)
{
    vector<int> shortestDistance(numberOfNodes, INT_MAX);
    vector<bool> visited(numberOfNodes, false);

    priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int, int>>>
        minHeap;

    shortestDistance[sourceNode] = 0;
    minHeap.push({0, sourceNode});

    while (!minHeap.empty())
    {
        int currentDistance = minHeap.top().first;
        int currentNode = minHeap.top().second;
        minHeap.pop();

        if (visited[currentNode])
            continue;

        visited[currentNode] = true;

        for (int neighborNode = 0; neighborNode < numberOfNodes; neighborNode++)
        {
            if (adjacencyMatrix[currentNode][neighborNode] != 0 &&
                !visited[neighborNode])
            {
                int newDistance =
                    currentDistance +
                    adjacencyMatrix[currentNode][neighborNode];

                if (newDistance < shortestDistance[neighborNode])
                {
                    shortestDistance[neighborNode] = newDistance;
                    minHeap.push({newDistance, neighborNode});
                }
            }
        }
    }

    return shortestDistance;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    vector<vector<int>> adjacencyMatrix(
        numberOfNodes,
        vector<int>(numberOfNodes));

    cout << "Enter adjacency matrix:\n";
    for (int i = 0; i < numberOfNodes; i++)
    {
        for (int j = 0; j < numberOfNodes; j++)
        {
            cin >> adjacencyMatrix[i][j];
        }
    }

    int sourceNode;
    cout << "Enter source node: ";
    cin >> sourceNode;

    vector<int> shortestDistance =
        findShortestDistanceUsingDijkstra(
            adjacencyMatrix,
            numberOfNodes,
            sourceNode);

    cout << "Shortest distance from source:\n";
    for (int i = 0; i < numberOfNodes; i++)
    {
        cout << shortestDistance[i] << " ";
    }

    return 0;
}
